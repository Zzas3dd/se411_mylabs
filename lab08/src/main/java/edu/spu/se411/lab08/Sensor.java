package edu.spu.se411.lab08;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for all sensors (the Subject).
 * All shared code lives here: the observer list, register, unregister,
 * notify and clone. Subclasses only provide their unit and type.
 */
public abstract class Sensor implements Subject, Cloneable {

    private String name;
    private double reading;
    private List<Observer> observers = new ArrayList<>();

    protected Sensor(String name) {
        this.name = name;
    }

    @Override
    public void register(Observer o) {
        if (o != null && !observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    /** Stores the new reading and notifies observers only when the value really changed. */
    public void setReading(double newReading) {
        if (Double.compare(reading, newReading) == 0) {
            return; // same value, nothing to report
        }
        reading = newReading;
        notifyObservers();
    }

    public double getReading() {
        return reading;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getObserverCount() {
        return observers.size();
    }

    /** Unit of measurement, for example "C" or "%" (polymorphism). */
    public abstract String getUnit();

    /** Kind of sensor, for example "Temperature" (polymorphism). */
    public abstract String getType();

    /**
     * super.clone() is a shallow copy, so the clone would SHARE the
     * original's observer list. We give the clone a new empty list,
     * so it starts with no observers and gets its own later.
     */
    @Override
    public Sensor clone() {
        try {
            Sensor copy = (Sensor) super.clone();
            copy.observers = new ArrayList<>();
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Sensor implements Cloneable, so this cannot happen", e);
        }
    }

    @Override
    public String toString() {
        return String.format("%s '%s' = %.2f %s", getType(), name, reading, getUnit());
    }
}
