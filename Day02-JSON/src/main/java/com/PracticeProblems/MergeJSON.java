package com.PracticeProblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class MergeJSON {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();


        String json1 = "{\"name\": \"John\", \"age\": 25}";
        String json2 = "{\"email\": \"john@example.com\", \"city\": \"New York\"}";


        JsonNode jsonNode1 = mapper.readTree(json1);
        JsonNode jsonNode2 = mapper.readTree(json2);


        ((ObjectNode) jsonNode1).setAll((ObjectNode) jsonNode2);


        System.out.println("Merged JSON: ");
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode1));
    }
}

