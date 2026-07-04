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
    boolean ans=false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null&&targetSum==0){
            return false;
        }
        if(root==null){
            return false;
        }
        if(root.val==targetSum&&root.left==null&&root.right==null){
            return true;
        }
        dfs(root.left,root.val,targetSum);
        dfs(root.right,root.val,targetSum);
        return ans;
    }
    void dfs(TreeNode node,int sum,int targetSum){
        if(node==null){
            return;
        }
        if(node.val+sum==targetSum){
            if(!ans&&node.left==null&&node.right==null){
                ans=true;
                return;
            }
            
        }
        dfs(node.left,node.val+sum,targetSum);
        dfs(node.right,node.val+sum,targetSum);
        
    }
}