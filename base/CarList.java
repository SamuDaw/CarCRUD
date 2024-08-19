package base;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.HashMap;

public class CarList {
    public static CarList instance = null;
    private HashMap<String, Car> hashMapCars = new HashMap<String, Car>();

    private CarList(){
        Car car1 = new Car("Fiat", 150, 3000, 150);
        Car car2 = new Car("Ferrari", 300, 2000, 300);
        Car car3 = new Car("Seat", 120, 3500, 150);
        hashMapCars.put("Car1", car1);
        hashMapCars.put("Car2", car2);
        hashMapCars.put("Car3", car3);
    }
    public static CarList getInstance() {
        if(instance == null) {
            instance = new CarList();
        }
        return instance;
    }

    public void showAllCars() {
        for(String key : hashMapCars.keySet()){
            System.out.println(key);
            System.out.println(hashMapCars.get(key).toString());
        }
    }

    public void addCar(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter the car name (key): \n");
        String name = readString(scanner);
        System.out.println("Enter the car description: \n");
        String description = readString(scanner);
        System.out.println("Enter the car horse power: \n");
        int horsePower = readPositiveInt(scanner);
        System.out.println("Enter the car weight in Kg: \n");
        float weight = readPositiveFloat(scanner);
        System.out.println("Enter the car max speed: \n");
        float maxSpeed = readPositiveFloat(scanner);

        Car newCar = new Car(description, horsePower, weight, maxSpeed);

        hashMapCars.put(name, newCar);
        System.out.println("\nCar added successfully!");
    }

    public void modifyCar(Scanner scanner) {
        
        int carsCount = hashMapCars.size();
        if (carsCount == 0) {
            System.out.println("There are no cars to modify.");
            return;
        }
        showAllCars();

        System.out.println("Enter the car name (key) to modify: \n");
        Car car = getCarByKey(scanner);
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
        System.out.println("Insert the name of the car (key) that you want to remove:\n");
        String key = readString(scanner);
        Car car = hashMapCars.get(key);
        while (car == null) {
            System.out.println("Error, Insert a valid car name (key): ");
            key = readString(scanner);
            car = hashMapCars.get(key);
        }
        hashMapCars.remove(key);
        System.out.println("\nCar \"" + key + "\" removed successfully!");
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

    private Car getCarByKey(Scanner scanner){
        String key = readString(scanner);
        Car car = hashMapCars.get(key);
        while (car == null) {
            System.out.println("Error, Insert a valid car name (key): ");
            key = readString(scanner);
            car = hashMapCars.get(key);
        }
        return car;
    }
}
