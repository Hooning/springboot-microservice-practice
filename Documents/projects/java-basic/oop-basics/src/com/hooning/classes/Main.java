package com.hooning.classes;

public class Main {

    public static void main(String[] args) {
        Car porsche = new Car();
        Car hyundai = new Car();

        porsche.setModel("911 Turbo");
        hyundai.setModel("Tucson");

        System.out.println("My favourite porsche car model is " + porsche.getModel());

        System.out.println("My favourite Hyundai car model is " + hyundai.getModel());
    }

}
