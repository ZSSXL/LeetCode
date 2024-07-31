package com.zss.code.easy;

/**
 * @author ZSS
 * @date 2022/2/9 15:40
 * @desc 2006 -- 差的绝对值为k的数对数目
 */
public class CountKDifference {

    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        int k = 1;
        int result = countKDifference(nums, k);
        System.out.println(result);
    }

    public static int countKDifference(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (abs(nums[i] - nums[j]) == k) {
                    result++;
                }
            }
        }
        return result;
    }

    private static int abs(int para) {
        return para * (1 - ((para >>> 31) << 1));
    }
}
