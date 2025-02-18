package com.AdvancedProblems;

import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.*;
import java.util.Base64;

public class EncryptDecryptCSV {

    public static void main(String[] args) {
        String csvFilePath = "employees.csv";
        String encryptedCsvFilePath = "encrypted_employees.csv";
        String key = "1234567890123456";  // AES key (16 bytes for AES-128)

        // Example employee data to write (with sensitive fields)
        List<String[]> data = new ArrayList<>();
        data.add(new String[] {"ID", "Name", "Email", "Salary", "Department"});
        data.add(new String[] {"1", "John Doe", "john.doe@example.com", "50000", "IT"});
        data.add(new String[] {"2", "Jane Smith", "jane.smith@example.com", "55000", "HR"});
        data.add(new String[] {"3", "Jack Brown", "jack.brown@example.com", "60000", "Finance"});

        // Encrypt and write to CSV
        encryptAndWriteToCSV(data, encryptedCsvFilePath, key);

        // Read and decrypt the CSV
        readAndDecryptCSV(encryptedCsvFilePath, key);
    }

    // AES encryption method
    public static String encrypt(String data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    // AES decryption method
    public static String decrypt(String encryptedData, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(decodedData);
        return new String(decryptedData);
    }

    // Encrypt and write data to a CSV file
    public static void encryptAndWriteToCSV(List<String[]> data, String filePath, String key) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(filePath));

            // Encrypt sensitive fields (e.g., Email and Salary)
            for (String[] row : data) {
                row[2] = encrypt(row[2], key);  // Encrypt Email
                row[3] = encrypt(row[3], key);  // Encrypt Salary
                writer.writeNext(row);
            }

            writer.close();
            System.out.println("Data written to encrypted CSV file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read and decrypt data from the CSV file
    public static void readAndDecryptCSV(String filePath, String key) {
        try {
            CSVReader reader = new CSVReader(new FileReader(filePath));
            List<String[]> rows = reader.readAll();

            // Decrypt sensitive fields (e.g., Email and Salary)
            for (String[] row : rows) {
                if (!row[0].equals("ID")) {  // Skip header row
                    row[2] = decrypt(row[2], key);  // Decrypt Email
                    row[3] = decrypt(row[3], key);  // Decrypt Salary
                }
                // Print the decrypted row
                System.out.println(String.join(",", row));
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

