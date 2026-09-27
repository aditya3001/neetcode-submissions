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
    public void reorderList(ListNode head) {
        int len = 0;
        ListNode current = head;
        ListNode temp = null;
        while (current != null) {
            current = current.next;
            len++;
        }

        int breakIndex = (len + 1)/2;
        current = head;
        // System.out.println("BreakIndex : " + breakIndex);

        while (breakIndex != 0) {
            breakIndex--;
            if (breakIndex == 0) {
                temp = current;
                current = current.next;
                temp.next = null;
                continue;
            }
            current = current.next;

        }

        current = reverseNodeList(current);
        // System.out.println(current.next.val);

        head = mergeNodeList(head, current);

    }

    public ListNode reverseNodeList(ListNode head) {

        ListNode prev = null;
        ListNode current = head, next = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;

    }

    public ListNode mergeNodeList(ListNode head1, ListNode head2){

        ListNode current1 = head1.next, current2 = head2;
        ListNode current = head1;

        while (current1 != null && current2 != null)  {
            current.next = current2;
            current2 = current2.next;
            current = current.next;
            current.next = current1;
            current1 = current1.next;
            current = current.next;

        }
        if (current1 != null) {
            current.next = current1;
        }
        if (current2 != null) {
            current.next = current2;
        }

        return head1;

    }
}
