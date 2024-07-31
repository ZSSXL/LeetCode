package com.zss.code.easy;

/**
 * @author ZSS
 * @date 2022/6/13 15:23
 * @desc 26 -- 删除有序数组中的重复项
 * -- 注意要求原地修改
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums2 = {1, 1, 2};
        int result = removeDuplicates(nums);
        System.out.println("Result: " + result);
        printList(nums);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1){
            return 1;
        }

        int currentIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i] && (currentIndex += 1) != i){
                nums[currentIndex] = nums[i];
            }
        }

        return currentIndex + 1;
    }

    private static void printList(int[] nums){
        for (int num : nums) {
            System.out.print(" " + num);
        }
    }
}
