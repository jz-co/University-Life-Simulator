package com.example.gamedraft;

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
    ArrayList<Student> loadAll(){
        ArrayList<Student> students = new ArrayList<>();
        BufferedReader reader = null;
        String row;
        try {
            reader = new BufferedReader(new FileReader("studentData.csv"));
            while ((row = reader.readLine()) != null){
                String[] data = row.split(",");
                //extract campus data, create a campus for student
                Campus campus = new StGeorge(Integer.parseInt(data[3]));
                // there is no game level in the campus
                Student student = new Student(data[0], data[1], data[2], data[3], data[4], data[5],
                        campus, data[7], data[8], data[9]);
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
