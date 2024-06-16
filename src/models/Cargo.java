package models;

import interfaces.iCargo;

public class Cargo implements iCargo {
    private String model;
    private double value;
    private int experience;
    private double rentalCost;
    private double insuranceCost;
    private int rentalDays;
    public Cargo( String model, double value, int experience, int rentalDays) {
        this.model = model;
        this.value = value;
        this.experience = experience;
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
    public int getExperience() {
        return experience;
    }

    @Override
    public double getInsuranceCost() {
        if (experience <= 5) return (value * 0.03) / 100;
        else return ((value * 0.03) / 100) * 0.85;
    }


    @Override
    public int getRentalDays() {
        return rentalDays;
    }

    @Override
    public double getRentalCost() {
        if(rentalDays <= 7) {
            return 50;
        }
        else return 40;
    }
}
