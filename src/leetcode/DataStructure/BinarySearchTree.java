package leetcode.DataStructure;

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BinarySearchTree {

    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public Node search(int data) {
        return searchRecursively(this.root, data);
    }

    private Node searchRecursively(Node node, int data) {
        if (node == null)
            return null;
        if (node.data == data)
            return node;

        if (data < node.data)
            return searchRecursively(node.left, data);

        return searchRecursively(node.right, data);
    }

    public void insert(int data) {
        this.root = insertRecursively(this.root, data);
    }

    private Node insertRecursively(Node node, int data) {
        if (node == null)
            return new Node(data);

        if (data < node.data) {
            node.left = insertRecursively(node.left, data);
        } else {
            node.right = insertRecursively(node.right, data);
        }
        return node;
    }

    public Node delete (int data) {
        return deleteRecursively(this.root, data);
    }

    private Node deleteRecursively(Node node, int data) {
        if (node == null)
            return null;

        if (data < node.data) {
            node.left = deleteRecursively(node.left, data);
        } else if (data > node.data){
            node.right = deleteRecursively(node.right, data);
        } else if (data == node.data) {
            // CASE 1: leaf node를 삭제하는 경우
            if (node.left == null && node.right == null)
                return null;
            // CASE 2: 자식 노드가 하나인 노드를 삭제하는 경우
            else if (node.left == null)
                return node.right; // 조부모인 노드와 오른쪽 자식 노드만 연결될 수 있게 한다.
            else if (node.right == null)
                return node.left;
            // CASE 3: 자식 노드가 두 개인 노드를 삭제하는 경우
            else {
                Node prevNode = findMaxInLeftSubtree(node.left);
                node.data = prevNode.data;
                node.left = deleteRecursively(node.left, prevNode.data);
            }
        }
        return node;
    }

    private Node findMaxInLeftSubtree(Node node) {
        if (node.right != null)
            return findMaxInLeftSubtree(node.right);
        return node;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Searching 40: " + (bst.search(40) != null));
        System.out.println("Searching 100: " + (bst.search(100) != null));

        bst.delete(20);
        System.out.println("Searching 20 after delete: " + (bst.search(20) != null));

        bst.delete(30);
        System.out.println("Searching 30 after delete: " + (bst.search(30) != null));

        bst.delete(50);
        System.out.println("Searching 50 after delete: " + (bst.search(50) != null));
    }
}
