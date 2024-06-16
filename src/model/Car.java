package model;

import interfaces.ICar;

public class Car implements ICar {
    private final String model;
    private final double value;
    private final int rating;
    private final int rentalDays;

    public Car(String model, double value, int rating, int rentalDays) {
        this.model = model;
        this.value = value;
        this.rating = rating;
        this.rentalDays = rentalDays;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public double getInsuranceCost() {
        if(rating <= 3) {
            return (value * 0.01) / 100;
        }
        return ((value * 0.01) / 100) * 0.9;
    }

    @Override
    public double getRentalCost() {
        if(rentalDays <= 7) {
            return 20;
        }
        return 15;
    }
}
