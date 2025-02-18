package com.IntermediateProblems;

import java.io.*;
import java.util.*;

public class CSVSort {
    public static void main(String[] args) {
        // Path to the CSV file
        String filePath = "employees.csv";  // Update with the correct path if needed

        // List to hold the employee records
        List<String[]> employeeRecords = new ArrayList<>();

        // Try reading and processing the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read and store the header
            String header = reader.readLine();

            // Read each record and add to the list
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                employeeRecords.add(columns);
            }

            // Sort the records by Salary in descending order (Salary is at index 3)
            employeeRecords.sort((a, b) -> {
                double salaryA = Double.parseDouble(a[3]);
                double salaryB = Double.parseDouble(b[3]);
                return Double.compare(salaryB, salaryA); // Descending order
            });

            // Print the header
            System.out.println(header);

            // Print the top 5 highest-paid employees
            int count = 0;
            for (String[] record : employeeRecords) {
                if (count >= 5) break;
                System.out.println(String.join(",", record));
                count++;
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing salary: " + e.getMessage());
        }
    }
}

