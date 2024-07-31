package com.zss.code.easy;

/**
 * @author zhoushs@dist.com.cn
 * @date 2021/12/6 13:36
 * @desc 1816 -- 截断句子
 */
public class TruncateSentence {

    public static void main(String[] args) {
        int k = 4;
        String s1 = "Hello how are you Contestant";
        String result = truncateSentence(s1, k);
        System.out.println(result);
    }

    public static String truncateSentence(String s, int k) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder(k);
        for (int i = 0; i < k; i++) {
            sb.append(split[i]);
            if (i != k - 1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
