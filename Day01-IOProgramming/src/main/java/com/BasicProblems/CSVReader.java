package com.BasicProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {
        // Path of the CSV file
        String filePath = "employees.csv";  // Update with the correct path if needed

        // Variable to count the number of rows (excluding the header)
        int rowCount = 0;

        // Try to read the file and count rows
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the header line
            reader.readLine();

            // Read the remaining lines (employee records)
            while ((line = reader.readLine()) != null) {
                rowCount++;
            }

            System.out.println("Number of employee records (excluding header): " + rowCount);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

