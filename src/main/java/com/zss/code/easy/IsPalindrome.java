package com.zss.code.easy;

/**
 * @author zhoushs@dist.com.cn
 * @date 2021/12/6 13:35
 * @desc 9 -- 回文数
 */
public class IsPalindrome {

    public static void main(String[] args) {
        int n1 = -1;
        int n2 = 123454321;
        int n3 = 12344321;
        boolean palindrome = isPalindromeV2(n3);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String target = String.valueOf(x);
        int length = target.length();
        int pre;
        int next;
        if (length % 2 == 1) {
            pre = Integer.parseInt(target.substring(0, (length + 1) / 2));
            String nextStr = target.substring((length + 1) / 2 - 1);
            next = Integer.parseInt(new StringBuffer(nextStr).reverse().toString());
        } else {
            pre = Integer.parseInt(target.substring(0, length / 2));
            String nextStr = target.substring(length / 2);
            next = Integer.parseInt(new StringBuffer(nextStr).reverse().toString());
        }
        System.out.println(pre + ":" + next);
        return pre == next;
    }

    public static boolean isPalindromeV2(int x) {
        if (x < 0) {
            return false;
        }
        String target = String.valueOf(x);
        int length = target.length();

        int flag = length % 2;

        String pre = target.substring(0, (length + flag) / 2);
        String nextStr = target.substring((length + flag) / 2 - flag);
        String next = new StringBuffer(nextStr).reverse().toString();
        return pre.equals(next);
    }
}
