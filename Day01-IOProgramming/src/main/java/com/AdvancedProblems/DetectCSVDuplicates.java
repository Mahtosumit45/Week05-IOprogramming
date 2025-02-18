package com.AdvancedProblems;

import java.io.*;
import java.util.*;

public class DetectCSVDuplicates {
    public static void main(String[] args) {
        // Path to the CSV file
        String filePath = "your_file.csv";  // Update with the correct file path

        // Set to track unique IDs
        Set<String> uniqueIds = new HashSet<>();

        // List to store duplicate records
        List<String> duplicateRecords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip the header line if present
            String header = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                String id = columns[0];  // Assuming ID is the first column

                // Check if the ID has already been encountered (duplicate)
                if (uniqueIds.contains(id)) {
                    // If it's a duplicate, add it to the list
                    duplicateRecords.add(line);
                } else {
                    // Otherwise, add the ID to the unique set
                    uniqueIds.add(id);
                }
            }

            // Print duplicate records
            if (!duplicateRecords.isEmpty()) {
                System.out.println("Duplicate Records:");
                for (String duplicate : duplicateRecords) {
                    System.out.println(duplicate);
                }
            } else {
                System.out.println("No duplicates found.");
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

