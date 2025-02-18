package com.AdvancedProblems;

import java.io.*;
import java.sql.*;

public class DatabaseToCSV {
    public static void main(String[] args) {
        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/employees_db?useSSL=false&serverTimezone=UTC"; // Correct URL format\n;
        String username = "root"; // Replace with your DB username
        String password = "password"; // Replace with your DB password

        // SQL query to fetch employee data
        String sqlQuery = "SELECT employee_id, name, department, salary FROM employees";

        // Output CSV file
        String csvFilePath = "employee_report.csv";

        // JDBC connection and file writer
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery);
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {

            // Writing CSV header
            writer.write("Employee ID,Name,Department,Salary");
            writer.newLine();

            // Writing data to CSV
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");

                // Writing each row to the CSV file
                writer.write(employeeId + "," + name + "," + department + "," + salary);
                writer.newLine();
            }

            System.out.println("CSV report generated successfully!");

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("File writing error: " + e.getMessage());
        }
    }
}

