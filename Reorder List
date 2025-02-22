class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ArrayList<ListNode> arr = new ArrayList<>();    //array of LinkedList nodes
        ListNode trv = head;
        //storing address of each ListNode object (i.e. linked list node address) to arraylist
        //i.e. kind of ListNode* arr[];//arr is an array and each ele of array is pointer to ListNode 
        while(trv != null){
            arr.add(trv);
            trv = trv.next;
        }
        int low = 0,high = arr.size()-1;
        while(low < high){
            arr.get(low).next = arr.get(high);
            low++;
            if(low == high) break;
            arr.get(high).next = arr.get(low);
            high--;
        }
        arr.get(low).next = null;
    }
}
