package DataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class DFSSearch {

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

    // tree 의 오른쪽 sublist 부터 탐색
    public void dfsFromRightSublist(Node node) {

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.empty()) {
            Node currentNode = stack.pop();
            currentNode.visited = true;

            for (Node child : currentNode.children) {
                stack.push(child);
            }
        }
    }

    // tree 의 왼쪽 sublist 부터 탐색
    public void dfsFromLeftSublist(Node node) {

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.empty()) {
            Node currentNode = stack.pop();
            currentNode.visited = true;

            for (int i = currentNode.children.size() - 1; i >= 0; i--) {
                stack.push(currentNode.children.get(i));
            }
        }
    }

    // 재귀를 활용한 탐색
    public void dfsRecursively(Node node) {
        node.visited = true;

        for (Node child : node.children) {
            if (!child.visited)
                dfsRecursively(child);
        }
    }

    // HashMap 데이터를 받는 dfs
    public ArrayList<String> dfs(HashMap<String, ArrayList<String>> graph, String startNode) {

        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        needVisit.add(startNode);

        while (needVisit.size() > 0) {
            String node = needVisit.remove(needVisit.size() - 1);
            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }
        return visited;
    }
}
