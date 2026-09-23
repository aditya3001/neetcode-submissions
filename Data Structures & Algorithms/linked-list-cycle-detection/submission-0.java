/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head.next;

        while (fast != null && fast != slow) {
            fast = fast.next;
            slow = slow.next;

            if (fast != null) {
                System.out.println("Here");
                fast = fast.next;
                }
        }

        if (fast == null) return false;
        return true;
        
        
    }
}
