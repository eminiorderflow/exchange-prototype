package com.solactive.tickmonitor.util;

public class Misc {

    public static double[] increaseArrLengthByOne(double[] source) {
        double[] copy = new double[source.length + 1];
        System.arraycopy(source, 0 , copy, 0, source.length);
        source = copy;
        return source;
    }
}
