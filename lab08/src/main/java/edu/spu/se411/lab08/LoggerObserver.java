package edu.spu.se411.lab08;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerObserver extends SensorObserver {

    private static final Logger logger = LoggerFactory.getLogger(LoggerObserver.class);

    public LoggerObserver(String label) {
        super(label);
    }

    @Override
    protected void show(Sensor sensor) {
        System.out.printf("[Logger-%s]    %s%n", getLabel(), sensor);
        logger.info("{} received update: {}", getLabel(), sensor);
    }
}
