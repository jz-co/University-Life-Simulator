package com.example.universitylife;

import com.example.universitylife.Student;

public interface IData {
    void addStudentData(Student student);
    void updateStudentData(Student student);
    Student getStudentByUserName(String userName);
}
