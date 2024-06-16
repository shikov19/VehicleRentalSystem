import model.Car;
import model.CargoVan;
import model.Motorcycle;
import service.CarService;
import service.CargoVanService;
import service.MotorcycleService;

import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarService carService = new CarService();
        MotorcycleService motorcycleService = new MotorcycleService();
        CargoVanService invoiceCargo = new CargoVanService();

        System.out.println("Welcome to the Vehicle Rental Calculator");
        System.out.print("Please enter your first and last name: ");
        String name = scanner.nextLine().trim();
        System.out.println("Select the type of vehicle: ");
        System.out.println("1. Car");
        System.out.println("2. Motorcycle");
        System.out.println("3. Cargo Van");

        int choice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= 1 && choice <= 3) {
                    validChoice = true;
                } else {
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        System.out.println("Enter vehicle model: ");
        String model = scanner.nextLine().trim();

        double value = 0.0;
        boolean validValue = false;
        while (!validValue) {
            try {
                System.out.println("Enter the price of the vehicle $:");
                value = Double.parseDouble(scanner.nextLine().trim());
                if (value >= 0) {
                    validValue = true;
                } else {
                    System.out.println("Invalid input. Value cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = null;
        LocalDate endDate = null;
        LocalDate returnDate = null;

        boolean validDates = false;
        while (!validDates) {
            try {
                System.out.println("Enter the rental start date (yyyy-MM-dd):");
                startDate = LocalDate.parse(scanner.nextLine().trim(), formatter);

                System.out.println("Enter the rental end date (yyyy-MM-dd):");
                endDate = LocalDate.parse(scanner.nextLine().trim(), formatter);

                do {
                    System.out.println("Enter the actual return date (yyyy-MM-dd):");
                    returnDate = LocalDate.parse(scanner.nextLine().trim(), formatter);

                    if (returnDate.isAfter(endDate)) {
                        System.out.println("Return date cannot be later than the rental end date.");
                    }
                } while (returnDate.isAfter(endDate));

                validDates = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter dates in yyyy-MM-dd format.");
            }
        }

        int rentalDays = (int) ChronoUnit.DAYS.between(startDate, endDate);

        Car car;
        Motorcycle moto;
        CargoVan cargoVan;
        String invoice;

        switch (choice) {
            case 1:
                System.out.print("Enter car safety rating: ");
                int rating = 0;
                boolean validRating = false;
                while (!validRating) {
                    try {
                        rating = Integer.parseInt(scanner.nextLine().trim());
                        if (rating >= 1 && rating <= 5) {
                            validRating = true;
                        } else {
                            System.out.println("Invalid choice. Please enter 1, 2, 3, 4 or 5.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                }

                car = new Car(model, value, rating, rentalDays);
                invoice = carService.generateInvoice(car, startDate, endDate, returnDate, name);
                System.out.println(invoice);

                break;
            case 2:
                int age = 0;
                boolean validAge = false;
                while (!validAge) {
                    try {
                        System.out.println("How old is the rider (16-100): ");
                        age = Integer.parseInt(scanner.nextLine().trim());
                        if (age >= 16 && age <= 100) {
                            validAge = true;
                        }
                        else {
                            System.out.println("Rider's age must be between 16 and 100.");
                        }
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                }

                moto = new Motorcycle(model, value, age, rentalDays);
                invoice = motorcycleService.generateInvoice(moto, startDate, endDate, returnDate, name);
                System.out.println(invoice);

                break;
            case 3:
                int experience = 0;
                boolean validExperience = false;
                while (!validExperience) {
                    try {
                        System.out.println("Please enter driver's experience(years):");
                        experience = Integer.parseInt(scanner.nextLine().trim());
                        if (experience >= 1) {
                            validExperience = true;
                        }
                        else {
                            System.out.println("Driver's experience must be at least 1 year.");
                        }
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                }

                cargoVan = new CargoVan(model, value, experience, rentalDays);
                invoice = invoiceCargo.generateInvoice(cargoVan, startDate, endDate, returnDate, name);
                System.out.println(invoice);
                break;

            default:
            break;
        }


        scanner.close();
    }

}
