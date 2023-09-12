package DataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    private Node root;

    class Node {
        public Map<Character, Node> children;
        public boolean isEndOfWord;

        public Node() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

    /**
     * Inserts a character into the trie.
     * @param word
     */
    public void insert(String word) {
        Node currNode = this.root;

        for (char c : word.toCharArray()) {
            if (!currNode.children.containsKey(c))
                currNode.children.put(c, new Node());
            currNode = currNode.children.get(c);
        }
        currNode.isEndOfWord = true;
    }

    /**
     * Inserts a word into the trie.
     *
     * @param word the word to be inserted.
     */
    public void recursiveInsert(String word) {
        recursiveInsert(this.root, word);
    }

    /**
     * Helper function to insert a word into the trie recursively.
     *
     * @param node the current node.
     * @param word the remaining characters of the word.
     */
    private void recursiveInsert(Node node, String word) {
        if (word.length() == 0) {
            node.isEndOfWord = true;
            return;
        }

        char c = word.charAt(0);
        Node child = node.children.get(c);

        if (child == null) {
            child = new Node();
            node.children.put(c, child);
        }

        recursiveInsert(child, word.substring(1));
    }

    /**
     * Search for a specific word in the trie.
     *
     * @param word the word to search for.
     * @return true if the word exists in the trie, false otherwise.
     */
    public Node search(String word) {
        return search(this.root, word);
    }

    private Node search(Node node, String word) {
        if (word.length() == 0)
            return node.isEndOfWord ? node : null;

        char c = word.charAt(0);
        Node child = node.children.get(c);

        if (child == null)
            return null;
        return search(child, word.substring(1));
    }

    /**
     * Autocomplete a prefix to find all words that start with prefix.
     *
     * @param prefix the prefix to autocomplete.
     * @return a list of all words that start with the given prefix.
     */
    public List<String> autocomplete(String prefix) { // "abo"

        Node currNode = this.root;

        for (char c : prefix.toCharArray()) {
            Node child = currNode.children.get(c);

            if (child == null)
                return new ArrayList<>();

            currNode = child;
        }

        return searchStartWith(currNode, new StringBuilder(prefix));
    }

    private List<String> searchStartWith(Node node, StringBuilder prefix) {
        List<String> results = new ArrayList<>();

        if (node.isEndOfWord)
            results.add(prefix.toString());

        for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
            // 1st: "abou", 2nd: "abor"
            prefix.append(entry.getKey());

            // 1st: ["abort"], 2nd: ["about"]
            results.addAll(searchStartWith(entry.getValue(), prefix));

            // 1st: "abou" -> "abo", 2nd: "abor" -> "abo"
            prefix.deleteCharAt(prefix.length() - 1);
        }
        return results;
    }
}
