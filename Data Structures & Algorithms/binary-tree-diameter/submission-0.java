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
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int l=dfs(root.left);
        int r=dfs(root.right);
    
        return Math.max(diameter,l+r);

    }
    int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int l=dfs(node.left);
        int r=dfs(node.right);
        diameter=Math.max(diameter,l+r);
        return 1+Math.max(l,r);
    }
}
