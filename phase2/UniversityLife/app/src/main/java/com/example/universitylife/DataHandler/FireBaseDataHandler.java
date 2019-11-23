package com.example.universitylife.DataHandler;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.universitylife.Student;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBaseDataHandler {
    private DatabaseReference studentDatabase;
    private String nameOfTable = "students";

    FireBaseDataHandler(){
        studentDatabase = FirebaseDatabase.getInstance().getReference(nameOfTable);
    }

    /**
     * Add a new student to the database.
     *
     * @param student the new student.
     */
    public void addStudentData(Student student) {
        String id = studentDatabase.push().getKey();
        studentDatabase.child(id).setValue(student);
    }


}
