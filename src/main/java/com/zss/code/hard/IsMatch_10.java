package com.zss.code.hard;

/**
 * @author zhoushs@dist.com.cn
 * @date 2021/12/6 14:51
 * @desc 10 -- 正则表达式匹配
 */
public class IsMatch_10 {

    public static void main(String[] args) {
        String s1 = "zhoushs";
        boolean matches = s1.matches("(z.*)");

        System.out.println(matches);
    }

    public static boolean isMatch(String s, String p) {
        return s.matches("(" + p + ")");
    }
}
