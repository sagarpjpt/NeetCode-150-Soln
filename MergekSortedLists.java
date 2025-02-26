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
 // k way merging brute force
        /*
        ListNode sorted_list = null;
        ListNode trv = null;
        int null_lists = 0;
        int non_empty_list_index = -1;
        int index;
        int min;
        while(null_lists != lists.length-1){
            min = Integer.MAX_VALUE;
            index = -1;
            null_lists = 0;
            for(int i = 0;i<lists.length;i++){
                if(lists[i] == null){
                    null_lists++;
                    continue;
                }
                else
                    non_empty_list_index = i;
                if(lists[i].val < min){
                    min = lists[i].val;
                    index = i;
                }
            }
            if(sorted_list == null){
                sorted_list = lists[index];
                trv = sorted_list;
            }
            else{
                trv.next = lists[index];
            }
            trv = trv.next;
            lists[index] = lists[index].next;
        }
        while(lists[non_empty_list_index] != null){
            if(sorted_list == null){
                sorted_list = lists[non_empty_list_index];
                trv = sorted_list;
            }
            else
                trv.next = lists[non_empty_list_index];
            trv = trv.next;
            lists[non_empty_list_index] = lists[non_empty_list_index].next;
        }
        return sorted_list;
        */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        DAC(lists,0,lists.length-1);
        return lists[0];
    }
    public void DAC(ListNode lists[],int low,int high){
        if(low<high){
            int mid = low + (high - low)/2;
            DAC(lists,low,mid);
            DAC(lists,mid+1,high);
            merge(lists,low,mid);
        }
    }
    public void merge(ListNode lists[],int low,int mid){
        ListNode merge_list = null;
        ListNode trv = null;
        int i = low,j = mid+1;
        while(lists[i] != null && lists[j] != null){
            if(lists[i].val < lists[j].val){
                if(merge_list == null){
                    merge_list = lists[i];
                    trv = merge_list;
                }
                else{
                    trv.next = lists[i];
                    trv = trv.next;
                }
                lists[i] = lists[i].next;
            }
            else{
                if(merge_list == null){
                    merge_list = lists[j];
                    trv = merge_list;
                }
                else{
                    trv.next = lists[j];
                    trv = trv.next;
                }
                lists[j] = lists[j].next;
            }
        }
        if(lists[i] == null){
            while(lists[j] != null){
                if(merge_list == null){
                    merge_list = lists[j];
                    trv = merge_list;
                }
                else{
                    trv.next = lists[j];
                    trv = trv.next;
                }
                lists[j] = lists[j].next;
            }
        }
        if(lists[j] == null){
            while(lists[i] != null){
                if(merge_list == null){
                    merge_list = lists[i];
                    trv = merge_list;
                }
                else{
                    trv.next = lists[i];
                    trv = trv.next;
                }
                lists[i] = lists[i].next;
            }
        }
        lists[i] = merge_list;
    }
}
