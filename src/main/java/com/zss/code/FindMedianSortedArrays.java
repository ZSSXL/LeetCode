package com.zss.code;

/**
 * @author zhoushs@dist.com.cn
 * @date 2021/11/26 9:38
 * @desc 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数。
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] a = {1, 3};
        int[] b = {2};
        double medianSortedArrays = findMedianSortedArrays(a, b);
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] merge = new int[totalLength];
        addAll(nums1, merge, 0);
        addAll(nums2, merge, nums1.length);
        quickSort(merge, 0, totalLength - 1);

        if (totalLength % 2 != 1){
            return (merge[totalLength / 2 - 1] + merge[totalLength / 2] + 0.0) / 2;
        } else {
            return (merge[(totalLength - 1) / 2]);
        }
    }

    public static void addAll(int[] source, int[] target, int startIndex){
        System.arraycopy(source, 0, target, startIndex, source.length);
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
