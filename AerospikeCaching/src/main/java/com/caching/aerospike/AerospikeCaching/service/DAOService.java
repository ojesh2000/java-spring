package com.caching.aerospike.AerospikeCaching.service;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.policy.RecordExistsAction;
import com.aerospike.client.policy.WritePolicy;
import com.caching.aerospike.AerospikeCaching.dao.StudentsDao;
import com.caching.aerospike.AerospikeCaching.models.StudentList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DAOService {
    @Autowired
    AerospikeClient aerospikeClient;
    @Autowired
    StudentsDao studentsDao;

    @Autowired
    ObjectMapper mapper;

    public StudentList getAllStudents() throws JsonProcessingException {
        Key key = new Key("student", "studentSet", "all");
        Record record = aerospikeClient.get(null, key);
        if(record == null) {
            StudentList students = studentsDao.getAllStudents();
            WritePolicy writePolicy = new WritePolicy();
            writePolicy.setTimeout(300);
            writePolicy.expiration = (10);
            writePolicy.recordExistsAction = RecordExistsAction.REPLACE;
            writePolicy.maxRetries = 0;
            aerospikeClient.put(writePolicy, key, new Bin("OBJECT", mapper.writeValueAsString(students)));
            return students;
        }else{
            StudentList x = mapper.readValue(record.bins.get("OBJECT").toString(), new TypeReference<StudentList>(){});
            x.setCachedResponse(Boolean.TRUE);
            return x;
        }
    }

}
