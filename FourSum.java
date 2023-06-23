
//Question 2
//        Given an array nums of n integers, return an array of all the unique quadruplets
//        [nums[a], nums[b], nums[c], nums[d]] such that:
//        ● 0 <= a, b, c, d < n
//        ● a, b, c, and d are distinct.
//        ● nums[a] + nums[b] + nums[c] + nums[d] == target
//
//        You may return the answer in any order.
//
//        Example 1:
//        Input: nums = [1,0,-1,0,-2,2], target = 0
//        Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

package ppt_assignment3;

import java.util.*;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4)
            return result;

        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1])
                            left++;

                        while (left < right && nums[right] == nums[right - 1])
                            right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> result = fourSum(nums, target);

        System.out.println(result);
    }
}
