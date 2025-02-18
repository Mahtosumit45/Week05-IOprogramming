package com.IntermediateProblems;

import java.io.*;
import java.util.*;

public class CSVUpdate {
    public static void main(String[] args) {
        // Path of the original and new CSV file
        String inputFile = "employees.csv";  // Input file path
        String outputFile = "updated_employees.csv";  // Output file path

        // List to hold updated records
        List<String[]> updatedRecords = new ArrayList<>();

        // Try to read the file and process records
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;

            // Read the header line
            String header = reader.readLine();
            updatedRecords.add(header.split(",")); // Add the header to the updated records

            // Read each record and process
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                // Check if the department is "IT" and update the salary
                if (columns[2].equalsIgnoreCase("IT")) {
                    try {
                        // Increase the salary by 10%
                        double salary = Double.parseDouble(columns[3]);
                        salary *= 1.10; // 10% increase
                        columns[3] = String.format("%.2f", salary); // Update salary with new value
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid salary format for employee: " + columns[1]);
                    }
                }

                // Add the updated record to the list
                updatedRecords.add(columns);
            }

            // Write the updated records to the new file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                for (String[] record : updatedRecords) {
                    writer.write(String.join(",", record));
                    writer.newLine();
                }

                System.out.println("File has been updated and saved to " + outputFile);
            } catch (IOException e) {
                System.err.println("Error writing to the file: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

