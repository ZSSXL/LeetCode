package com.zss.code.easy;

/**
 * @author ZSS
 * @date 2021/12/7 9:47
 * @desc 14 -- 最长公共前缀
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};
        String[] strs3 = {};
        String result = longestCommonPrefixV2(strs1);
        System.out.println(result);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        String first = strs[0];
        outer:
        while (first.length() != 0) {
            String firstCh = first.substring(0, 1);
            first = first.substring(1);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].indexOf(firstCh) != 0) {
                    break outer;
                } else if (i == strs.length - 1) {
                    sb.append(firstCh);
                }
                strs[i] = strs[i].substring(1);
            }
        }
        return sb.toString();
    }

    public static String longestCommonPrefixV2(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        String first = strs[0];
        StringBuilder sb = new StringBuilder();

        out:
        for (int i = 1; i <= first.length(); i++) {
            String firstCh = first.substring(0, i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].indexOf(firstCh) != 0) {
                    break out;
                } else if (j == strs.length - 1) {
                    sb.replace(0, i - 1, firstCh);
                }
            }
        }
        return sb.toString();
    }
}
