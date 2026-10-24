package edu.spu.se411.lab08;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Application is starting...");
        Random random = new Random();

        // 1. Create the subjects (sensors)
        TemperatureSensor temp = new TemperatureSensor("Room-Temp");
        HumiditySensor humidity = new HumiditySensor("Room-Humidity");

        // 2. Create the observers
        Observer dashboard = new DashboardObserver("Main");
        Observer fileLogger = new LoggerObserver("File");

        // 3. Register the observers to both sensors
        temp.register(dashboard);
        temp.register(fileLogger);
        humidity.register(dashboard);
        humidity.register(fileLogger);

        // 4. Simulate readings changing
        System.out.println("==== Simulating sensor readings ====");
        for (int i = 0; i < 10; i++) {
            System.out.println("---- Reading " + (i + 1) + " ----");
            temp.setReading(20 + random.nextDouble() * 15);
            humidity.setReading(40 + random.nextDouble() * 20);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 5. Same value again: no notification expected
        System.out.println("\n==== Setting the same humidity value twice ====");
        humidity.setReading(50.0);
        humidity.setReading(50.0);   // ignored, value did not change

        // 6. Unregister test: logger stops watching humidity
        System.out.println("\n==== Unregister logger from humidity ====");
        humidity.unregister(fileLogger);
        humidity.setReading(55.0);   // only the dashboard prints

        // 7. Clone test: the clone must NOT share the original's observers
        System.out.println("\n==== Clone test ====");
        TemperatureSensor tempCopy = temp.clone();
        tempCopy.setName("Room-Temp-Copy");

        System.out.println("Original: " + temp + " | observers = " + temp.getObserverCount());
        System.out.println("Clone:    " + tempCopy + " | observers = " + tempCopy.getObserverCount());
        System.out.println("Same object? " + (temp == tempCopy));

        System.out.println("Changing the clone (no observers yet, nothing printed):");
        tempCopy.setReading(99.0);

        System.out.println("Registering a separate dashboard on the clone:");
        tempCopy.register(new DashboardObserver("Copy"));
        tempCopy.setReading(30.0);

        System.out.println("Changing the original (only its own observers react):");
        temp.setReading(22.0);

        logger.info("Application finished.");
    }
}
