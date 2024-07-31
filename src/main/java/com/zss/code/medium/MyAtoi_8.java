package com.zss.code.medium;

/**
 * @author zhoushs@dist.com.cn
 * @date 2021/11/30 16:59
 * @desc 8 -- 字符串转换整数
 */
public class MyAtoi_8 {

    public static void main(String[] args) {
        int maxValue = Integer.MAX_VALUE;

        String s1 = "4193 with words";
        String s2 = "words and 987";
        String s3 = "-91283472332";
        String s4 = " -42";
        String s5 = ".1";
        String s6 = " ";
        String s7 = "-";
        String s8 = "+-1";
        int result = myAtoi(s6);
        System.out.println(result);
    }

    public static int myAtoiV2(String s) {
        return 0;
    }

    public static int myAtoi(String s) {
        String trim = s.trim();
        if (trim.length() == 0){
            return 0;
        }

        if (trim.length() >= 2){
            char c1 = trim.charAt(0);
            char c2 = trim.charAt(1);
            if (!(c1 >= '0' && c1 <= '9')){
                if (!(c2 >= '0' && c2 <= '9')){
                    return 0;
                }
            }
        }

        boolean negative = false;

        if(trim.charAt(0) == '-'){
            trim = trim.substring(1);
            negative = true;
        }

        if (trim.length() == 0){
            return 0;
        }

        if (trim.charAt(0) == '+'){
            trim = trim.substring(1);
        }

        int start = 0;
        int noInt = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < trim.length(); i++) {
            char ch = trim.charAt(i);
            if (ch >= '0' && ch <= '9' && 0 <= start) {
                sb.append(ch);
                start++;
            } else if (start > 0){
                start = -1;
            } else {
                noInt++;
            }
            if (noInt >= 1 && sb.length() == 0){
                return 0;
            }
        }

        int result;
        try{
            if (sb.length() == 0){
                return 0;
            }
            result = Integer.parseInt(sb.toString());
            if (negative){
                result = -result;
            }
        } catch (Exception e){
            if (negative){
                result = Integer.MIN_VALUE;
            } else {
                result = Integer.MAX_VALUE;
            }
        }
        return result;
    }

}
