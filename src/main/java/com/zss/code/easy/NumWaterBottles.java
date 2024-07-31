package com.zss.code.easy;

/**
 * @author ZSS
 * @date 2021/12/17 15:11
 * @desc 1518 -- 换酒问题
 */
public class NumWaterBottles {

    public static void main(String[] args) {
        int numBottles = 9, numExchange = 3;
        int fun = numWaterBottles(numBottles, numExchange);
        System.out.println(fun);
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        return fun(numBottles, numExchange) + numBottles;
    }

    private static int fun(int numBottles, int numExchange) {
        int i = numBottles / numExchange;
        int yu = numBottles % numExchange;
        if ((i + yu) >= numExchange) {
            return fun(i + yu, numExchange) + i;
        }
        return i;
    }

}
