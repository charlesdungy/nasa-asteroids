package com.nasa_asteroids.project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TodaysDate {
    
    private String todaysDate;

    public TodaysDate(String format) {
        this.todaysDate = setTodaysDate(format);
    }

    private String setTodaysDate(String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return dtf.format(LocalDate.now()).toString();
    }

    public String getTodaysDate() {
        return todaysDate;
    }
}