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
    public ListNode reverseList(ListNode head) {
        //linked list have onlye one node or empty list;
        if(head == null || head.next == null) return head;
        //list have more than one node
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        while(curr.next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        head = curr;
        return head;
    }
}
