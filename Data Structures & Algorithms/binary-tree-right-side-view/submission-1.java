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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverseRight(root, result);
        return result;
    }

    public void traverseRight(TreeNode node, List<Integer> intList) {

        // if (node == null) return;
        // intList.add(node.val);
        // if(node.right != null) {
        //     traverseRight(node.right, intList);
        // } else {
        //     traverseRight(node.left, intList);
        // }
        if (node == null) return;
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.add(node);
        while (!nodeQ.isEmpty()) {
            List<TreeNode> nodeList = new ArrayList<>();
            while (!nodeQ.isEmpty()) {
                TreeNode temp = nodeQ.remove();
                if (temp.left != null ) nodeList.add(temp.left);
                if (temp.right != null ) nodeList.add(temp.right);

                if (nodeQ.isEmpty()) intList.add(temp.val);

            }
            for(TreeNode tn : nodeList) {
                nodeQ.add(tn);
            }

        }


    }
}
