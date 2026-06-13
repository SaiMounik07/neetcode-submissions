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
    public int goodNodes(TreeNode root) {
        Stack<Pair<TreeNode,Integer>> st = new Stack<>();
        st.push(new Pair(root,root.val));
        int c = 0;
        while(!st.isEmpty()){
            Pair<TreeNode,Integer> p = st.pop();
            TreeNode curr = p.getKey();
            Integer m = p.getValue();
            if(curr.val >= m){
                m = curr.val;
                c++;
            }
            if(curr.right != null) st.push(new Pair(curr.right,m));
            if(curr.left != null) st.push(new Pair(curr.left,m));
        }
return c;
    }
}
