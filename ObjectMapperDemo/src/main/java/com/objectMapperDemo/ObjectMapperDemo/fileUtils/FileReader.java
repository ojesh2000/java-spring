package com.objectMapperDemo.ObjectMapperDemo.fileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.objectMapperDemo.ObjectMapperDemo.models.BankAccount;
import com.objectMapperDemo.ObjectMapperDemo.models.Car;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FileReader {

    public BankAccount readFileContents() throws IOException {
        System.out.println();
        System.out.println("Inside readFileContents function");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("src/main/java/com/objectMapperDemo/ObjectMapperDemo/files/readFile.txt"), BankAccount.class);
    }

    public void readFileAsJsonNode() throws IOException {
        System.out.println();
        System.out.println("Inside readFileAsJsonNode function");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new FileInputStream("src/main/java/com/objectMapperDemo/ObjectMapperDemo/files/readFile.txt"));
        Iterator<String> x = jsonNode.fieldNames();
        while(x.hasNext()){
            System.out.println(x.next());
        }
        System.out.println(jsonNode.get("id").asText());
        System.out.println(jsonNode.get("holderName").asText());
//        System.out.println(jsonNode.get("holderName").get("abc").get("xyz"));//throws NullPointer as "jsonNode.get("holderName").get("abc")" is null
    }

    public void readFileToArray() throws IOException {
        System.out.println();
        System.out.println("Inside readFileFromArray function");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        BankAccount[] accounts = objectMapper.readValue(new File("src/main/java/com/objectMapperDemo/ObjectMapperDemo/files/readFileArray.txt"), BankAccount[].class);

        for(BankAccount x : accounts){
            System.out.println(x);
        }
    }

    public void readFileToMap() throws IOException{
        System.out.println();
        System.out.println("Inside readFileToMap function");
        ObjectMapper objectMapper = new ObjectMapper();
        //we can also use Type Reference to map a json array to an array of an object
        Map<String, Object> x = objectMapper.readValue(new File("src/main/java/com/objectMapperDemo/ObjectMapperDemo/files/readFile.txt"), new TypeReference<Map<String, Object>>() {});

        for(Map.Entry<String, Object> y : x.entrySet()){
            System.out.println(y.getKey() + "        " + y.getValue() + "  ----->  " + y.getValue().getClass());
        }
    }

    public void readADate() throws IOException{
        System.out.println();
        System.out.println("Inside readADate function");
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = objectMapper.readValue(new File("src/main/java/com/objectMapperDemo/ObjectMapperDemo/files/readFileDate.txt") , Car.class);
//        objectMapper.writeValueAsString()// converts an object into a json string(includes map as well)
        System.out.println(car);

    }
}
