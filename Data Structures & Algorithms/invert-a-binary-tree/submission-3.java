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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode lef=dfs(root.left);
        TreeNode rig=dfs(root.right);
        root.left=rig;
        root.right=lef;
        return root;
    }
    TreeNode dfs(TreeNode node){
        if(node==null){
            return null;
        }
        TreeNode l=dfs(node.left);
        TreeNode r=dfs(node.right);
        node.left=r;
        node.right=l;
        return node;
    }
}
