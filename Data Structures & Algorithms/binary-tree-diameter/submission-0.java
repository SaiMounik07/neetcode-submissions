/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] c = new int[1];
         findSum(root,c);
         return c[0];

    }
    public int findSum(TreeNode root,int[] c){
        if(root == null) return 0;
        int l = findSum(root.left,c);
        int r = findSum(root.right,c);
        c[0] = Math.max(c[0],l+r);
        return 1+Math.max(l,r);
    
    }
}
