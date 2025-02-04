package com.objectMapperDemo.ObjectMapperDemo.custom;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.objectMapperDemo.ObjectMapperDemo.models.Car;

import java.io.IOException;

public class CarSerializer extends StdSerializer<Car> {


    public CarSerializer(Class<Car> t) {
        super(t);
    }

    public CarSerializer(){
        this(null);
    }

    @Override
    public void serialize(Car car, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("Car Name", car.getName());
        jsonGenerator.writeStringField("Car Brand", car.getBrand());
        jsonGenerator.writeStringField("Purchase Date", car.getPurchaseDate().toString());
        jsonGenerator.writeEndObject();
    }
}
