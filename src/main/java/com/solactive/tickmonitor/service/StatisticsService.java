package com.solactive.tickmonitor.service;

import com.solactive.tickmonitor.model.Statistics;
import com.solactive.tickmonitor.util.Average;
import com.solactive.tickmonitor.util.Count;
import com.solactive.tickmonitor.util.Max;
import com.solactive.tickmonitor.util.Min;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class StatisticsService{

    private final double[] prices;
    private Statistics statistics = new Statistics(0, 0, 0, 0);

    public StatisticsService(double[] prices) {
        this.prices = prices;
    }

    @Async
    private void addAverage() {
        this.statistics.avg = Average.avgCalculation(prices);
    }

    @Async
    private void addMax() {
        this.statistics.max = Max.maxCalculation(prices);
    }

    @Async
    private void addMin() {
        this.statistics.min = Min.minCalculation(prices);
    }

    @Async
    private void addCount() {
        this.statistics.count = Count.countCalculation(prices);
    }

    public Statistics getStatistics() {
        addAverage();
        addMax();
        addMin();
        addCount();
        return statistics;
    }

}
