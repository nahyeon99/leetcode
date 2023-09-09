package AverageofLevelsinBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public List<Double> averageOfLevels(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>(List.of(root));
        List<Double> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            double queueSize = queue.size(), depthSum = 0;

            for (int i = 0; i < queueSize; i++) {
                TreeNode currNode = queue.poll();
                depthSum += currNode.val;

                if (currNode.left != null)
                    queue.offer(currNode.left);
                if (currNode.right != null)
                    queue.offer(currNode.right);
            }
            result.add(depthSum / queueSize);
        }
        return result;
    }
}
