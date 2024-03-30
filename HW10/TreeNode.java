package hw10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {

        this.val = val;

        this.left = left;

        this.right = right;

    }
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int level_size = queue.size();
            ArrayList<Integer> level_values = new ArrayList<>();

            for (int i = 0; i < level_size; i++) {
                TreeNode node = queue.poll();
                level_values.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(level_values);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);

        System.out.println(levelOrder(root));  // Output: [[3], [9, 20], [15, 7]]
    }
}

