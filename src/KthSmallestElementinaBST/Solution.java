package KthSmallestElementinaBST;

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

    int cnt = 0, prev = -1;
    public int kthSmallest(TreeNode root, int k) {
        searchTree(root, k);
        return prev;
    }

    private void searchTree(TreeNode node, int k) {

        if (node == null)
            return;

        searchTree(node.left, k);

        if (cnt >= k)
            return;

        cnt++;
        prev = node.val;
        searchTree(node.right, k);
    }
}