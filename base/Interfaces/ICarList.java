package base.Interfaces;

import base.Controllers.CarList;
import base.Model.Car;

import java.util.Scanner;

public interface ICarList {
    public static CarList getInstance() {
        return null;
    }
    public void showAllCars();
    public void addCar(Scanner scanner);
    public void modifyCar(Scanner scanner);
    public void removeCar(Scanner scanner);

    private String readString(Scanner scanner) {
        return "";
    }

    private int readInt(Scanner scanner) {
        return 0;
    }

    private int readPositiveInt(Scanner scanner) {
        return 0;
    }

    private float readFloat(Scanner scanner) {
        return 0;
    }

    private float readPositiveFloat(Scanner scanner){
        return 0;
    }

    private Car getCarByKey(Scanner scanner){
        return null;
    }
}
