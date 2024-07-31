package com.zss.code.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ZSS
 * @date 2021/12/30 9:48
 * @desc 846 -- 一手顺子
 */
public class IsNStraightHand_846 {

    public static void main(String[] args) {
        int groupSize = 1;
        // 3
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        // 4
        int[] hand2 = {1, 2, 3, 4, 5};
        // 2
        int[] hand3 = {2, 1};

        int[] hand4 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

        boolean result = isNStraightHand(hand4, groupSize);
        System.out.println(result);
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        quickSort(hand, 0, hand.length - 1);
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : hand){
            list.add(i);
            set.add(i);
        }

        if (set.size() == 1){
            return true;
        }

        while (list.size() != 0){
            Integer start = list.get(0);
            for (int i = start; i < groupSize + start; i++) {
                int index = list.indexOf(i);
                if (index == -1) {
                    return false;
                } else {
                    list.remove(index);
                }
            }
        }
        return true;
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
