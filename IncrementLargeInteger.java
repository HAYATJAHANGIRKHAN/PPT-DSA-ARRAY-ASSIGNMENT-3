

//💡 **Question 5**
//        You are given a large integer represented as an integer array digits, where each
//        digits[i] is the ith digit of the integer. The digits are ordered from most significant
//        to least significant in left-to-right order. The large integer does not contain any
//        leading 0's.
//
//        Increment the large integer by one and return the resulting array of digits.
//
//        **Example 1:**
//        Input: digits = [1,2,3]
//        Output: [1,2,4]
//
//        **Explanation:** The array represents the integer 123.
//        Incrementing by one gives 123 + 1 = 124.
//        Thus, the result should be [1,2,4].



package ppt_assignment3;

public class IncrementLargeInteger {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Iterate through the digits in reverse order
        for (int i = n - 1; i >= 0; i--) {
            // Increment the current digit by one
            digits[i]++;

            // If the digit is less than 10, no need to carry over
            if (digits[i] < 10) {
                return digits;
            }

            // If the digit is 10, set it to 0 and carry over to the next digit
            digits[i] = 0;
        }

        // If all digits are 9, a carry over is needed
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        IncrementLargeInteger incrementLargeInteger = new IncrementLargeInteger();
        int[] digits = {1, 2, 3};
        int[] result = incrementLargeInteger.plusOne(digits);
        System.out.print("Result: ");
        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }
}
