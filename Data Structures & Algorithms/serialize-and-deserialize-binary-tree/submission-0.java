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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        traverseAndSerialize(root, res);
        return res.toString();
    }

    public void traverseAndSerialize(TreeNode node, StringBuilder result) {
        if(node == null) {
            result.append("N,");
            return;
        }
        result.append(node.val+ ",");
        traverseAndSerialize(node.left,result);
        traverseAndSerialize(node.right,result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArray = data.split(",");
        return traverseAndConstruct(strArray, new int[]{0});
    }

    public TreeNode traverseAndConstruct(String[] strArray, int[] currentIndex) {
        if (strArray[currentIndex[0]].equals("N")) return null;
        TreeNode nd = new TreeNode(Integer.parseInt(strArray[currentIndex[0]]));
        currentIndex[0]+=1;
        nd.left = traverseAndConstruct(strArray, currentIndex);
        currentIndex[0]+=1;
        nd.right = traverseAndConstruct(strArray, currentIndex);
        return nd;
    }
}
