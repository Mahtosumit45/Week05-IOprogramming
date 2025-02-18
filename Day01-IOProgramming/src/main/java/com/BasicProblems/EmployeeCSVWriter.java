package com.BasicProblems;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeCSVWriter {
    public static void main(String[] args) {
        // Path of the CSV file
        String filePath = "employees.csv";

        // Employee data
        String[][] employees = {
                {"1", "Alice Johnson", "HR", "55000"},
                {"2", "Bob Smith", "Finance", "70000"},
                {"3", "Charlie Brown", "IT", "80000"},
                {"4", "Diana Green", "Marketing", "60000"},
                {"5", "Ethan White", "Sales", "65000"}
        };

        // Try to write data to the CSV file
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            // Write the header
            writer.println("ID,Name,Department,Salary");

            // Write employee records
            for (String[] employee : employees) {
                writer.println(String.join(",", employee));
            }

            System.out.println("Employee data has been written to the CSV file.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}

