import java.util.ArrayList;

public class Dealership {
    private ArrayList<Vehicle> inventory;
    private String name;
    private String address;
    private String phone;

    public Dealership(String name, String address, String phone) {
        this.inventory = new ArrayList<>();
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

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> desiredItems = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max){
                desiredItems.add(v);
            }
        }
        return desiredItems;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> desiredMakeModel = new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)){
                desiredMakeModel.add(v);
            }
        }
        return desiredMakeModel;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> desiredYearRange = new ArrayList<>();
        for (Vehicle v : inventory){
            if (v.getYear()>= min && v.getYear() <= max){
                desiredYearRange.add(v);
            }
        }
        return desiredYearRange;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> desiredColor = new ArrayList<>();
        for (Vehicle v : inventory){
            if(v.getColor().equalsIgnoreCase(color)){
                desiredColor.add(v);
            }
        }
        return desiredColor;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> desiredMileage = new ArrayList<>();
        for (Vehicle v : inventory){
            if(v.getOdometer() >= min && v.getOdometer() <= max){
                desiredMileage.add(v);
            }
        }
        return desiredMileage;
    }

    public ArrayList<Vehicle> getVehicleByType(String type) {
        ArrayList<Vehicle> desiredType = new ArrayList<>();
        for (Vehicle v : inventory){
            if(v.getVehicleType().equalsIgnoreCase(type)){
                desiredType.add(v);
            }
        }
        return desiredType;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle newVehicle) {
        this.inventory.add(newVehicle);
    }

    public void removeVehicle(Vehicle vehicleToBeRemoved) {
        inventory.remove(vehicleToBeRemoved);
    }
    @Override
    public String toString(){
        return String.format("%s | %s | %s ", name,address,phone);
    }
}
