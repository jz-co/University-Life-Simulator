package com.example.game.Contract;

import com.example.game.Model.Student;

import java.util.ArrayList;
import java.util.List;

public interface IData {
    void addStudentData(Student student);
    void updateStudentData(Student student);
    Student getStudentByUserName(String userName);
}
