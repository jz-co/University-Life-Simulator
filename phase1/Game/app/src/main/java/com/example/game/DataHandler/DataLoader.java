package com.example.game.DataHandler;

import com.example.game.Model.Campus;
import com.example.game.Model.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataLoader {
    // username, password, level, credits, gpa, hp, campus, name. appearence, language

    /** retrieve a list of student from the csv file, for each student
     *
     * @return Arraylist of student
     */
    public ArrayList<Student> loadAll(){
        ArrayList<Student> students = new ArrayList<>();
        BufferedReader reader = null;
        String row;
        try {
            reader = new BufferedReader(new FileReader("studentData.csv"));
            while ((row = reader.readLine()) != null){
                String[] data = row.split(",");

                // there is no game level in the campus
                Student student = new Student(data[0], data[1], data[2], data[3], data[4], data[5], data[6],
                         data[7], data[8], data[9]);
                students.add(student);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
