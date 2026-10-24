package edu.spu.se411.lab08;

/**
 * Shared parent for all sensor observers (code reuse).
 * update() does the common work once: check the subject is a Sensor
 * and cast it. Each subclass only decides what to do with the data.
 */
public abstract class SensorObserver implements Observer {

    private final String label;

    protected SensorObserver(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public void update(Subject subject) {
        if (subject instanceof Sensor) {
            show((Sensor) subject);
        }
    }

    /** What the concrete observer does with the new reading. */
    protected abstract void show(Sensor sensor);
}
