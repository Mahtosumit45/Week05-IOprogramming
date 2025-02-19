package com.PracticeProblems;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
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

}
public class ListToJsonExample {
    public static void main(String[] args) {
        try{
            List<Person> people = new ArrayList<>();
            people.add(new Person("John", 30));
            people.add(new Person("Jane", 40));
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(people);
            System.out.println("JSON Array: " +jsonArray);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
