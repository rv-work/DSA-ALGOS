class Solution {
    public long lastInteger(long longN) {
        long first = 1;
        long len = longN;
        long gap = 1;

        while (len > 1) {

            // Left side delete round
            len = (len + 1) / 2;
            gap *= 2;

            if (len > 1) {

                // Right side delete round
                if (len % 2 == 0) {
                    first += gap;
                }

                len = (len + 1) / 2;
                gap *= 2;
            }
        }

        return first;
    }
}









// Approach
// The current sequence can be kept track by three variables:
// a. first is the first number in the sequence
// b. len is the count of numbers in the sequence
// c. gap is the gap between adjacent numbers in the sequence
// Start doing operations while maintaining the sequence:
// a. Because we delete every second number, each operation multiplies the gap between numbers by 2. gap *= 2
// b. For every 2 numbers in the sequence, we will delete one of them in an operation. Therefore, we keep ⌈ 
// 2
// len
// ​
//  ⌉ elements after an operation.len = (len + 1) / 2
// c. The first number moves to the next number if and only if it is Operation 2 and the sequence has even length. This can be proven by casework.
// It is trivial that Operation 1 will not move the first number because it deletes every second number starting from the left.
// If the length is odd, Operation 2 will not delete the first number. ex: [1,2,3,4,5], Operation 2 deletes [4,2]
// If the length is even, Operation 2 will delete the first number. ex: [1,2,3,4], Operation 2 deletes [3,1]
// if(len % 2 == 0) start += gap; (for Operation 2)
// Keep doing left and right operations until len = 1. The last remaining number will be first.
// Complexity
// Time complexity: O(logn)
// Space complexity: O(1)