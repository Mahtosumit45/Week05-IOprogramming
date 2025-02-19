package com.PracticeProblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonValidationExample {
    public static void main(String[] args) {

        String validJson = "{\"name\": \"John\", \"age\": 30}";
        String invalidJson = "{\"name\": \"John\", \"age\": }";  // Missing value for "age"


        System.out.println("Validating valid JSON:");
        validateJsonStructure(validJson);

        System.out.println("\nValidating invalid JSON:");
        validateJsonStructure(invalidJson);
    }


    private static void validateJsonStructure(String jsonString) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            JsonNode jsonNode = mapper.readTree(jsonString);
            System.out.println("Valid JSON structure!");
            System.out.println(jsonNode.toString());
        } catch (JsonProcessingException e) {

            if (e instanceof JsonMappingException) {
                System.out.println("Invalid JSON structure: " + e.getMessage());
            } else {
                System.out.println("Invalid JSON format: " + e.getMessage());
            }
        }
    }
}

