import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {
   String path = "/Users/phannu/pluralsight/workshops/CarDealership/src/main/resources/inventory.csv";
    private Dealership dealership ;


    public Dealership getDealership() {

        try  {
            FileReader fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);

            String header = reader.readLine();
            String[] lineParts = header.split("\\|");
            dealership = new Dealership(lineParts[0], lineParts[1],lineParts[2]);

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] sections = line.split("\\|");
                int vin = Integer.parseInt(sections[0].strip());
                int year = Integer.parseInt(sections[1].strip());
                String make = sections[2].strip();
                String model = sections[3].strip();
                String vehicleType = sections[4].strip();
                String color = sections[5].strip();
                int odoMeter = Integer.parseInt(sections[6].strip());
                double price = Double.parseDouble(sections[7].strip());
                Vehicle car = new Vehicle(vin, year, make, model, vehicleType, color, odoMeter, price);
                dealership.addVehicle(car);

            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found" + e);
        } catch (IOException e) {
            System.out.println("Something loco going on " + e);
        }
        return dealership;

    }
    public void saveDealership(Dealership dealership1){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
            writer.write(String.format("%s | %s | %s ", dealership1.getName(),dealership1.getAddress(), dealership1.getPhone()));
            writer.newLine();
            for (Vehicle v : dealership1.getAllVehicles()){
                writer.write(String.format("%d | %d | %s | %s | %s | %s | %d | %.2f", v.getVin(), v.getYear(), v.getMake(), v.getModel(), v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice()));
                writer.newLine();
            }
        }catch (IOException e){
            System.out.println("I told you to have a good pen" + e);
        }

    }
}
