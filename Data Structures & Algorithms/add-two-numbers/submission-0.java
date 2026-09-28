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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode current = result;
        ListNode current1 = l1, current2 = l2;
        int remain = 0;
        int sum = 0;
        while (current1 != null && current2 != null) {
            sum = current1.val + current2.val + remain;
            remain = sum/10;
            sum = sum%10;
            ListNode curVal = new ListNode(sum);
            current.next = curVal;
            current = current.next;
            current1 = current1.next;
            current2 = current2.next;
        }

        while (current1 != null) {
            sum = current1.val + remain;
            remain = sum/10;
            sum = sum%10;
            ListNode curVal = new ListNode(sum);
            current.next = curVal;
            current = current.next;
            current1 = current1.next;

        }
        while (current2 != null) {
            sum = current2.val + remain;
            remain = sum/10;
            sum = sum%10;
            ListNode curVal = new ListNode(sum);
            current.next = curVal;
            current = current.next;
            current2 = current2.next;

        }
        if (remain != 0) {
            ListNode curVal = new ListNode(remain);
            current.next = curVal;
            current = current.next;
        }

        return result.next;
        
    }
}
