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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;
        int list_size = 0;
        ListNode trv = head;
        while(trv != null){
            list_size++;
            trv = trv.next;
        } 
        int count = list_size - n;
        trv = head;
        if(count == 0)  //deletion at beg 
        {
            head = head.next;
            return head;
        }
        while(count > 1){
            count--;
            trv = trv.next;
        }
        trv.next = trv.next.next;
        return head;
    }
}
