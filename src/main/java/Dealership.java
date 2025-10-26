import java.util.ArrayList;

public class Dealership {
    ArrayList<Vehicle> inventory;
    private String name;
    private String address;
    private String phone;

    public Dealership(String name, String address, String phone){
        new ArrayList<>();
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    // getters Section
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
    public void getVehiclesByPrice(double min, double max){

    }
    public void getVehiclesByMakeModel(String make, String model){

    }
    public void getVehiclesByYear(int min, int max){

    }
    public void  getVehiclesByColor(String color){

    }
    public void getVehiclesByMileage(int min, int max){

    }
    public void getVehicleByType(String type){

    }
    public void getAllVehicles(){

    }
    public void addVehicle(Vehicle vehicleToBeAdded){

    }
    public void removeVehicle(Vehicle vehicleToBeRemoved){

    }
}
