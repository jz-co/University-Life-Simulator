package com.example.game.DataHandler;

import com.example.game.Contract.IData;
import com.example.game.Model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader implements IData.IDataLoader {
    // username, password, level, credits, gpa, hp, campus, name. appearence, language

    /** retrieve a list of student from the csv file, for each student
     *
     * @return Arraylist of student
     */
    public List<Student> loadAll(){
        List<Student> students = new ArrayList<>();
        BufferedReader reader;
        String row;
        try {
            reader = new BufferedReader(new FileReader("studentData.csv"));
            while ((row = reader.readLine()) != null){
                String[] data = row.split(",");
                String username = data[0];
                String password = data[1];
                int currentLevel = Integer.parseInt(data[2]);
                int credit = Integer.parseInt(data[3]);
                double gpa = Double.parseDouble(data[4]);
                double hp = Double.parseDouble(data[5]);
                String name = data[6];
                int appearance = Integer.parseInt(data[7]);
                String language = data[8];
                // there is no game level in the campus
                Student student = new Student(username, password, currentLevel, credit,
                        gpa, hp, name, appearance, language);
                students.add(student);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
