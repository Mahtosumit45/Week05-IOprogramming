package com.AdvancedProblems;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class CSVValidator {
    public static void main(String[] args) {
        // Path to the CSV file
        String filePath = "employees2.csv";  // Update with the correct path if needed

        // Regex for email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        // Try reading the file and processing
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            // Read the header row
            String header = reader.readLine();
            System.out.println("Processing file: " + filePath);
            System.out.println("Header: " + header);

            // Read each employee record
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String[] columns = line.split(",");

                // Validate Email
                String email = columns[2];
                Matcher emailMatcher = emailPattern.matcher(email);
                boolean isEmailValid = emailMatcher.matches();

                // Validate Phone Number (must be exactly 10 digits)
                String phoneNumber = columns[3];
                boolean isPhoneValid = phoneNumber.matches("\\d{10}");

                // Print error messages for invalid records
                if (!isEmailValid || !isPhoneValid) {
                    System.out.println("Invalid row at line " + lineNumber + ": " + line);
                    if (!isEmailValid) {
                        System.out.println("  Error: Invalid email format: " + email);
                    }
                    if (!isPhoneValid) {
                        System.out.println("  Error: Invalid phone number (must be exactly 10 digits): " + phoneNumber);
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

