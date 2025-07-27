package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        String filePath = "dataset/dataset.csv";
        String line;
        int recordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read header
            String headerLine = br.readLine();
            if (headerLine == null) {
                System.out.println("The CSV file is empty.");
                return;
            }

            String[] columns = headerLine.split(",");
            System.out.println("Columns:");
            for (String column : columns) {
                System.out.println(" - " + column);
            }
            System.out.println("Total number of columns: " + columns.length);
            System.out.println();

            // Print first 5 records
            System.out.println("First 5 records:");
            while ((line = br.readLine()) != null && recordCount < 5) {
                System.out.println(line);
                recordCount++;
            }

            // Count remaining records
            while ((line = br.readLine()) != null) {
                recordCount++;
            }

            System.out.println("\nTotal number of records (excluding header): " + recordCount);

        } catch (IOException e) {
            System.out.println("An error occurred while reading the CSV file.");
            e.printStackTrace();
        }
    }
}