package com.zss.code;

/**
 * @author ZSS
 * @date 2021/11/25 9:41
 * @desc 两数之和 -- 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(nums, target);
        System.out.println("[" + ints[0] + ", " + ints[1] + "]");
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

    public int[] twoSumV2(int[] nums, int target) {
        return new int[]{};
    }
}
