package model;

import interfaces.IMotorcycle;

public class Motorcycle implements IMotorcycle {
    private final String model;
    private final double value;
    private final int age;
    private final int rentalDays;

    public Motorcycle(String model, double value, int age, int rentalDays) {
        this.model = model;
        this.value = value;
        this.age = age;
        this.rentalDays = rentalDays;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public double getInsuranceCost() {
        if (age >= 25) {
            return (value * 0.02) / 100;
        }
        return ((value * 0.02) / 100) * 1.2;
    }

    @Override
    public double getRentalCost() {
        if(rentalDays <= 7) {
            return 15;
        }
        return 10;
    }
}
