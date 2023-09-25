package leetcode.MinimumAbsoluteDifferenceInBST;

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

    int min = 100000, prev = 100001;

    public int getMinimumDifference(TreeNode root) {

        searchTree(root);
        return min;
    }
// 탐색 순서: 4 -> 2 -> 1 -> 2 -> 3 -> 4 -> 6
    private void searchTree(TreeNode node) {

        if (node == null)
            return;

        searchTree(node.left);
        if (prev != 100001)
            min = Math.min(min, Math.abs(prev - node.val));
        prev = node.val;

        searchTree(node.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode ll = new TreeNode(1);
        TreeNode lr = new TreeNode(3);
        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode r = new TreeNode(6);
        TreeNode root = new TreeNode(4, l, r);

        s.getMinimumDifference(root);
    }
}