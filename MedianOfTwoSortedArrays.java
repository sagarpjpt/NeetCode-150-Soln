/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).
Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
*/ 

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int merged[] = new int[len1 + len2];
        int i = 0,j = 0, k = 0;

        while(i < len1 && j < len2){
            if(nums1[i] < nums2[j])
                merged[k++] = nums1[i++];
            else
                merged[k++] = nums2[j++];
        }

        while(i < len1)
            merged[k++] = nums1[i++];
        while(j < len2)
            merged[k++] = nums2[j++];

        int len = len1 + len2;
        if( len % 2 != 0) 
            return (double) merged[len/2]; //length of list is odd
        else 
            return (double) (merged[len/2] + merged[len/2 - 1]) / 2;
    }
}
