package com.PracticeProblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import java.util.stream.Collectors;

class Person2 {
    private String name;
    private int age;

    public Person2() {}
    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "{\"name\":\"" + name + "\", \"age\":" + age + "}";
    }
}

public class FilterJsonExample {
    public static void main(String[] args) {
        try {
            String jsonArray = "[{\"name\":\"John\",\"age\":30},"
                    + "{\"name\":\"Alice\",\"age\":25},"
                    + "{\"name\":\"Bob\",\"age\":35},"
                    + "{\"name\":\"Charlie\",\"age\":22}]";


            ObjectMapper mapper = new ObjectMapper();


            List<Person2> people = Arrays.asList(mapper.readValue(jsonArray, Person2[].class));


            List<Person2> filteredPeople = people.stream()
                    .filter(person -> person.getAge() > 25)
                    .collect(Collectors.toList());


            System.out.println("\nFiltered JSON:");

            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredPeople));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
