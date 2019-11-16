package com.example.universitylife.Contract;

import com.example.universitylife.Model.Student;

import java.util.ArrayList;
import java.util.List;

public interface IData {
    void addStudentData(Student student);
    void updateStudentData(Student student);
    Student getStudentByUserName(String userName);
}
