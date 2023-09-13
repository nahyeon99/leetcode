package DesignAddAndSearchWordsDataStructure;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {

    private Node root;

    class Node {
        HashMap<Character, Node> children;
        boolean isEndOfWord;

        public Node() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {

        addWord(this.root, word);
    }

    private void addWord(Node node, String word) {
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
        addWord(child, word.substring(1));
    }

    public boolean search(String word) {

        return searchStartWith(this.root, word);
    }

    private boolean searchStartWith(Node node, String word) {
        if (word.length() == 0)
            return node.isEndOfWord;

        char c = word.charAt(0);

        if (c == '.') {
            for(Map.Entry<Character, Node> entry : node.children.entrySet()) {
                boolean result = searchStartWith(entry.getValue(), word.substring(1));

                if (result)
                    return result;
            }
            return false;
        }

        Node child = node.children.get(c);

        if (child == null)
            return false;

        return searchStartWith(child, word.substring(1));
    }
}