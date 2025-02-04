package com.objectMapperDemo.ObjectMapperDemo.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car{
    private String name;
    //map this field to json key value pair that has value
    // "brand_name" or "brandName" or "myBrandName"
    // as its key
    @JsonAlias({"brand_name", "brandName", "myBrandName"})
    private String brand;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date purchaseDate;
}
