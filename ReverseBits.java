/*
Reverse bits of a given 32 bits unsigned integer.

Note:
Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
Example 1:

Input: n = 00000010100101000001111010011100
Output:    964176192 (00111001011110000010100101000000)
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
*/ 
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n){
        int result = 0;
        
        for (int i = 0; i < 32; i++){
            //Left shift result to make space for the next bit
            result <<= 1;

            //Add the least significant bit of n to result
            result |= (n & 1);

            //Right shift n to process the next bit
            n >>>= 1; // unsigned right shift
        }
        return result;
    }
}
