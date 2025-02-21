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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode merge_list = null;
        ListNode trv = null;;
        ListNode l1 = list1;
        ListNode l2 = list2;
        while(l1 != null && l2!= null){
            if(l1.val <= l2.val){
                if(merge_list == null){
                    merge_list = new ListNode(l1.val,null);
                    trv = merge_list;
                }
                else{
                    trv.next = new ListNode(l1.val,null);
                    trv = trv.next;
                }
                l1 = l1.next;
            }
            else{
                if(merge_list == null){
                    merge_list = new ListNode(l2.val,null);
                    trv = merge_list;
                }
                else{
                    trv.next = new ListNode(l2.val,null);
                    trv = trv.next;
                }
                l2 = l2.next;
            }
        }
        //came out of loop due to l1 is null
        if(l1 == null){
            while(l2 != null){
                if(merge_list == null){
                    merge_list = new ListNode(l2.val,null);
                    trv = merge_list;
                }
                else{
                    trv.next = new ListNode(l2.val,null);
                    trv = trv.next;
                }
                l2 = l2.next;
            }
        }
        //came out of loop due to l2 is null
        if(l2 == null){
            while(l1 != null){
                if(merge_list == null){
                    merge_list = new ListNode(l1.val,null);
                    trv = merge_list;
                }
                else{
                    trv.next = new ListNode(l1.val,null);
                    trv = trv.next;
                }
                l1 = l1.next;
            }
        }
        return merge_list;
    }
}
