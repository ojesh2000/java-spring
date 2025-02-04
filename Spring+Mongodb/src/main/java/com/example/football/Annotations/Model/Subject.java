package com.example.football.Annotations.Model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Subject {
    @Field("subject_name")
    private String subjectName;

    @Field("marks_obtained")
    private int marksObtained;

    public String getSubjectName() {
        return subjectName;
    }

    public int getMarksObtained() {
        return marksObtained;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setMarksObtained(int marksObtained) {
        this.marksObtained = marksObtained;
    }
}
