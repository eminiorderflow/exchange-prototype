package com.solactive.tickmonitor.util;

public class Average {

    public static double avgCalculation(double[] arr) {

        double sum = 0.0;

        if (arr.length == 0) return sum;

        for (double val : arr) {
            sum += val;
        }
        return sum/arr.length;
    }
}
