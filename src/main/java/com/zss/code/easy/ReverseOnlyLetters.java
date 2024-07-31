package com.zss.code.easy;

/**
 * @author ZSS
 * @date 2022/2/23 16:29
 * @desc 917 -- 仅仅反转字母
 */
public class ReverseOnlyLetters {

    public static void main(String[] args) {
        String s = "Test1ng-Leet=code-Q!";
        // a-z 97->122 A-Z 65->90
    }

    public static String reverseOnlyLetters(String s) {
        int j = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(Character.isLetter(s.charAt(i))) {
                while(!Character.isLetter(s.charAt(j))) {
                    j--;
                }
                sb.append(s.charAt(j--));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
