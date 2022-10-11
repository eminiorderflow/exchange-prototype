package com.solactive.tickmonitor.controller;

import com.solactive.tickmonitor.model.Tick;
import com.solactive.tickmonitor.service.TickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TickController {

    @Autowired
    private TickService tickService;

    @RequestMapping("/tick")
    public Object tick() {
        return tickService.getAllTicks();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tick")
    public ResponseEntity<?> addTick(@RequestBody Tick tick) {
        if (System.currentTimeMillis() / 1000 - tick.timestamp <= 60) {
            Thread removeThread = new Thread(() -> tickService.removeTick(tick));
            Thread addThread = new Thread(() -> tickService.addTick(tick));
            removeThread.start();
            addThread.start();
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = {"/statistics", "/statistics/{instrument_identifier}"})
    public Object statistics(@PathVariable(value = "instrument_identifier", required = false) String identifier) {
        if (identifier != null) return tickService.getInstrumentStatistics(identifier);
        else return tickService.getCompleteStatistics();
    }
}
