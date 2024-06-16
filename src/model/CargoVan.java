package model;

import interfaces.ICargoVan;

public class CargoVan implements ICargoVan {
    private final String model;
    private final double value;
    private final int experience;
    private final int rentalDays;

    public CargoVan(String model, double value, int experience, int rentalDays) {
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
    public double getInsuranceCost() {
        if (experience <= 5) {
            return (value * 0.03) / 100;
        }
        return ((value * 0.03) / 100) * 0.85;
    }

    @Override
    public double getRentalCost() {
        if(rentalDays <= 7) {
            return 50;
        }
        return 40;
    }
}
