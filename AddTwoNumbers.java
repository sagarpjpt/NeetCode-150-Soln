/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode trv1 = l1, trv2 = l2;
        ListNode res = null, trv = null;
        

        while (trv1 != null && trv2 != null){
            int sum = trv1.val + trv2.val + carry;
            if(sum > 9){
                carry = sum /10;
                sum = sum % 10;
            }
            else carry = 0;
            
            if(res == null){
                res = new ListNode(sum);
                trv = res;
            }
            else{
                trv.next = new ListNode(sum);
                trv = trv.next;
            }
            trv1 = trv1.next; 
            trv2 = trv2.next;
        }

        while(trv1 != null){
            int sum = trv1.val + carry;
            if(sum > 9){
                carry = sum /10;
                sum = sum % 10;
            }
            else carry = 0;
            
            if(res == null){
                res = new ListNode(sum);
                trv = res;
            }
            else{
                trv.next = new ListNode(sum);
                trv = trv.next;
            }
            trv1 = trv1.next;
        }

        while(trv2 != null){
            int sum = trv2.val + carry;
            if(sum > 9){
                carry = sum /10;
                sum = sum % 10;
            }
            else carry = 0;
            
            if(res == null){
                res = new ListNode(sum);
                trv = res;
            }
            else{
                trv.next = new ListNode(sum);
                trv = trv.next;
            }
            trv2 = trv2.next;
        }

        if(carry != 0)
            trv.next = new ListNode(carry);

        return res;
    }
}
