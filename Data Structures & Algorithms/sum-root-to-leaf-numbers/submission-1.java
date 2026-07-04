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
    int ans=0;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return root.val;
        }
        dfs(root.left,root.val);
        dfs(root.right,root.val);
        return ans;

    }
    void dfs(TreeNode node,int sum){
        if(node==null){
            return;
        }
        if(node.left==null&&node.right==null){
            ans+=(sum*10+node.val);
        }
        int nsum=10*sum+node.val;
        dfs(node.left,nsum);
        dfs(node.right,nsum);
        return;
    }
}