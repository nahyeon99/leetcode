package ImplementTrie;

// Runtime 37ms, Memory 55.2MB
class Trie2 {

    private Node root;

    public Trie2() {
        this.root = new Node();
    }

    public void insert(String word) {
        root.insert(word, 0);
    }

    public boolean search(String word) {
        return root.search(word, 0);
    }

    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }

    class Node {
        private Node[] nodes;
        private boolean isEndOfWord;

        public Node() {
            nodes = new Node[26];
        }

        private void insert(String word, int idx) {
            if (idx >= word.length())
                return;

            int i = word.charAt(idx) - 'a';
            if (nodes[i] == null)
                nodes[i] = new Node();

            if (idx == word.length() - 1)
                nodes[i].isEndOfWord = true;

            nodes[i].insert(word, idx + 1);
        }

        private boolean search(String word, int idx) {

            if (idx >= word.length())
                return false;

            Node node = nodes[word.charAt(idx) - 'a'];
            if (node == null)
                return false;
            if (idx == word.length() - 1 && node.isEndOfWord)
                return true;

            return node.search(word, idx + 1);
        }

        private boolean startsWith(String prefix, int idx) {
            if (idx >= prefix.length())
                return false;

            Node node = nodes[prefix.charAt(idx) - 'a'];

            if (node == null)
                return false;
            if (idx == prefix.length() - 1)
                return true;

            return node.startsWith(prefix, idx + 1);
        }
    }
}