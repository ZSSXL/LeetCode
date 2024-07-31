package com.zss.code.medium;

/**
 * @author ZSS
 * @date 2022/6/14 11:18
 * @desc 498 -- 对角线遍历
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 */
public class FindDiagonalOrder_498 {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int[][] mat2 = {{1, 2, 3}};
        int[] result = findDiagonalOrder(mat2);
        printList(result);
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        // 高度
        int high = mat.length;
        if (high == 1) {
            return mat[0];
        }
        // 宽度
        int width = mat[0].length;

        int length = high * width;

        // 结果
        int[] result = new int[length];

        // 方向
        boolean upOrDown = true;

        int m = 0, n = 0;

        int current = 0;

        while (current < length) {
            result[current] = mat[m][n];
            current++;
            if (upOrDown) {
                n += 1;
                m -= 1;
                if (outOfBind(n, width)) {
                    m += 2;
                    n -= 1;
                    upOrDown = false;
                } else if (outOfBind(m, high)) {
                    m += 1;
                    upOrDown = false;
                }
            } else {
                n -= 1;
                m += 1;
                if (outOfBind(m, high)) {
                    n += 2;
                    m -= 1;
                    upOrDown = true;
                } else if (outOfBind(n, width)) {
                    n += 1;
                    upOrDown = true;
                }
            }
        }
        return result;
    }

    /**
     * 是否越界
     *
     * @param current 当前
     * @param border  边界
     * @return true：越界； false: 合格
     */
    private static boolean outOfBind(int current, int border) {
        return (current < 0 || current > (border - 1));
    }

    /**
     * 打印
     *
     * @param t target
     */
    private static void printList(int[] t) {
        for (int item : t) {
            System.out.print(" " + item);
        }
    }
}
