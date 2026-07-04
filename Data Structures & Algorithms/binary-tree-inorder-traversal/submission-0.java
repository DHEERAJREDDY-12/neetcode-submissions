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
    List<Integer> ans=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return Arrays.asList();
        }
        
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
        return ans;
    }
    void dfs(TreeNode node){
        if(node==null){
            return;
        }
        
        dfs(node.left);
        ans.add(node.val);
        dfs(node.right);

    }
}