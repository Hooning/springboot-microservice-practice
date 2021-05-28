package com.hooning.classes;

import java.util.Locale;

public class Car {

    private String model;
    private String engine;
    private String color;
    private int doors;
    private int wheels;

    public void setModel(String model) {
        String validModel = model.toLowerCase();
        if ("911 turbo".equals(validModel) || "Avante".equals(validModel)) {
            this.model = model;
        } else {
            this.model = "UNKNOWN";
        }
    }

    public String getModel() {
        return this.model;
    }
}
