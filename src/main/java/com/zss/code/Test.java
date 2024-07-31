package com.zss.code;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author ZSS
 * @date 2021/12/10 16:19
 * @desc
 */
public class Test {

    public static void main(String[] args) {
        List<String> xFrom2015 = getXFrom2015();
        System.out.println(xFrom2015);
        List<String> x = getX();
        System.out.println(x);
    }

    /**
     * 获取从15年开始的年份
     *
     * @return List<String>
     */
    public static List<String> getXFrom2015() {
        List<String> x = new ArrayList<>();
        Calendar date = Calendar.getInstance();
        // 当前年
        int currentYear = Integer.parseInt(String.valueOf(date.get(Calendar.YEAR)));
        int temp = currentYear - 2015;
        for (int i = temp; i >= 0; i--) {
            x.add(String.valueOf(currentYear - i));
        }
        return x;
    }

    public static List<String> getX() {
        Calendar date = Calendar.getInstance();
        String currentYear = String.valueOf(date.get(Calendar.YEAR));
        // 默认进去显示有监测值的年份
        List<String> x = new ArrayList<>();
        // 当前年份往后推8年，一共9年
        int temp = Integer.parseInt(currentYear) - 2021;
        for (int i = 6 + temp; i >= 0; i--) {
            x.add(String.valueOf(Integer.parseInt(currentYear) - i));
        }
        return x;
    }
}
