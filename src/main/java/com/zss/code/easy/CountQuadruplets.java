package com.zss.code.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZSS
 * @date 2021/12/29 9:52
 * @desc 1995 -- 统计特殊四元组
 */
public class CountQuadruplets {

    private static List<String> list = new ArrayList<>();
    private static int count;

    public static void main(String[] args) {
        // 4
        int[] nums = {1, 1, 1, 3, 5};
        int[] nums2 = {1, 2, 3, 6};
        quickSort(nums, 0, nums.length - 1);
        int i = countQuadruplets(nums);
        System.out.println(count);
    }

    public static int countQuadruplets(int[] nums) {
        return 0;
    }

    public static List<String> generateParenthesisV2(int n) {
        helper("", n, n);
        return list;
    }

    public static void helper(String str, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if (left > 0) {
            helper(str + "(", left - 1, right);
        }
        if (right > left) {
            helper(str + ")", left, right - 1);
        }
    }

    /**
     * 快速排序
     *
     * @param target 排序对象
     * @param left   左边 -> 默认左边第一个为基准点
     * @param right  右边
     */
    public static void quickSort(int[] target, int left, int right) {
        // 当左哨兵小于右哨兵时，进行下一步
        if (left < right) {
            // 基准点
            int datum = target[left];
            // 左哨兵
            int i = left;
            // 右哨兵
            int j = right;

            int temp;

            while (i < j) {
                // 从右往左，找到小于基准点的位置
                while (target[j] >= datum && i < j) {
                    j--;
                }
                // 从左往右，找到大于基准点的位置
                while (target[i] <= datum && i < j) {
                    i++;
                }
                // 都准备就绪后，开始进行交换，如果i和j相等，就没必要交换
                if (i < j) {
                    temp = target[i];
                    target[i] = target[j];
                    target[j] = temp;
                }
            }
            // 当i和j相遇时，将left位置与i位置交换，i位置与基准点交换
            target[left] = target[i];
            target[i] = datum;

            // 快速排序左边部份
            quickSort(target, left, i - 1);
            // 快速排序右边部份
            quickSort(target, i + 1, right);
        }
    }
}
