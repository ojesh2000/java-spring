package com.objectMapperDemo.ObjectMapperDemo.fileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.objectMapperDemo.ObjectMapperDemo.models.BankAccount;

import java.io.File;
import java.io.IOException;

public class FileWriter {

    public void writeObjectToFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("src/main/java/com/objectMapperDemo/ObjectMapperDemo/files/writeFile.txt"), BankAccount.builder().id(123).holderName("Geekific").build());
        System.out.println("Completed this process!!");
    }


}
