package com.objectMapperDemo.ObjectMapperDemo.custom;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.objectMapperDemo.ObjectMapperDemo.models.Car;

import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CarDeserializer extends StdDeserializer<Car> {
    public CarDeserializer(Class<?> vc) {
        super(vc);
    }

    public CarDeserializer(){
        this(null);
    }

    @Override
    public Car deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        Car car = new Car();
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);
        car.setName(node.get("name").asText());
        car.setBrand(node.get("myBrandName").asText());
        LocalDate purchaseDate = LocalDate.parse(node.get("purchaseDate").asText(), DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss"));
        car.setPurchaseDate(Date.from(Instant.from(purchaseDate.atStartOfDay(ZoneId.of("GMT")))));
        return car;
    }
}