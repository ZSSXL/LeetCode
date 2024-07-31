package com.zss.code.medium;

/**
 * @author ZSS
 * @date 2021/12/22 15:53
 * @desc 686 -- 重复叠加字符串匹配
 */
public class RepeatedStringMatch_686 {

    private final static int MAX_LENGTH = 10000;

    public static void main(String[] args) {
        String a = "abcd", b = "cdabcdab";
        String a1 = "a", b1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
         int i = repeatedStringMatch(a1, b1);
         System.out.println(i);
    }

    public static int repeatedStringMatchV2(String a, String b) {
        //滚轮？ A作为滚轮
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        for(int i=0;i<A.length;i++){
            int len = loop(A,B,i);
            if(len > 0){//
                int count = 1;

                len = a.length() - A.length + i;
                count += len/A.length;
                count += len%A.length > 0 ? 1 : 0;
                return count;
            }else if(len + A.length <= 0){
                return -1;
            }
        }
        return -1;

    }
    //使用a滚轮印刷b，start为起始点
    public static int loop(char[] a,char[] b,int start){
        int count = start;
        for(char c : b){
            if(a[start % a.length] != c){
                return count - start;
            }
            start++;
        }
        return 1;
    }

    public static int repeatedStringMatch(String a, String b) {
        if (!a.contains(String.valueOf(b.charAt(0)))) {
            return -1;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (sb.length() <= MAX_LENGTH && i <= 10) {
            sb.append(a);
            if (sb.length() < b.length()){
                i++;
                continue;
            }
            if (sb.indexOf(b) != -1) {
                return i + 1;
            } else {
                i++;
            }
        }
        if (isPurely(a)){
            sb = new StringBuilder();

            int temp = b.length() / a.length();
            for (int j = 0; j < temp && sb.length() <= MAX_LENGTH; j++) {
                sb.append(a);
            }
            if (sb.toString().equals(b)) {
                return temp;
            }
        }
        return -1;
    }

    private static boolean isPurely(String str) {
        int mrepeat = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(0)) {
                mrepeat += 1;
            }
        }
        return mrepeat == (str.length() - 1);
    }
}
