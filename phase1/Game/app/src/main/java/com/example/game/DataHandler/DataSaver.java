package com.example.game.DataHandler;

import com.example.game.Model.Student;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DataSaver {
    // responsible for adding, updating, and deleting data from the csv file
    // the csv should contain 11 columns
    // userid, username, password, level, credits, gpa, hp, campus, name. appearence, language

    /** save all the student data into the csv file
     *
     * @param students
     * @return Boolean : true --> save successfully; false --> failed to save
     */
    boolean saveAll(ArrayList<Student> students){
        FileWriter writer = null;
        try {
            writer = new FileWriter("studentData.csv");
            for (Student student: students){
                // username of the student
                writer.append(student.getUsername());
                writer.append(",");
                //password of the student
                writer.append(student.getPassword());
                writer.append(",");
                //get current level of the student
                writer.append(Integer.toString(student.getLevel()));
                writer.append(",");
                // get credit of the student
                writer.append(Integer.toString(student.getCredit()));
                writer.append(",");
                // get gpa of the student
                writer.append(Double.toString(student.getGpa()));
                writer.append(",");
                // get hp of the student
                writer.append(Double.toString(student.getHp()));
                writer.append(",");
                // get campus name of the student
                writer.append(student.getCampusName());
                writer.append(",");
                //get customized name of the student
                writer.append(student.getName());
                writer.append(",");
                // get the id of the customized appearence
                writer.append(Integer.toString(student.getAppearence()));
                writer.append(",");
                // get the language of the customized langugae
                writer.append(student.getLanguage());
                writer.append("\n");
            }

            writer.flush();
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
