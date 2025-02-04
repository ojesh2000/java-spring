package com.example.football.Annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class AnnotationsApplication {


	public static void main(String[] args) {
		FileReader fileReader = new FileReader();
		System.out.println(fileReader.getFileContent("/Users/B0295829/Desktop/dev-spring-boot/Files/src/main/java/com/example/football/Annotations/readFile.txt"));

		FileWriter fileWriter = new FileWriter();
		fileWriter.writeToFileFromBytes("/Users/B0295829/Desktop/dev-spring-boot/Files/src/main/java/com/example/football/Annotations/writeFile.txt");

		BufferedFileWriter bufferedFileWriter = new BufferedFileWriter();
		bufferedFileWriter.writeToFileFromBytes("/Users/B0295829/Desktop/dev-spring-boot/Files/src/main/java/com/example/football/Annotations/bufferWriteFile.txt");

		BufferedFileReader bufferedFileReader = new BufferedFileReader();
		System.out.println(bufferedFileReader.readFile("/Users/B0295829/Desktop/dev-spring-boot/Files/src/main/java/com/example/football/Annotations/bufferReadFile.txt"));
	}

}
