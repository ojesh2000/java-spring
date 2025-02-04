package com.objectMapperDemo.ObjectMapperDemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.objectMapperDemo.ObjectMapperDemo.custom.CarDeserializer;
import com.objectMapperDemo.ObjectMapperDemo.custom.CarSerializer;
import com.objectMapperDemo.ObjectMapperDemo.fileUtils.FileReader;
import com.objectMapperDemo.ObjectMapperDemo.fileUtils.FileWriter;
import com.objectMapperDemo.ObjectMapperDemo.models.Car;
import org.apache.logging.log4j.CloseableThreadContext;
import org.springframework.boot.SpringApplication;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class ObjectMapperDemoApplication {

	public static void main(String[] args) throws IOException {
//		FileWriter fileWriter = new FileWriter();
//		fileWriter.writeObjectToFile();

		FileReader fileReader = new FileReader();
//		System.out.println(fileReader.readFileContents());
//		fileReader.readFileAsJsonNode();
//		fileReader.readFileToArray();
//		fileReader.readFileToMap();
//		fileReader.readADate();

//		customSerializerExample();
		customDeserializeExample();


	}

	public static void customSerializerExample() throws JsonProcessingException {
		Car car = new Car();
		car.setName("EECO");
		car.setBrand("Suzuki");
		car.setPurchaseDate(Date.from(Instant.from(LocalDate.now().atStartOfDay(ZoneId.of("GMT")))));
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleModule simpleModule = new SimpleModule("CarSerializer",new Version(1, 0, 0, null, null, null));
		simpleModule.addSerializer(Car.class, new CarSerializer());
		objectMapper.registerModule(simpleModule);
		System.out.println(objectMapper.writeValueAsString(car));
	}

	public static void customDeserializeExample() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleModule module = new SimpleModule("CarDeserializer", new Version(1, 0, 0, null, null, null));
		module.addDeserializer(Car.class, new CarDeserializer());
		objectMapper.registerModule(module);
		Car car = objectMapper.readValue(new File("src/main/java/com/objectMapperDemo/ObjectMapperDemo/files/readFileDate.txt"), Car.class);
		System.out.println(car);
	}

}
