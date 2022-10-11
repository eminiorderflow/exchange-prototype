package com.solactive.tickmonitor.model;

import lombok.Data;

@Data
public class Tick {

    public final String instrument;
    public final double price;
    public final long timestamp;

    public Tick(String instrument, double price, long timestamp) {
        this.instrument = instrument;
        this.price = price;
        this.timestamp = timestamp;
    }
}
