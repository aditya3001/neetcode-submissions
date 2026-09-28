/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        Node copyHead = new Node(0);
        Node current = head;
        Node currentCopy = copyHead;

        while (current != null) {
            Node temp = new Node(current.val);
            currentCopy.next = temp;
            currentCopy = temp;
            nodeMap.put(current, currentCopy);
            current = current.next;
        }
        current = head;
        currentCopy = copyHead.next;

        while (current != null) {
            Node randomTemp = current.random;
            if (randomTemp != null) {
                currentCopy.random = nodeMap.get(randomTemp);

            }
            current = current.next;
            currentCopy = currentCopy.next;
        }
        return copyHead.next;
        
        
    }
}
