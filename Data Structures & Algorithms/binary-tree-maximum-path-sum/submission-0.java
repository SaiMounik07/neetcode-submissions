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
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        path(root,max);
        return max[0];
        
    }
    public int path(TreeNode root,int[] ma){
        if(root == null) return 0;
        int lm = path(root.left,ma);
        int rm = path(root.right,ma);
        if(lm<0) lm =0;
        if(rm<0) rm =0;
        ma[0] = Math.max(ma[0],lm+rm+root.val);
        return root.val+Math.max(lm,rm);
    }
    
}
