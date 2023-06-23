
//Question 7
//        You are given an inclusive range [lower, upper] and a sorted unique integer array
//        nums, where all elements are within the inclusive range.
//
//        A number x is considered missing if x is in the range [lower, upper] and x is not in
//        nums.
//
//        Return the shortest sorted list of ranges that exactly covers all the missing
//        numbers. That is, no element of nums is included in any of the ranges, and each
//        missing number is covered by one of the ranges.
//
//        Example 1:
//        Input: nums = [0,1,3,50,75], lower = 0, upper = 99
//        Output: [[2,2],[4,49],[51,74],[76,99]]
//
//        Explanation: The ranges are:
//        [2,2]
//        [4,49]
//        [51,74]
//        [76,99]


package ppt_assignment3;

import java.util.*;


public class MissingRanges {
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        // Handle the case where the lower bound is higher than the first element
        if (lower < nums[0]) {
            result.add(rangeToString(lower, nums[0] - 1));
        }

        // Iterate through the nums array and find missing ranges
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1] && nums[i] + 1 < nums[i + 1]) {
                result.add(rangeToString(nums[i] + 1, nums[i + 1] - 1));
            }
        }

        // Handle the case where the upper bound is lower than the last element
        if (upper > nums[nums.length - 1]) {
            result.add(rangeToString(nums[nums.length - 1] + 1, upper));
        }

        return result;
    }

    private static String rangeToString(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        } else {
            return start + "->" + end;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;

        List<String> missingRanges = findMissingRanges(nums, lower, upper);

        System.out.println(missingRanges);
    }
}
