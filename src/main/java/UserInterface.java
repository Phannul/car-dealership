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
                case "2" -> processGetByMakeModelRequest();
                case "3" -> processGetByYearRequest();
                case "4" -> processGetByColorRequest();
                case "5" -> processGetByMileageRequest();
                case "6" -> processGetByVehicleTypeRequest();
                case "7" -> processGetAllVehiclesRequest();
                case "8" -> processAddVehiclesRequest();
                case "9" -> removeVehicleRequest();
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
        System.out.println("what type ddo you want: ");
        String type = scanner.nextLine();

        ArrayList<Vehicle> desiredType = dealership.getVehicleByType(type);
        displayVehicles(desiredType);
        return desiredType;
    }
    public ArrayList<Vehicle> processGetAllVehiclesRequest(){
        ArrayList allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
        return allVehicles;
    }
    public ArrayList<Vehicle> processAddVehiclesRequest(){
        System.out.println("Enter VIN: ");
        int vin = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Make: ");
        String make = scanner.nextLine();
        System.out.println("Enter Model: ");
        String model = scanner.nextLine();
        System.out.println("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();
        System.out.println("Enter Color: ");
        String color = scanner.nextLine();
        System.out.println("Enter odometer: ");
        int odometer = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter price");
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle newVehicle = new Vehicle(vin, year, make,model, vehicleType, color, odometer, price);
        dealership.addVehicle(newVehicle);

        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);

        System.out.println("Vehicle Added Successfully!!");

        return dealership.getAllVehicles();

    }
    public ArrayList<Vehicle> removeVehicleRequest(){
        System.out.println("Enter the vin of vehicle to be removed: ");
        int vin = Integer.parseInt(scanner.nextLine());
        dealership.removeVehicle(vin);

        DealershipFileManager dfm = new DealershipFileManager();
        dfm.saveDealership(dealership);

        System.out.println("Vehicle Has been removed!!");
        return dealership.getAllVehicles();
    }

}
