package com.AdvancedProblems;

import java.io.*;

public class LargeCSVReader {
    public static void main(String[] args) {
        // Path to the large CSV file
        String filePath = "large_file.csv";  // Update with the correct path to the large CSV file

        // Number of lines to process at a time
        final int chunkSize = 100;
        int recordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int linesProcessed = 0;

            // Skip header if needed
            String header = reader.readLine(); // Skip the header line (if present)

            while ((line = reader.readLine()) != null) {
                linesProcessed++;
                // Process the line here (e.g., parse the data)
                // For example, you could split it by commas:
                String[] columns = line.split(",");
                // You can process the columns as required, here we're just counting.

                // Every 100 lines, print the count of processed records
                if (linesProcessed % chunkSize == 0) {
                    System.out.println("Processed " + linesProcessed + " records so far.");
                }
            }

            // If there are less than 100 records left, print the final count
            if (linesProcessed % chunkSize != 0) {
                System.out.println("Processed " + linesProcessed + " records in total.");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

