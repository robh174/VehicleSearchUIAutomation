package com.DataHelper;

import org.testng.annotations.DataProvider;
import utilities.FileReader;
import java.util.List;
import java.util.Map;

public class RegistrationDataProvider {

    private static final String INPUT_FILE_PATH = "src/test/resources/car_input - V6.txt";
    private static final String OUTPUT_FILE_PATH = "src/test/resources/car_output - V6.txt";

    @DataProvider(name = "inputRegistrationNumbers")
    public static Object[][] provideRegistrationNumbers() {
        List<String> regNumbers = FileReader.readInputFile(INPUT_FILE_PATH);

        Object[][] data = new Object[regNumbers.size()][1]; // Only 1 column for reg number
        for (int i = 0; i < regNumbers.size(); i++) {
            data[i][0] = regNumbers.get(i);
        }
        return data;
    }

    @DataProvider(name = "vehicleData")
    public static Object [][] getVehicledata(){

        // Read registration numbers from input file
        List<String> regNumbers = FileReader.readInputFile(INPUT_FILE_PATH);

        // Read expected vehicle details from output file
        Map<String, FileReader.VehicleDetails> vehicleData = FileReader.readOutputFile(OUTPUT_FILE_PATH);

        // Prepare input data  array
        Object[][] data = new Object[regNumbers.size()][4];
        for (int i = 0; i < regNumbers.size(); i++) {
            String regNumber = regNumbers.get(i);

            // Get expected vehicle details
            FileReader.VehicleDetails expectedDetails = vehicleData.get(regNumber);
            if (expectedDetails != null) {
                data[i][0] = regNumber;
                data[i][1] = expectedDetails.make;
                data[i][2] = expectedDetails.model;
                data[i][3] = expectedDetails.year;
            } else {
                data[i][0] = regNumber;
                data[i][1] = "UNKNOWN";
                data[i][2] = "UNKNOWN";
                data[i][3] = "UNKNOWN";
            }
        }
        return data;
    }
}

