package com.example.football.Annotations;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedFileWriter {

    public void writeToFileFromBytes(String path){
        try(FileOutputStream fileOutputStream = new FileOutputStream(path)){
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            String s = "Write this to the file";
            bufferedOutputStream.write(s.getBytes());
            bufferedOutputStream.close();
            fileOutputStream.close();
            System.out.println("Written to the file: " + path);
        }catch(Exception ex){
            throw new RuntimeException("Error received while writing the file: " + ex.getMessage());
        }
    }
}
