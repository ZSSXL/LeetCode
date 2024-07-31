package com.zss.code.medium;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZSS
 * @date 2022/6/13 9:41
 * @desc 16 -- 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在恰好一个解。
 */
public class ThreeSumClosest_16 {

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};
        int target = 1;
        int result = threeSumClosest(nums, target);
        System.out.println("Result: " + result);
    }

    public static int threeSumClosest(int[] nums, int target) {
        int length = nums.length;

        // 差值大于零的部份
        LinkedHashMap<Integer, Integer> listUpZero = new LinkedHashMap<>();
        // 差值小于零的部份
        LinkedHashMap<Integer, Integer> listDownZero = new LinkedHashMap<>();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length && j != i; j++) {
                for (int k = 0; k < length && k != j; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int result = target - sum;
                    if (result == 0) {
                        return sum;
                    } else if (result < 0) {
                        listDownZero.put(result, sum);
                    } else {
                        listUpZero.put(result, sum);
                    }
                }
            }
        }

        List<Map.Entry<Integer, Integer>> upList = new ArrayList<>(listUpZero.entrySet());
        // 升序
        upList.sort(Map.Entry.comparingByKey());

        List<Map.Entry<Integer, Integer>> downList = new ArrayList<>(listDownZero.entrySet());
        //降序排序
        downList.sort((o1, o2) -> o2.getKey().compareTo(o1.getKey()));

        if (upList.size() == 0) {
            return downList.get(0).getValue();
        } else if (downList.size() == 0) {
            return upList.get(0).getValue();
        } else {
            Integer down = downList.get(0).getKey();
            Integer up = upList.get(0).getKey();
            return up > -down ? downList.get(0).getValue() : upList.get(0).getValue();
        }
    }
}
