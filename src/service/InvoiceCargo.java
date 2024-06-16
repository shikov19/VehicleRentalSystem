package service;

import models.Cargo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class InvoiceCargo {
    public String generateInvoice(Cargo cargo, LocalDate startDate, LocalDate endDate, LocalDate returnDate, String name) {
        String model = cargo.getModel();

        long rentalPeriod = ChronoUnit.DAYS.between(startDate, endDate);
        long actualPeriod = ChronoUnit.DAYS.between(startDate, returnDate);

        double dailyInsuranceCost = cargo.getInsuranceCost();
        double dailyRentalCost = cargo.getRentalCost();

        double totalRentalCost = (dailyRentalCost * actualPeriod) + (dailyRentalCost / 2 * (rentalPeriod - actualPeriod));

        if(startDate.isEqual(returnDate)) {
            actualPeriod = 1;
            totalRentalCost = dailyRentalCost;
        }

        double totalInsuranceCost = dailyInsuranceCost * actualPeriod;

        double totalPrice = totalRentalCost + totalInsuranceCost;

        return String.format("XXXXXXXXXXXXXXXXXXXX" +
                "\nCustomer Name: "+ name +
                "\nRented Vehicle: " + model+
                "\nReservation start date: " + startDate +
                "\nReservation end date: " + endDate +
                "\nReserved rental days:  " + ChronoUnit.DAYS.between(startDate,endDate) +
                "\nActual return date: " + returnDate +
                "\nActual rental days: " + ChronoUnit.DAYS.between(startDate, returnDate) +
                "\nRental cost per day: $" + String.format("%.2f",dailyRentalCost) +
                "\nInsurance per day: $" + String.format("%.2f",dailyInsuranceCost) +
                "\nTotal rent: $" + String.format("%.2f", totalRentalCost) +
                "\nTotal insurance: $" + String.format("%.2f",totalInsuranceCost) +
                "\nTotal: $" + String.format("%.2f",totalPrice) +
                "\nXXXXXXXXXXXXXXXXXXXX"
        );





    }
}
