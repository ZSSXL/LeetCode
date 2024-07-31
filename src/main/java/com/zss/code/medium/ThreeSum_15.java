package com.zss.code.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZSS
 * @date 2021/12/7 10:53
 * @desc 15 -- 三数之和
 */
public class ThreeSum_15 {

    public static void main(String[] args) {
        int[] n1 = {-1, 0, 1, 2, -1, -4};
        // [-1,-1,2],[-1,0,1]
        int[] n2 = {-1, 0, 1, 1};
        int[] n3 = {-10, -10, -5, -4, -4, 0, 2, 2, 4, 4, 5, 6, 8, 10};
        int[] n4 = {0, 0, 0};
        int[] n5 = {1,-1,-1,0};
        int[] n6 = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        long start = System.currentTimeMillis();
        List<List<Integer>> result = threeSumV2(n6);
        long end = System.currentTimeMillis();
        printResult(result);
        System.out.println((end - start) + "ms");
    }

    public static List<List<Integer>> threeSumV3(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSumV2(int[] nums){
        int length = nums.length;

        if (length < 3) {
            return new ArrayList<>();
        }

        quickSort(nums, 0, length - 1);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i >= 1 && nums[i] == nums[i - 1]){
                continue;
            }

            int x = i + 1, y = length - 1;

            while(x < length - 1){
                if(x > i + 1 && nums[x] == nums[x - 1]){
                    x++;
                    continue;
                }

                if (nums[y] < 0 || x == y){
                    // 都是负数了 -- 重置
                    x++;
                    y = length - 1;
                    continue;
                }

                if (y <= length - 2 && nums[y] == nums[y + 1]){
                    y--;
                    continue;
                }

                int sum = sum(nums[i], nums[x], nums[y]);
                if (sum == 0){
                    List<Integer> temp = Arrays.asList(nums[i], nums[x], nums[y]);
                    result.add(temp);
                    // 符合 -- 重置
                    x++;
                    y = length - 1;
                } else {
                    y--;
                }
            }
        }

        return result;
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        quickSort(nums, 0, nums.length - 1);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            int x = i + 1, y = nums.length - 1;

            while(x < nums.length - 1){
                if (nums[y] < 0){
                    // 都是负数了 -- 重置
                    x++;
                    y = nums.length - 1;
                    continue;
                }

                if (x == y){
                    // 到头了 -- 重置
                    x++;
                    y = nums.length - 1;
                    continue;
                }

                int sum = sum(nums[i], nums[x], nums[y]);
                if (sum == 0){
                    List<Integer> temp = Arrays.asList(nums[i], nums[x], nums[y]);
                    result.add(temp);
                    // 符合 -- 重置
                    x++;
                    y = nums.length - 1;
                } else {
                    y--;
                }
            }
        }

        return result.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 快速排序
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

    public static void printList(int[] nums) {
        for (int i : nums) {
            System.out.print(i + "\t");
        }
        System.out.println("\n--------------------------");
    }

    public static void printResult(List<List<Integer>> result){
        for (List<Integer> list : result){
            for (Integer temp : list){
                System.out.print(temp + "\t");
            }
            System.out.println("");
        }
    }

    public static int sum(int a, int b, int c){
        return a + b + c;
    }
}
