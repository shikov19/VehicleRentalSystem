package models;


import interfaces.ICar;

public class Car implements ICar {
    private String model;
    private double value;
    private int rating;
    private double rentalCost;
    private double insuranceCost;
    private int rentalDays;
    public Car(String model, double value, int rating, int rentalDays) {
        this.model = model;
        this.value = value;
        this.rating = rating;
        this.rentalDays = rentalDays;
        this.rentalCost = rentalCost;
        this.insuranceCost = insuranceCost;
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
    public int getRating() {
        return rating;
    }

    @Override
    public int getRentalDays() {
        return rentalDays;
    }

    @Override
    public double getInsuranceCost() {
        if(rating <= 3) {
            return (value * 0.01) / 100;
        }
        else {
            return ((value * 0.01) / 100) * 0.9;
        }
    }

    @Override
    public double getRentalCost() {
        if(rentalDays <= 7) {
            return 20;
        }
        else return 15;
    }



}
