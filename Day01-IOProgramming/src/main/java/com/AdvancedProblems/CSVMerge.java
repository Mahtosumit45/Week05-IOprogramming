package com.AdvancedProblems;

import java.io.*;
import java.util.*;

public class CSVMerge {
    public static void main(String[] args) {
        // File paths
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";

        // Maps to store data from both CSVs
        Map<Integer, String[]> students1Data = new HashMap<>();
        Map<Integer, String[]> students2Data = new HashMap<>();

        // Read first CSV (students1.csv)
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1))) {
            String line;
            reader1.readLine();  // Skip header line
            while ((line = reader1.readLine()) != null) {
                String[] columns = line.split(",");
                int id = Integer.parseInt(columns[0]);
                students1Data.put(id, new String[]{columns[1], columns[2]});
            }
        } catch (IOException e) {
            System.err.println("Error reading students1.csv: " + e.getMessage());
        }

        // Read second CSV (students2.csv)
        try (BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {
            String line;
            reader2.readLine();  // Skip header line
            while ((line = reader2.readLine()) != null) {
                String[] columns = line.split(",");
                int id = Integer.parseInt(columns[0]);
                students2Data.put(id, new String[]{columns[1], columns[2]});
            }
        } catch (IOException e) {
            System.err.println("Error reading students2.csv: " + e.getMessage());
        }

        // Merge data and write to new CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            // Write the header for the merged file
            writer.write("ID,Name,Age,Marks,Grade");
            writer.newLine();

            // Merge and write the records
            for (Integer id : students1Data.keySet()) {
                if (students2Data.containsKey(id)) {
                    String[] student1 = students1Data.get(id);
                    String[] student2 = students2Data.get(id);
                    // Write the merged data
                    writer.write(id + "," + student1[0] + "," + student1[1] + "," + student2[0] + "," + student2[1]);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing merged file: " + e.getMessage());
        }

        System.out.println("CSV files merged successfully!");
    }
}

