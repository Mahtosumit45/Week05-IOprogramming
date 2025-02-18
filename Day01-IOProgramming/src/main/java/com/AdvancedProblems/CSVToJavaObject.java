package com.AdvancedProblems;

import java.io.*;
import java.util.*;

public class CSVToJavaObject {

    // Define the Student class inside the main class
    public static class Student {
        private int id;
        private String name;
        private String email;
        private String phoneNumber;
        private String department;
        private int marks;

        // Constructor
        public Student(int id, String name, String email, String phoneNumber, String department, int marks) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.department = department;
            this.marks = marks;
        }

        // Getters and setters (optional)
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public int getMarks() {
            return marks;
        }

        public void setMarks(int marks) {
            this.marks = marks;
        }

        // ToString method to print the student details
        @Override
        public String toString() {
            return "Student{" +
                    "ID=" + id +
                    ", Name='" + name + '\'' +
                    ", Email='" + email + '\'' +
                    ", Phone Number='" + phoneNumber + '\'' +
                    ", Department='" + department + '\'' +
                    ", Marks=" + marks +
                    '}';
        }
    }

    public static void main(String[] args) {
        // Path to the CSV file
        String filePath = "students.csv"; // Update with the correct file path

        // List to hold the student objects
        List<Student> studentList = new ArrayList<>();

        // Read the CSV file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the header line
            reader.readLine();

            // Read each record and create Student objects
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                // Parse the data and create a new Student object
                int id = Integer.parseInt(columns[0]);
                String name = columns[1];
                String email = columns[2];
                String phoneNumber = columns[3];
                String department = columns[4];
                int marks = Integer.parseInt(columns[5]);

                // Create Student object and add to the list
                Student student = new Student(id, name, email, phoneNumber, department, marks);
                studentList.add(student);
            }

            // Print all student objects
            for (Student student : studentList) {
                System.out.println(student);
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        }
    }
}

