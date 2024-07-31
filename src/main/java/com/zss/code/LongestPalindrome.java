package com.zss.code;

/**
 * @author ZSS
 * @date 2021/11/25 17:33
 * @desc 给你一个字符串 s，找到 s 中最长的回文子串
 * todo 先搁着
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";
        String s3 = "ac";
        String s4 = "bb";
        String s5 = "aaaa";
        String s6 = "qwertttrewq";
        String s7 = "adam";
        String result = longestPalindrome(s7);
        System.out.println(result);
    }


    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        if (s.length() % 2 == 0) {
            s += " ";
        }
        return funOne(s);
    }

    public static String funOne(String s) {
        StringBuilder result = new StringBuilder();
        char[] target = parse(s);
        // 从第二个开始
        for (int i = 1; i < target.length; i++) {
            StringBuilder tempSb = new StringBuilder();
            tempSb.append(target[i]);
            for (int j = i + 1; j <= (2 * i) && j < target.length; j++) {
                int preIndex = 2 * i - j;
                if (target[preIndex] == target[j]) {
                    tempSb.insert(0, target[preIndex]);
                    tempSb.append(target[j]);
                } else if (target[i] == target[j]) {
                    tempSb.append(target[j]);
                } else {
                    break;
                }
            }
            if (result.length() < tempSb.length()) {
                result = tempSb;
            }
        }
        if (result.length() == 0 || String.valueOf(target[0]).equals(result.toString())) {
            result.append(target[0]);
        }
        return result.toString();
    }

    public static String funTwo(String s) {
        StringBuilder result = new StringBuilder();
        char[] target = parse(s);
        // 从第一个开始
        for (int i = 0; i < target.length; i++) {
            StringBuilder tempSb = new StringBuilder();
            int limit = (i == 0 ? 1 : (2 * i + 1));
            for (int j = i + 1; j <= limit && j < target.length; j++) {
                int preIndex = 2 * i - j + 1;
                if (target[preIndex] == target[j]) {
                    tempSb.insert(0, target[preIndex]);
                    tempSb.append(target[j]);
                }
            }
            if (result.length() < tempSb.length()) {
                result = tempSb;
            }
        }
        if (result.length() == 0) {
            result.append(target[0]);
        }
        return result.toString();
    }

    public static char[] parse(String source) {
        char[] result = new char[source.length()];
        for (int i = 0; i < source.length(); i++) {
            result[i] = source.charAt(i);
        }
        return result;
    }
}
