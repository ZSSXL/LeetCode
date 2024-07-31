package com.zss.code.medium;

/**
 * @author zhoushs@dist.com.cn
 * @date 2021/12/6 15:08
 * @desc 11 -- 盛最多水的容器
 */
public class MaxArea_11 {

    public static void main(String[] args) {
        int[] n1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] n2 = {1, 1};
        int[] n3 = {4, 3, 2, 1, 4};
        int[] n4 = {1, 2, 1};
        int result = maxAreaV2(n1);
        System.out.println(result);
    }

    /**
     * 指针解法
     */
    public static int maxAreaV2(int[] height) {
        int maxArea = 0;
        int head = 0;
        int tail = height.length - 1;
        while (head < tail) {
            int source = height[head], target = height[tail];
            maxArea = Math.max(maxArea, Math.min(source, target) * (tail - head));
            if (source <= target) {
                head++;
            } else {
                tail--;
            }
        }
        return maxArea;
    }

    /**
     * 暴力解法，会超时
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int source = height[i], target = height[j];
                int x, y;
                x = Math.min(source, target);
                y = j - i;
                int tempArea = x * y;
                if (tempArea >= maxArea) {
                    maxArea = tempArea;
                }
            }
        }
        return maxArea;
    }

    public static int maxValueIndex(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
}
