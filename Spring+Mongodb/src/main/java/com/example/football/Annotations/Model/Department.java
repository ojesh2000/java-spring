package com.example.football.Annotations.Model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Department {

    @Field("department_name")
    private String  departmentName;

    private String location;

    public String getDepartmentName() {
        return departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
