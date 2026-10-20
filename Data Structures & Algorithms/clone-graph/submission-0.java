/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        return traverseAndClone(node, new HashMap<>());
        
    }

    public Node traverseAndClone(Node node, HashMap<Node,Node> nodeMap) {
        if (node == null) {
            return null;
        }
        if (nodeMap.containsKey(node)) {
            return nodeMap.get(node);
        }

        ArrayList<Node> nCopy = new ArrayList<>();
        Node copy = new Node(node.val, nCopy);
        nodeMap.put(node, copy);
        for(Node n : node.neighbors) {

            if (nodeMap.containsKey(n)) {
                nCopy.add(nodeMap.get(n));
                continue;
            }
            nCopy.add(traverseAndClone(n, nodeMap));
        }
        return copy;
    }

    
}