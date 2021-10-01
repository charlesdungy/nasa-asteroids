package com.nasa_asteroids.project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TodaysDate {
    
    private String todaysDate;

    public TodaysDate() {
        setTodaysDate();
    }

    private void setTodaysDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        this.todaysDate = dtf.format(LocalDate.now()).toString();
    }

    public String getTodaysDate() {
        return todaysDate;
    }
}