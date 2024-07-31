package com.zss.code.easy;

/**
 * @author zhoushs@dist.com.cn
 * @date 2021/11/30 16:20
 * @desc 7. 整数反转
 */
public class IntReverse {

    public static void main(String[] args) {
        int i = 1534236469;
        int reverse = reverse(i);
        System.out.println(reverse);
    }

    public static int reverse(int x) {
        boolean flag = x < 0;
        x = (x < 0) ? -x : x;
        String num = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            sb.append(num.charAt(i));
        }
        int result;
        try{
            result = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e){
            return 0;
        }
        return flag ? -result : result;
    }
}
