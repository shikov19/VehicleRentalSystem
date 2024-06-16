package model;

import interfaces.IMotorcycle;

public class Motorcycle implements IMotorcycle {
    private String model;
    private double value;
    private int age;
    private double rentalCost;
    private double insuranceCost;
    private int rentalDays;

    public Motorcycle(String model, double value, int age, int rentalDays) {
        this.model = model;
        this.value = value;
        this.age = age;
        this.rentalCost = rentalCost;
        this.insuranceCost = insuranceCost;
        this.rentalDays = rentalDays;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public int getAge() {
        return age;
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

    @Override
    public int getRentalDays() {
        return rentalDays;
    }
}
