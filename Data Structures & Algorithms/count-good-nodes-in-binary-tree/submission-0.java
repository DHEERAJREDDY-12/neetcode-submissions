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
    int count=1;
    public int goodNodes(TreeNode root) {
        if(root.left==null&&root.right==null){
            return 1;
        }
        dfs(root.left,root.val);
        dfs(root.right,root.val);
        return count;
    }
    void dfs(TreeNode node,int max){
        if(node==null){
            return;
        }
        if(node.val>=max){
            count++;
            max=Math.max(max,node.val);
        }
        dfs(node.left,max);
        dfs(node.right,max);
        return;
        
    }
}
