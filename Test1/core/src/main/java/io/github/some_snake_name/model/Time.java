package io.github.some_snake_name.model;

import io.github.some_snake_name.controller.MenuController;
import io.github.some_snake_name.view.Screen;

import javax.print.attribute.standard.MediaName;
import java.awt.event.InputEvent;

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
