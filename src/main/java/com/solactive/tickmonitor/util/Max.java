package com.solactive.tickmonitor.util;

public class Max {

    public static double maxCalculation(double[] arr) {

        double max = Double.MIN_VALUE;

        if (arr.length == 0) return 0;

        for (double val : arr) {
            if (val > max) max = val;
        }
        return max;
    }

//    public static double maxCalculation(double price, double prevMax) {
//        if (price > prevMax) return  price; else return prevMax;
//    }
}
