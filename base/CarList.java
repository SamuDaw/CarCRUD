package base;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CarList {
    public static CarList instance = null;

    private List<Car> Cars;

    private CarList(){
        Cars = new ArrayList<Car>();
        Cars.add(new Car("Fiat", 150, 3000, 150));
        Cars.add(new Car("Ferrari", 300, 2000, 300));
        Cars.add(new Car("Seat", 120, 3500, 150));
    }
    public static CarList getInstance() {
        if(instance == null) {
            instance = new CarList();
        }
        return instance;
    }
    public List<Car> geList(){
        return Cars;
    }

    public void showAllCars() {
        String output = "";
        int i = 1;
        for (Car car : Cars) {
            output = output + i + ". " + car.toString() + "\n";
            i++;
            //output = output + car.toString();
        }
        System.out.println(output);
    }

    public void addCar(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter the car description: \n");
        String description = readString(scanner);
        System.out.println("Enter the car horse power: \n");
        int horsePower = readPositiveInt(scanner);
        System.out.println("Enter the car weight in Kg: \n");
        float weight = readPositiveFloat(scanner);
        System.out.println("Enter the car max speed: \n");
        float maxSpeed = readPositiveFloat(scanner);

        Car newCar = new Car(description, horsePower, weight, maxSpeed);
        Cars.add(newCar);
        System.out.println("\nCar added successfully!");
    }

    public void modifyCar(Scanner scanner) {
        
        
        int carsCount = getCarsCount() - 1;
        if (carsCount == 0) {
            System.out.println("There are no cars to modify.");
            return;
        }
        showAllCars();

        System.out.println("Enter the car number to modify: \n");
        int carNumber = checkCarNumber(scanner);
        Car car = Cars.get(carNumber - 1);
        System.out.println("Enter the car description: \n");
        String description = readString(scanner);
        System.out.println("Enter the car horse power: \n");
        int horsePower = readPositiveInt(scanner);
        System.out.println("Enter the car weight in Kg: \n");
        float weight = readPositiveFloat(scanner);
        System.out.println("Enter the car max speed: \n");
        float maxSpeed = readPositiveFloat(scanner);

        car.setDescription(description);
        car.setHorsePower(horsePower);
        car.setWeightInKg(weight);
        car.setMaxSpeed(maxSpeed);
        System.out.println("\nCar modified successfully!");
    }

    public void removeCar(Scanner scanner) {
        showAllCars();
        System.out.println("Enter the car number to remove: \n");
        int carNumber = checkCarNumber(scanner);
        Cars.remove(carNumber - 1);
        System.out.println("\nCar removed successfully!");
    }

    private String readString(Scanner scanner) {
        while (!scanner.hasNext()) {
            System.out.println("Invalid input, Please enter a valid string: ");
            scanner.next();
        }
        return scanner.next();
    }

    
    private int readInt(Scanner scanner) {
        try{
            int number = scanner.nextInt();
            return number;
        }catch(InputMismatchException e){
            System.out.println("Invalid input, Please enter a valid number: ");
            scanner.next();
            return readInt(scanner);
        }
    }

    private int readPositiveInt(Scanner scanner) {
        try{
            int number = readInt(scanner);
            while (number <= 0) {
                System.out.println("Invalid input, Please enter a positive number: ");
                scanner.next();
                number = readInt(scanner);
            }
            return number;
        }catch(InputMismatchException e){
            System.out.println("Invalid input, Please enter a valid number: ");
            scanner.next();
            return readPositiveInt(scanner);
        }
    }

    private float readFloat(Scanner scanner) {
        try{
            float number = scanner.nextFloat();
            while (number <= 0) {
                System.out.println("Invalid input, Please enter a positive number: ");
                scanner.next();
                number = scanner.nextFloat();
                
            }
            return number;
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input, Please enter a valid number: ");
            scanner.next();
            return readFloat(scanner);
        }
    }

    private float readPositiveFloat(Scanner scanner) {
        try{
            float number = readFloat(scanner);
            while (number <= 0) {
                System.out.println("Invalid input, Please enter a positive number: ");
                scanner.next();
                number = readFloat(scanner);
            }
            return number;
        }catch(InputMismatchException e){
            System.out.println("Invalid input, Please enter a valid number: ");
            scanner.next();
            return readPositiveFloat(scanner);
        }
    }

    private int getCarsCount() {
        return Cars.size();
    }

    private int checkCarNumber(Scanner scanner) {
        int carNumber = readPositiveInt(scanner);
        while (carNumber > getCarsCount()) {
            System.out.println("Invalid car number, Please enter a valid car number: ");
            scanner.next();
            carNumber = readPositiveInt(scanner);
        }
        return carNumber;
    }

}
