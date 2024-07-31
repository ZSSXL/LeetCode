package com.zss.code.medium;

import java.util.Stack;

/**
 * @author ZSS
 * @date 2022/1/6 9:24
 * @desc 71 -- 简化路径
 */
public class SimplifyPath_71 {

    public static void main(String[] args) {
        String path = "../";
        String path1 = "/../";
        String path2 = "/home/";
        String path3 = "/home//foo/";
        String path4 = "/a/./b//../../c/";
        String path5 = "home";
        String path6 = "/a//b////c/d//././/..";
        String path7 = "/../";
        String result = simplifyPathV2(path7);
        System.out.println(result);

    }

    public static String simplifyPathV2(String path){
        Stack<String> stack = new Stack<>();

        String[] split = path.split("/");
        for (String str : split) {
            if ("".equals(str) || ".".equals(str)) {
                continue;
            }

            // 后退
            if ("..".equals(str)) {
                if (stack.size() != 0){
                    stack.pop();
                }
                continue;
            }
            stack.push(str);
        }

        StringBuilder sb = new StringBuilder();
        for (String str : stack) {
            sb.append("/").append(str);
        }
        // 如果内容为空，则需要输出"/"
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }

    public static String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for (int i = 0; i < path.length(); i++) {
            char curChar = path.charAt(i);
            if (sb.length() == 0){
                sb.append("/");
            }
            char topChar = sb.charAt(sb.length() - 1);
            if (curChar == '.') {
                // 两者相等，回退到上一个 /
                if (topChar == curChar) {
                    int index = sb.lastIndexOf("/");
                    if (index == -1){
                        sb.deleteCharAt(sb.length() - 1);
                        sb.append("/");
                        continue;
                    }
                    sb.delete(index, sb.length());
                    continue;
                }
                if (topChar == '/'){
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(curChar);
                    continue;
                }
            }
            if (curChar == '/') {
                if (curChar == topChar) {
                    continue;
                }
                if (topChar == '.'){
                    sb.deleteCharAt(sb.length() - 1);
                    continue;
                }
            }
            sb.append(curChar);
        }
        if (sb.length() == 1 || sb.length() == 0) {
            return "/";
        }
        return sb.charAt(sb.length() - 1) == '/' ? sb.substring(0, sb.length() - 1) : sb.toString();
    }
}
