package base;

import java.util.List;

import base.Car;
import base.ShellMenu;
import base.CarList;

public class Program {
    public static void main(String[] args) {

        boolean exitMenu = false;

        List<Car> Cars = CarList.getInstance().geList();

        System.out.println(Cars.get(0).getDescription());

        ShellMenu menu = new ShellMenu();
        menu.ShowMenu();

    }
    
}
