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
    boolean is=true;
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int l=dfs(root.left);
        int r=dfs(root.right);
        if(Math.abs(l-r)>1){
            return false;
        }
        if(is){
            return true;
        }
        return false;
    }
    int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int l=dfs(node.left)+1;
        int r=dfs(node.right)+1;
        if(Math.abs(l-r)>1){
            if(is){
                is=false;
            } 
        }
        return Math.max(l,r);

    }
}
