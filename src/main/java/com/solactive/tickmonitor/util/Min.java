package com.solactive.tickmonitor.util;

public class Min {

    public static double minCalculation(double[] arr) {

        double min = Double.MAX_VALUE;

        if (arr.length == 0) return 0;

        for (double val : arr) {
            if (val < min) min = val;
        }
        return min;
    }

//    public static double minCalculation(double price, double preMin) {
//        if (price < preMin) return price; else return preMin;
//    }
}
