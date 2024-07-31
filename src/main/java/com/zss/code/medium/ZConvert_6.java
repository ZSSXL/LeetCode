package com.zss.code.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZSS
 * @date 2021/11/26 14:19
 * @desc 6 -- Z自行变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 */
public class ZConvert_6 {

    public static void main(String[] args) {

        System.out.println(convertV2("PAYPALISHIRING", 4));
    };

    public static String convertV2(String s, int numRows) {
        if (numRows == 1 || s.length() == 1) {
            return s;
        }
        List<StringBuilder> sbList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            sbList.add(new StringBuilder());
        }
        boolean flag = true;
        int index = 1;
        sbList.get(0).append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            sbList.get(index).append(s.charAt(i));
            if (index == numRows - 1) {
                flag = false;
            }
            if (index == 0){
                flag = true;
            }
            if (flag) {
                index++;
            } else {
                index--;
            }
        }
        StringBuilder builder = sbList.get(0);
        for (int i = 1; i < sbList.size(); i++) {
            builder.append(sbList.get(i).toString());
        }
        return builder.toString();
    }

    public static String convert(String s, int numRows) {
        int header = 0, body = 1, tail = 2;
        StringBuilder headerStr = new StringBuilder();
        StringBuilder bodyStr = new StringBuilder();
        StringBuilder tailStr = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == header) {
                headerStr.append(c);
                header += 4;
            } else if (i == body) {
                bodyStr.append(c);
                body += 2;
            } else if (i == tail) {
                tailStr.append(c);
                tail += 4;
            }
        }

        return headerStr.append(bodyStr).append(tailStr).toString();
    }

    public static char[] parse(String source) {
        char[] result = new char[source.length()];
        for (int i = 0; i < source.length(); i++) {
            result[i] = source.charAt(i);
        }
        return result;
    }
}
