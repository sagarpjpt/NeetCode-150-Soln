/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
*/ 

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
    public ListNode reverseKGroup(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        ListNode trv = head;

        while(trv != null){
            list.add(trv.val);
            trv = trv.next;
        }

        int len = list.size();
        int arr[] = new int[len];
        int no_of_groups = len / k;

        int arr_ind = 0;
        for(int i = 1;i <= no_of_groups;i++){
            int list_ind = i * k;
            int group_size = k;
            while(group_size > 0){
                arr[arr_ind++] = list.get(--list_ind);
                group_size--;
            }
        }

        int remaining_ind = no_of_groups * k;
        while(arr_ind < len)
            arr[arr_ind++] = list.get(remaining_ind++);

        ListNode root = null;
        trv = root;
        for(int i = 0;i < len;i++){
            if(root == null){
                root = new ListNode(arr[i]);
                trv = root;
            }
            else{
                trv.next = new ListNode(arr[i]);
                trv = trv.next;
            }
        }

        return root;

    }
}
