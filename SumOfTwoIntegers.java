/*
Given two integers a and b, return the sum of the two integers without using the operators + and -.
Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5
*/ 
class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        StringBuilder res = new StringBuilder("");
        for(int i = 0; i < 32;i++){
            int x = a & 1;  //gives 1 if unit place has 1 in binary and 0 if 0
            int y = b & 1;  //same as above
            int sum = x ^ y ^ carry;
            carry = (x & y) | (y & carry) | (carry & x);
            a >>= 1;    // right shift to move next bit to unit place
            b >>= 1;    // same as above
            res.append(sum);
        }
        String strBin =  res.reverse().toString();
        return Integer.parseUnsignedInt(strBin, 2); // conversion binary string to respective decimal number
        //used parseUnsignedInt doesn't care about signs.
        //It treats the binary string as an unsigned 32-bit number
    }
}
