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
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) return null;

        // ListNode result = new ListNode();
        // for(int i = 1; i < lists.length; i++) {
        //     lists[i] = merge2List(lists[i-1], lists[i]);

        // }
        // return lists[lists.length - 1];
    
        return merge(lists, 0 , lists.length - 1);

    }

    public ListNode merge(ListNode[] lists, int start, int end) {
        if (start >= end) return lists[start];

        int mid = start + (end - start)/2;
        ListNode left = merge(lists, start, mid);
        ListNode right = merge(lists, mid+1, end);

        return merge2List(left, right);

    }

    public ListNode merge2List(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode temp = result;
        while (l1 != null && l2 != null) {

            if (l1.val > l2.val) {
                temp.next = l2;
                l2 = l2.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }

        while(l1 != null) {
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
        while(l2 != null) {
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        return result.next;
    }
}
