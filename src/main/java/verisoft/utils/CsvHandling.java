package verisoft.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for handling CSV files.
 */
public class CsvHandling {
    /**
     * Reads data from a CSV file and returns it as a two-dimensional array.
     *
     * @param csvPath The path to the CSV file.
     * @return A two-dimensional array containing the data from the CSV file.
     * @throws RuntimeException If an error occurs while reading the CSV file.
     */
    public static Object[][] readCsvData(String csvPath) {
        try (CSVReader reader = new CSVReader(new FileReader(csvPath))) {
            List<String[]> dataList = new ArrayList<>();
            String[] header = reader.readNext();

            String[] row;
            while ((row = reader.readNext()) != null) {
                dataList.add(row);
            }

            Object[][] data = new Object[dataList.size()][header.length];
            data = dataList.toArray(data);

            return data;
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Failed to read csv file: {" + csvPath + "}\n" + e);
        }
    }
}
