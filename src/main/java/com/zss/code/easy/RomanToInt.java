package com.zss.code.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoushs@dist.com.cn
 * @date 2021/12/6 16:43
 * @desc 13 -- 罗马数字转整数
 */
public class RomanToInt {

    public static void main(String[] args) {
        String s1 = "MCMXCIV";
        // 1994
        String s2 = "LVIII";
        String s3 = "IX";
        int result = romanToInt(s1);
        System.out.println(result);
    }

    public static int romanToInt(String s) {
        String temp = s;

        int result = 0;
        while (temp.length() > 0) {
            if (temp.length() >= 2) {
                String b = temp.substring(0, 2);
                if (roman.containsKey(b)) {
                    result += roman.get(b);
                    temp = temp.substring(2);
                    continue;
                }
            }
            String a = temp.substring(0, 1);
            if (roman.containsKey(a)) {
                result += roman.get(a);
                temp = temp.substring(1);
            }
        }
        return result;
    }

    private final static Map<String, Integer> roman = new HashMap<String, Integer>() {{
        put("M", 1000);
        put("CM", 900);
        put("D", 500);
        put("CD", 400);
        put("C", 100);
        put("XC", 90);
        put("L", 50);
        put("XL", 40);
        put("X", 10);
        put("IX", 9);
        put("V", 5);
        put("IV", 4);
        put("I", 1);
    }};
}
