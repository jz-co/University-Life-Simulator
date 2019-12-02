package com.example.universitylife.DataHandler;

import com.example.universitylife.Student.StudentData;

import java.util.ArrayList;

public interface IRanking extends IData {
    public ArrayList<StudentData> getTopFive();
}
