package DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSSearch {

    class Node {
        public int data;
        public boolean visited;
        ArrayList<Node> children;

        public Node(int data) {
            this.data = data;
            this.visited = false;
            this.children = new ArrayList<>();
        }
    }

    public void bfs(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            currentNode.visited = true;

            for (Node child : currentNode.children) {
                queue.add(child);
            }
        }
    }
}
