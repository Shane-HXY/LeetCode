package medium;

/**
 * Created by huangxiangyu on 2016/12/2.
 */
/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
*/

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class VBST {    //  Validate Binary Search Tree
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isValidBST(TreeNode root) {
        java.util.Stack<TreeNode> stack = new Stack<TreeNode>();
        java.util.List<Integer> list = new java.util.ArrayList<Integer>();
        if (root != null) {
            pushMethod(stack, root);
        }
        while (!stack.isEmpty()) {
            TreeNode anode = stack.pop();
            list.add(anode.val);
            if (anode.right != null) {
                pushMethod(stack, anode.right);
            }
        }
        for (int i = 1; i < list.size(); i++) {
            int ii = list.get(i);
            int basei = list.get(i-1);
            if (Integer.valueOf(ii).compareTo(Integer.valueOf(basei)) != 1) {
                return false;
            }
        }
        return true;
    }

    public void pushMethod(Stack<TreeNode> stack, TreeNode node) {
        stack.push(node);
        while (node.left != null) {
            node = node.left;
            stack.push(node);
        }
    }
}
