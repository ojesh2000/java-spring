package com.example.football.Annotations;

import java.io.FileOutputStream;

public class FileWriter {

    public void writeToFileFromBytes(String path){
        byte[] writeToFile = {'A', ' ', 'B'};
        try(FileOutputStream outputStream = new FileOutputStream(path)){
            outputStream.write(writeToFile);
            outputStream.close();
            System.out.println("Write Completed!!");
        }catch (Exception ex){
            throw new RuntimeException("Error while writing to file: " + ex.getMessage());
        }
    }




}
