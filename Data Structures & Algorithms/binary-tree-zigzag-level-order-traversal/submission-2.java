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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        int level=0;
        q.offer(root);
        while(!q.isEmpty()){
            ans.add(new ArrayList<>());
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                ans.get(level).add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            if(level%2!=0){
                Collections.reverse(ans.get(level));
            }
            level+=1;
        }
        return ans;
    }
}