package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader {

    // Java utility method that takes a file path, read its contents,
    // matches the required data and outputs them to an array list
    public static ArrayList<String> readInputFile(String filePath) {
        ArrayList<String> regNumbers = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath));
            String Line;
            //create a pattern object then use matcher method on it to check each line for a match. if found, store in list
            Pattern regMatches = Pattern.compile("\\b[A-Z]{2}\\d{2}\\s?[A-Z]{3}\\b");
            while ((Line = reader.readLine()) != null) {
                Matcher matcher = regMatches.matcher(Line);
                while (matcher.find()) {
                    String formattedReg = formatRegistration(matcher.group());
                    regNumbers.add(formattedReg);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return regNumbers;
    }

    // Read vehicle details from car_output.txt and store in a HashMap
    public static Map<String, VehicleDetails> readOutputFile(String filePath) {
        Map<String, VehicleDetails> vehicleMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            reader.readLine(); // Ignore line "VARIANT_REG,MAKE,MODEL,YEAR"

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1); // Handle potential empty values
                if (data.length == 4) { // Ensure correct format: RegNumber, Make, Model, Year
                    String formattedReg = formatRegistration(data[0]); // Normalize registration key
                    vehicleMap.put(formattedReg, new VehicleDetails(data[1], data[2], data[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vehicleMap;
    }

    // VehicleDetails class to store make, model, and year
    public static class VehicleDetails {
        public String make;
        public String model;
        public String year;

        public VehicleDetails(String make, String model, String year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }
    }
    // method to format reg numbers in the format xxxx xxx
    public static String formatRegistration(String regNumber) {
        return regNumber.replaceAll("(\\w{2}\\d{2})(\\w{3})", "$1 $2").trim();
    }
}
