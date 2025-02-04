package com.example.football.Annotations;

import org.springframework.stereotype.Service;

import java.io.FileInputStream;

public class FileReader {

    public String getFileContent(String path){
        //int consists of 4 bytes
        try(FileInputStream inputStream = new FileInputStream(path)){
            int b;
            String content = "";
            while((b = inputStream.read()) != -1){//denotes end of file
                content = content + (char)(b);//int denotes ascii value. Here we typecast that value into a char
            }
            inputStream.close();
            return content;
        } catch (Exception ex){
            throw new RuntimeException("Error Recieved file reading the file: " + ex.getMessage());
        }
    }

}
