
//Question 1
//        Given an integer array nums of length n and an integer target, find three integers
//        in nums such that the sum is closest to the target.
//        Return the sum of the three integers.
//
//        You may assume that each input would have exactly one solution.
//
//        Example 1:
//        Input: nums = [-1,2,1,-4], target = 1
//        Output: 2
//
//        Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)

package ppt_assignment3;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array in ascending order
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize closestSum to the sum of the first three elements

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1; // Pointer for the element to the right of nums[i]
            int right = nums.length - 1; // Pointer for the last element in the array

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right]; // Calculate the sum of three elements

                if (currentSum == target) {
                    return currentSum; // If the sum is equal to the target, return it immediately
                }

                // Update closestSum if the current sum is closer to the target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++; // If the current sum is less than the target, move the left pointer to the right
                } else {
                    right--; // If the current sum is greater than the target, move the right pointer to the left
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        ThreeSumClosest solution = new ThreeSumClosest();
        int result = solution.threeSumClosest(nums, target);
        System.out.println(result);
    }
}
