package medium;

/**
 * Created by huangxiangyu on 2016/12/2.
 */
/*
Given a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BTRSV { //  Binary Tree Right Side View
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public java.util.List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new java.util.ArrayList<Integer>();
        }
        java.util.Queue<TreeNode> queue1 = new java.util.LinkedList<TreeNode>();
        java.util.Queue<TreeNode> queue2 = new java.util.LinkedList<TreeNode>();
        java.util.List<Integer> res = new java.util.ArrayList<Integer>();
        queue1.add(root);
        TreeNode node = new TreeNode(0);
        while (true) {
            if (queue2.isEmpty() && !queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    node = (TreeNode)queue1.poll();
                    if (null != node.left) {
                        queue2.add(node.left);
                    }
                    if (null != node.right) {
                        queue2.add(node.right);
                    }
                }
                res.add(node.val);
            } else if (queue1.isEmpty() && !queue2.isEmpty()) {
                while (!queue2.isEmpty()) {
                    node = (TreeNode)queue2.poll();
                    if (null != node.left) {
                        queue1.add(node.left);
                    }
                    if (null != node.right) {
                        queue1.add(node.right);
                    }
                }
                res.add(node.val);
            } else {
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode node_7 = new TreeNode(7);
        TreeNode node_8 = new TreeNode(8);
        TreeNode node_9 = new TreeNode(9);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(5, node_7, node_8);
        TreeNode node_6 = new TreeNode(6, null, node_9);
        TreeNode node_2 = new TreeNode(2, node_4, node_5);
        TreeNode node_3 = new TreeNode(3, null, node_6);
        TreeNode node_1 = new TreeNode(1, node_2, node_3);
        java.util.List<Integer> ls = new BTRSV().rightSideView(node_1);
        for (int i = 0; i < ls.size(); i++) {
            System.out.print(ls.get(i) + " ");
        }
    }
}
