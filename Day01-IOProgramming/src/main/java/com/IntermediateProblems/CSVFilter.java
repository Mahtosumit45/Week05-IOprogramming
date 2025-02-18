package com.IntermediateProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVFilter {
    public static void main(String[] args) {
        // Path of the CSV file
        String filePath = "/Users/sumitkumarmahto/Desktop/Week05-IOprogramming/Day01-IOProgramming/src/main/resources/students.csv";  // Update with the correct path if needed

        // Try to read and filter the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the header (first line)
            String header = reader.readLine();
            System.out.println(header); // Print the header (optional)

            // Read each student record
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                // Check if there are enough columns and that Marks is a valid integer
                if (columns.length == 4) {
                    try {
                        int marks = Integer.parseInt(columns[3]); // Marks is the 4th column (index 3)

                        // Filter students with marks greater than 80
                        if (marks > 80) {
                            System.out.println(line); // Print the qualifying record
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid marks for student: " + columns[1]);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

