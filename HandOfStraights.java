/*
You are given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize.
You want to rearrange the cards into groups so that each group is of size groupSize, and card values are consecutively increasing by 1.
Return true if it's possible to rearrange the cards in this way, otherwise, return false.
Example 1:
Input: hand = [1,2,4,2,3,5,3,4], groupSize = 4
Output: true
Explanation: The cards can be rearranged as [1,2,3,4] and [2,3,4,5].
Example 2:
Input: hand = [1,2,3,3,4,5,6,7], groupSize = 4
Output: false
*/ 
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num : hand){
            if(count.containsKey(num)) count.put(num, count.get(num) + 1);
            else count.put(num, 1);
        }   

        Arrays.sort(hand); // instead of min heap just sort the input array
        for (int num : hand) {
            if (count.get(num) > 0) {
                for (int i = num; i < num + groupSize; i++) {
                    if (count.getOrDefault(i, 0) == 0) return false;
                    count.put(i, count.get(i) - 1);
                }
            }
        }
        return true;
    }
}
