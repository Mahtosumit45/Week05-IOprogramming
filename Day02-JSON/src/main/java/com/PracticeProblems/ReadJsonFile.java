package com.PracticeProblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ReadJsonFile {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON from file into JsonNode
            JsonNode rootNode = objectMapper.readTree(new File("data.json"));

            // Extract specific fields from the JSON
            String name = rootNode.path("name").asText();
            String email = rootNode.path("email").asText();

            // Print extracted values
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

