package com.zss.code.medium;

/**
 * @author zhoushs@dist.com.cn
 * @date 2021/12/6 16:14
 * @desc 12 -- 整数转罗马数字
 */
public class IntToRoman_12 {

    public static void main(String[] args) {
        System.out.println(intToRoman(99999));
    }

    public static String intToRoman(int num) {
        // 所有可能的取值
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        // 对应的罗马数字表示
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length && num > 0; i++) {
            int value = values[i];
            String roman = romans[i];
            while (num >= value) {
                num -= value;
                result.append(roman);
            }
        }
        return result.toString();
    }
}
