package io.github.some_snake_name.model;

import javax.print.attribute.standard.MediaName;
import java.awt.event.InputEvent;

public class Time {
    private long startTime;
    private long endTime;

    public Time () {
        this.startTime = 0;
        this.endTime = 0;
    }

    public long TimePeriod() {
        startTime = System.currentTimeMillis();
        endTime = System.currentTimeMillis();

        long timePeriod = (endTime - startTime) / 1000;

        System.out.println("Time period: " + timePeriod + " seconds");

        return timePeriod;
    }
}
