package com.example.universitylife.DataHandler;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.renderscript.Sampler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.universitylife.Student;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

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

    /** get the list of the students in the database
     *
     * @return ArrayList<Student>
     */
    public ArrayList<Student> getStudentsList(){
        final ArrayList<Student> students = new ArrayList<>();
        studentDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                students.clear();
                if (dataSnapshot.hasChildren()) {
                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                        Student student = userSnapshot.getValue(Student.class);
                        students.add(student);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return students;
    }


    /**
     * update Student Data
     */
    public void updateStudentData(Student student){
        String username = student.getUsername();
        DatabaseReference student_data = studentDatabase.child(username);
        student_data.setValue(student);
    }

    /** get student by username
     *
     * @param userName the username of the user
     * @return a student with the corresponding username
     */
    public Student getStudentByUserName(final String userName) {
        ArrayList<Student> students = getStudentsList();
        for (Student s: students){
            if (s.getUsername().equals(userName)){
                return s;
            }
        }
        return null;
    }


    DatabaseReference getStudentDatabase(){
        return studentDatabase;
    }

}
