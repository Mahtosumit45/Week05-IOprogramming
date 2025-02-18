package com.BasicProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentCSVReader {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Replace with the path of your CSV file

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip header line (if your CSV has one)
            br.readLine();

            // Read each line of the CSV file
            while ((line = br.readLine()) != null) {
                // Split each line by commas
                String[] studentDetails = line.split(",");

                // Extract details
                String id = studentDetails[0].trim();
                String name = studentDetails[1].trim();
                String age = studentDetails[2].trim();
                String marks = studentDetails[3].trim();

                // Print details in a structured format
                System.out.println("Student ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Marks: " + marks);
                System.out.println("-------------------------");
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

