package medium;

/**
 * Created by huangxiangyu on 2016/12/2.
 */
/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].
*/

import java.util.ArrayList;
import java.util.List;
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
public class BTIT { //  Binary Tree Inorder Traversal
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        java.util.Stack<TreeNode> stack = new Stack<TreeNode>();
        java.util.List<Integer> list = new ArrayList<Integer>();
        if (root != null) {
            pushMethod(stack, root);
        }
        while (!stack.isEmpty()) {
            TreeNode thisNode = stack.pop();
            list.add(thisNode.val);
            if (thisNode.right != null) {
                pushMethod(stack, thisNode.right);
            }
        }
        return list;
    }
    private void pushMethod(Stack<TreeNode> stack, TreeNode root) {
        TreeNode node = root;
        stack.push(node);
        while (node.left != null) {
            node = node.left;
            stack.push(node);
        }
    }
}