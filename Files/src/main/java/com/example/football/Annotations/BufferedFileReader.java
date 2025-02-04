package com.example.football.Annotations;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedFileReader {

    public String readFile(String path){
        try(FileInputStream inputStream = new FileInputStream(path)){
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            int b;
            String result = "";
            while((b = bufferedInputStream.read()) != -1){
                result += (char)(b);
            }
            bufferedInputStream.close();
            inputStream.close();
            return result;
        }catch(Exception ex){
            throw new RuntimeException("Exception while reading buffered file: " + ex.getMessage());
        }
    }
}
