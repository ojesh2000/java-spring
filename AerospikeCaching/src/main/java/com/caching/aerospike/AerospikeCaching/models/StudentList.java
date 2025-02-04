package com.caching.aerospike.AerospikeCaching.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentList extends BaseCacheResponse{
    private List<Student> students;
}
