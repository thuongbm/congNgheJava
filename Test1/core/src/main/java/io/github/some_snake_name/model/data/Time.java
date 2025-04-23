package io.github.some_snake_name.model.data;

import io.github.some_snake_name.model.entities.Snake;
import io.github.some_snake_name.view.Screen;

public class Time {
    private double startTime;
    private double endTime;


    public Time () {
        this.startTime = 0;
        this.endTime = 0;
    }

    public double TimePeriod() {
        startTime = Screen.getTimeStart();
        endTime = Snake.getTimeEnd();

        double timePeriod = (endTime - startTime) / 1000;

        System.out.println("Time period: " + timePeriod + " seconds");

        return timePeriod;
    }
}
