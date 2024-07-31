package com.zss.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhoushs@dist.com.cn
 * @date 2021/11/25 16:14
 * @desc 给定一个字符串 s ，请你找出其中不含有重复字符的 【最长子串】 的长度
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "pwwkew";
        String s2 = "dvdf";
        String s3 = "aab";
        String s4 = "adbcfb";
        int i = lengthOfLongestSubstringV3(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<String> set = new HashSet<>(s.length());
        int maxLength = 0;
        int firstIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String temp = String.valueOf(ch);
            if (set.contains(temp)) {
                maxLength = maxLength >= set.size() ? maxLength : set.size();
                set.clear();
                i = firstIndex;
                continue;
            }
            if (set.size() == 0){
                firstIndex = i;
            }
            set.add(temp);
        }
        return maxLength >= set.size() ? maxLength : set.size();
    }

    public static int lengthOfLongestSubstringV2(String s) {
        Map<String, Integer> map = new HashMap<>(s.length());
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String temp = String.valueOf(ch);
            if (map.containsKey(temp)) {
                maxLength = maxLength >= map.size() ? maxLength : map.size();
                i = map.get(temp);
                map.clear();
                continue;
            }
            map.put(temp, i);
        }
        return maxLength >= map.size() ? maxLength : map.size();
    }

    // todo 写的什么玩意儿
    public static int lengthOfLongestSubstringV3(String s) {
        char[] cs = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cs[i] = s.charAt(i);
        }
        int maxLength = 0;
        int preIndex = 0;
        Set<String> set = new HashSet<>(s.length());
        for (int i = 0; i < s.length(); i++){
            String s1 = String.valueOf(cs[i]);
            if (!set.contains(s1)){
                set.add(s1);
                int curIndex = s.indexOf(cs[i], preIndex + 1) - 1;
                // 有重复的字符串
                while (curIndex != -1){
                    int cul = curIndex - preIndex;
                    maxLength = maxLength >= cul ? maxLength : cul;
                    preIndex = curIndex;
                    curIndex = s.indexOf(cs[i], preIndex + 1);
                }
            }
        }
         return maxLength;
    }
}
