package com.zss.code.easy;

/**
 * @author ZSS
 * @date 2022/1/5 9:09
 * @desc 1576 -- 替换所有的问号
 */
public class ModifyString {

    public static void main(String[] args) {
        // a -> z == 97 -> 122
        String str = "j?qg??b";
        String str2 = "?";
        String result = modifyString(str2);
        System.out.println(result);
    }

    public static String modifyString(String s) {
        if (s.length() == 1){
            return "a";
        }
        StringBuilder sb = new StringBuilder(s);
        int index = sb.indexOf("?");
        while (index != -1){
            char cur = sb.charAt(index);
            if (index == 0){
                char last = sb.charAt(index + 1);
                char c = unSame(last, cur);
                sb.replace(index, index + 1, String.valueOf(c));
            }else if (index == sb.length() - 1){
                char pre = sb.charAt(index - 1);
                char c = unSame(pre, cur);
                sb.replace(index, index + 1, String.valueOf(c));
            } else {
                char pre = sb.charAt(index - 1);
                char last = sb.charAt(index + 1);
                char c = unSame(pre, last, cur);
                sb.replace(index, index + 1, String.valueOf(c));
            }
            index = sb.indexOf("?");
        }
        return sb.toString();
    }

    public static char unSame(int index, int cur){
        for (int i = 97; i <= 122; i++){
            if (i != cur && i != index){
                return (char)i;
            }
        }
        return 'a';
    }

    public static char unSame(int pre, int last, int cur){
        for (int i = 97; i <= 122; i++){
            if (i != cur && i != pre && i != last){
                return (char)i;
            }
        }
        return 'a';
    }
}
