package com.zss.code.easy;

import java.util.*;

/**
 * @author ZSS
 * @date 2021/12/8 17:33
 * @desc 20 -- 有效的括号
 */
public class BracketsIsValid {

    /**
     * 执行耗时:1 ms,击败了98.92% 的Java用户
     * 内存消耗:36.1 MB,击败了95.89% 的Java用户
     */
    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "{[]}";
        String s3 = "(]";
        String s4 = "){";
        String s5 = "(([]){})";
        String s6 = "([{]})";

        boolean result = isValidV4(s6);
        System.out.println(result);
    }

    public static boolean isValidV4(String s) {
        char[] stack = new char[s.length()];
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            if (index == 0) {
                // 入栈
                stack[index] = s.charAt(i);
                index++;
                continue;
            }
            if (stack[index - 1] == '(' && s.charAt(i) == ')'){
                // 出栈
                index--;
            } else if (stack[index - 1] == '{' && s.charAt(i) == '}') {
                // 出栈
                index--;
            } else if (stack[index - 1] == '[' && s.charAt(i) == ']') {
                // 出栈
                index--;
            } else {
                // 入栈
                stack[index] = s.charAt(i);
                index++;
            }
        }
        return index == 0;
    }

    public static boolean isValidV3(String s) {
        char[] stack = new char[s.length()];
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            if (index == 0) {
                stack[index] = s.charAt(i);
                index++;
                continue;
            }
            String topChar = String.valueOf(stack[index - 1]);
            String value = BRACKETS_MAP.get(String.valueOf(s.charAt(i)));
            if (!topChar.equals(value)) {
                // 入栈
                stack[index] = s.charAt(i);
                index++;
            } else {
                // 出栈
                index--;
            }
        }
        return index == 0;
    }

    public static boolean isValidV2(String s) {
        List<String> stack = new ArrayList<>(s.length() / 2);
        for (int i = 0; i < s.length(); i++){
            int index = stack.size();
            String curChar = String.valueOf(s.charAt(i));
            if (index == 0) {
                stack.add(curChar);
                continue;
            }
            String topChar = String.valueOf(stack.get(index - 1));
            String value = BRACKETS_MAP.get(curChar);
            if (!topChar.equals(value)) {
                // 入栈
                stack.add(curChar);
            } else {
                // 出栈
                stack = stack.subList(0, index - 1);
            }
        }
        return stack.size() == 0;
    }

    public static boolean isValid(String s) {
        if (s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }
        StringBuilder sb = new StringBuilder(s.length() / 2);
        for (int i = 0; i < s.length(); i++) {
            int length = sb.length();
            if (sb.length() == 0) {
                sb.append(s.charAt(i));
                continue;
            }
            String topChar = String.valueOf(sb.charAt(sb.length() - 1));
            String value = BRACKETS_MAP.get(String.valueOf(s.charAt(i)));
            if (!topChar.equals(value)) {
                // 入栈
                sb.append(s.charAt(i));
            } else {
                // 出栈
                sb.delete(sb.length() - 1, sb.length());
            }
        }
        return sb.length() == 0;
    }

    private static final Map<String, String> BRACKETS_MAP = new HashMap<String, String>(3) {{
        put(")", "(");
        put("}", "{");
        put("]", "[");
    }};
}
