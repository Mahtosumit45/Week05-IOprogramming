package com.IntermediateProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVSearch {
    public static void main(String[] args) {
        // Path of the CSV file
        String filePath = "employees.csv"; // Update with the correct path if needed
        // Name of the employee to search for
        String searchName = "Charlie Brown"; // Change to the employee name you are searching for

        // Try to read the file and search for the employee
        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the header row
            reader.readLine();

            // Read each employee record
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                // Check if the name matches the search query
                if (columns.length == 4 && columns[1].equalsIgnoreCase(searchName)) {
                    // Print department and salary of the employee
                    System.out.println("Employee found:");
                    System.out.println("Name: " + columns[1]);
                    System.out.println("Department: " + columns[2]);
                    System.out.println("Salary: " + columns[3]);
                    found = true;
                    break; // Exit the loop once the employee is found
                }
            }

            // If employee not found, print message
            if (!found) {
                System.out.println("Employee with name '" + searchName + "' not found.");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

