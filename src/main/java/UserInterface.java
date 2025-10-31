import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    public Scanner scanner = new Scanner(System.in);
    Dealership dealership;
    public UserInterface(){
    }
    public void display(){
        init();
        boolean run = true;
        do {
            System.out.println("choose from the menu to get your desired information: \n" +
                    "1 - Find Vehicles within Price Range \n" +
                    "2 - Find vehicles by Make and Model \n" +
                    "3 - Find vehicles by year range\n" +
                    "4 - Find vehicles by color \n" +
                    "5 - Find vehicles by mileage range\n" +
                    "6 - Find vehicles by type (car, truck, SUV, van) \n" +
                    "7 - List ALL vehicles \n" +
                    "8 - Add a vehicle \n" +
                    "9 - Remove a vehicle \n" +
                    "0 - Quit");
            String input = scanner.nextLine();
            switch(input){
                case "1" -> processGetVehicleByPriceRequest();
                case "2" -> System.out.println("find by make and model");
                case "3" -> System.out.println("find by year range");
                case "4" -> System.out.println("find by color");
                case "5" -> System.out.println("find by milage range");
                case "6" -> System.out.println("find by type");
                case "7" -> processGetAllVehiclesRequest();
                case "8" -> System.out.println("Add vehicle");
                case "9" -> System.out.println("Remove vehicle");
                case "0" -> run = false;
                default -> System.out.println("wrong entry or one sloppy finger!!");
            }
        }while(run);
    }
    private void init(){
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
        System.out.println("Did you crash your car again ? \n");
        System.out.println("well I saw how desperate you are I'm " +
                "gonna give you expensive prices!! Welcome to " + dealership.getName());
    }
    private void displayVehicles(ArrayList<Vehicle> vehicles){
        if (vehicles.isEmpty() || vehicles == null ){
            System.out.println("You have to many specs we don't have a car for you!!");
        }
        for(Vehicle vehi : vehicles){
            System.out.println(vehi);
        }
    }
    public ArrayList<Vehicle> processGetVehicleByPriceRequest(){
        System.out.println("Enter minimum price: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.println("you're not at the grocery store😒, Enter maximum: ");
        double max = Double.parseDouble(scanner.nextLine());

        ArrayList<Vehicle> desiredItems = dealership.getVehiclesByPrice(min,max);
        displayVehicles(desiredItems);
        return desiredItems;
    }
    public ArrayList<Vehicle> processGetByMakeModelRequest(){
        System.out.println("Make : ");
        String make = scanner.nextLine();
        System.out.println("Model: ");
        String model = scanner.nextLine();

        ArrayList<Vehicle> desiredMakeModel = dealership.getVehiclesByMakeModel(make,model);
        displayVehicles(desiredMakeModel);
        return desiredMakeModel;
    }
    public ArrayList<Vehicle> processGetByYearRequest(){
        System.out.println("min year: ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.println("max year: ");
        int max = Integer.parseInt(scanner.nextLine());

        ArrayList<Vehicle> desiredMakeModel = dealership.getVehiclesByYear(min, max);
        displayVehicles(desiredMakeModel);
        return desiredMakeModel;
    }
    public ArrayList<Vehicle> processGetByColorRequest(){
        System.out.println("What color do you want it to be? ");
        String color = scanner.nextLine();

        ArrayList<Vehicle> desiredColor = dealership.getVehiclesByColor(color);
        displayVehicles(desiredColor);
        return desiredColor;
    }
    public ArrayList<Vehicle> processGetByMileageRequest(){
        System.out.println("Minimum Mileage: ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.println("Maximum Milage: ");
        int max = Integer.parseInt(scanner.nextLine());

        ArrayList<Vehicle> desiredMileage = dealership.getVehiclesByMileage(min,max);
        displayVehicles(desiredMileage);
        return desiredMileage;
    }
    public ArrayList<Vehicle> processGetByVehicleTypeRequest(){
        return null;
    }
    public ArrayList<Vehicle> processGetAllVehiclesRequest(){
        ArrayList allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
        return allVehicles;
    }
    public ArrayList<Vehicle> processAddVehiclesRequest(){
        return null;
    }
    public ArrayList<Vehicle> removeVehicleRequest(){
        return null;
    }

}
