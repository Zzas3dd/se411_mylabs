package edu.spu.se411.lab08;

public class DashboardObserver extends SensorObserver {

    public DashboardObserver(String label) {
        super(label);
    }

    @Override
    protected void show(Sensor sensor) {
        System.out.printf("[Dashboard-%s] %-11s %-14s %6.2f %s%n",
                getLabel(), sensor.getType(), sensor.getName(),
                sensor.getReading(), sensor.getUnit());
    }
}
