package ImplementTrie;

import java.util.HashMap;

class Trie {

    private Node root;

    class Node {
        private HashMap<Character, Node> children;
        private boolean isEndOfWord;

        public Node() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {

        insert(this.root, word);
    }

    private void insert(Node node, String word) {

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
        insert(child, word.substring(1));
    }

    public boolean search(String word) {
        return search(this.root, word);
    }

    private boolean search(Node node, String word) {

        if (node == null)
            return false;

        if (word.length() == 0)
            return node.isEndOfWord ? true : false;

        char c = word.charAt(0);
        Node child = node.children.get(c);

        if (child == null)
            return false;

        return search(child, word.substring(1));
    }

    public boolean startsWith(String prefix) {

        Node currNode = this.root;

        if (currNode == null)
            return false;

        for (char c : prefix.toCharArray()) {
            Node child = currNode.children.get(c);

            if (child == null)
                return false;
            currNode = child;
        }

        return true;
    }
}