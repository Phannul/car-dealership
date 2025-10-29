import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DealershipFileManager {
    String path = "src/main/resources/inventory.csv";
    public Dealership getDealership() {
            Dealership dealership = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.readLine();
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

                dealership.addVehicle(vin, year, make, model, vehicleType, color, odoMeter, price);

            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found" + e);
        } catch (IOException e) {
            System.out.println("Something loco going on " + e);
        }
        return dealership;



    }
    public void saveDealership(){

    }
}
