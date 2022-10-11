package com.solactive.tickmonitor.service;

import com.solactive.tickmonitor.model.*;
import com.solactive.tickmonitor.util.*;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.apache.commons.collections4.map.LinkedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TickService {

    private HashMap<String, LinkedMap<Tick, Statistics>> tickList = new HashMap<>();

    @Autowired
    private StatisticsService statisticsService;

    public Object getAllTicks() {
        return tickList.values().toArray();
    }

    public Object getInstrumentStatistics(String identifier) {
          return tickList.get(identifier).values().toArray()[tickList.get(identifier).values().toArray().length - 1];
    }

    public Object getCompleteStatistics() {
        double[] prices = tickList.values().stream()
                                           .map(AbstractHashedMap::keySet)
                                           .flatMap(Collection::stream)
                                           .map(tick -> tick.price)
                                           .mapToDouble(i -> i)
                                           .toArray();
        return calculateStatistics(prices);
    }

    public void addTick(Tick tick) {

        LinkedMap<Tick, Statistics> instTickList = new LinkedMap<>();

        if (tickList.containsKey(tick.instrument)) {
            instTickList = tickList.get(tick.instrument);
            double[] prices = instTickList.keySet().stream()
                                                   .map(tick1 -> tick1.price)
                                                   .mapToDouble(i -> i)
                                                   .toArray();
            prices = Misc.increaseArrLengthByOne(prices);
            prices[prices.length - 1] = tick.price;
            Statistics statistics = calculateStatistics(prices);
            instTickList.put(tick, statistics);
        } else {
            double[] prices = {tick.price};
            Statistics statistics = calculateStatistics(prices);
            instTickList.put(tick, statistics);
            tickList.put(tick.instrument, instTickList);
        }
    }

    public void removeTick(Tick tick) {
        if (tickList.containsKey(tick.instrument) &&
                System.currentTimeMillis() / 1000 - tickList.get(tick.instrument).firstKey().timestamp > 60)
            tickList.get(tick.instrument).remove(tickList.get(tick.instrument).firstKey());
    }

    public Statistics calculateStatistics(double[] prices) {

        if (prices.length == 0) return new Statistics(0, 0, 0, 0);
        if (prices.length == 1) return new Statistics(prices[0], prices[0], prices[0], 1);

        statisticsService = new StatisticsService(prices);
        return statisticsService.getStatistics();
    }

}
