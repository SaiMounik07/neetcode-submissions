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
    public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            right(list,0,root);
            return list;
    }
    public void right(List<Integer> list, int l, TreeNode root){
        if(root == null) return ;
        if(l == list.size()) list.add(root.val);
        right(list,l+1,root.right);
        right(list,l+1,root.left);
    }
}
