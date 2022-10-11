package com.solactive.tickmonitor.model;

import lombok.Data;

@Data
public class Statistics {

    public double avg;
    public double max;
    public double min;
    public long count;

    public Statistics(double avg, double max, double min, long count) {
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.count = count;
    }
}
