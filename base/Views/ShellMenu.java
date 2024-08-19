package base.Views;

import java.util.Scanner;

import base.Controllers.CarList;

public class ShellMenu{

        private CarList cars;

        public ShellMenu() {
            cars = CarList.getInstance();
        }

        public void ShowMenu(){
            Scanner scanner = new Scanner(System.in);
            int option;

            do{
                System.out.println("---------Cars Menu---------");
                System.out.println("1. Show all cars");
                System.out.println("2. Add a new car");
                System.out.println("3. Modify a car");
                System.out.println("4. Remove a car");
                System.out.println("5. Exit");

                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        cars.showAllCars();
                        pressKeyToContinue();
                        break;
                    case 2:
                        cars.addCar(scanner);
                        pressKeyToContinue();
                        break;
                    case 3:
                        cars.modifyCar(scanner);
                        pressKeyToContinue();
                        break;
                    case 4:
                        cars.removeCar(scanner);
                        pressKeyToContinue();
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        break;
                }

            }while(option != 5);
        }

        public void pressKeyToContinue(){
            System.out.println("\nPress Enter key to continue...\n\n");
            try{
                System.in.read();
            }catch(Exception e){}
        }



        
}


