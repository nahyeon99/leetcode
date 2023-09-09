package BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    List<Integer> rightNodes = new ArrayList<Integer>();
    int depth = -1;

    public List<Integer> rightSideView(TreeNode root) {
        searchTree(root);
        return rightNodes;
    }

    private void searchTree(TreeNode node) {

        depth++;

        if (node == null)
            return;

        if (rightNodes.size() == depth)
            rightNodes.add(node.val);

        searchTree(node.right);
        depth--;

        searchTree(node.left);
        depth--;
    }
}