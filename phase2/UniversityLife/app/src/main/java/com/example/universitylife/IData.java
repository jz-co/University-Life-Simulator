package com.example.universitylife;


import com.example.universitylife.Student.StudentFacade;

public interface IData {
    void addStudentData(StudentFacade student);

    void updateStudentData(StudentFacade student);

    StudentFacade getStudentByUserName(String userName);
}
