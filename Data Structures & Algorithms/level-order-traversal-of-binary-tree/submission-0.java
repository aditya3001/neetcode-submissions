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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        nodeQueue.add(root);

        while(!nodeQueue.isEmpty()) {
            List<TreeNode> nodeList = new ArrayList<>();
            List<Integer> levelList = new ArrayList<>();
            while(!nodeQueue.isEmpty()) {
                TreeNode temp = nodeQueue.remove();
                levelList.add(temp.val);
                if (temp.left != null) nodeList.add(temp.left);
                if (temp.right != null) nodeList.add(temp.right);

            }
            result.add(levelList);
            for(TreeNode nd : nodeList){
                nodeQueue.add(nd);
            }

        }

        return result;


        
    }
}
