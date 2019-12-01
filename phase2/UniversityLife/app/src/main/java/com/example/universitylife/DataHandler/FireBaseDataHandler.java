package com.example.universitylife.DataHandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.universitylife.IData;
import com.example.universitylife.Student.StudentFacade;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FireBaseDataHandler implements IData {
    private DatabaseReference studentDatabase;
    private String nameOfTable = "students";

    public FireBaseDataHandler() {
        studentDatabase = FirebaseDatabase.getInstance().getReference(nameOfTable);
    }

    /**
     * Add a new student to the database.
     *
     * @param student the new student.
     */
    public void addStudentData(StudentFacade student) {
        studentDatabase.child(student.getUsername()).setValue(student);
    }

    /** get the list of the students in the database
     *
     * @return ArrayList<Student>
     */
    private ArrayList<StudentFacade> getStudentsList() {
        final ArrayList<StudentFacade> students = new ArrayList<>();
        studentDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                students.clear();
                if (dataSnapshot.hasChildren()) {
                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                        StudentFacade student = userSnapshot.getValue(StudentFacade.class);
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
    public void updateStudentData(StudentFacade student) {
        String username = student.getUsername();
        DatabaseReference student_data = studentDatabase.child(username);
        student_data.setValue(student);
    }

    /** get student by username
     *
     * @param userName the username of the user
     * @return a student with the corresponding username
     */
    public StudentFacade getStudentByUserName(final String userName) {
        ArrayList<StudentFacade> students = getStudentsList();
        for (StudentFacade s : students) {
            if (s.getUsername().equals(userName)){
                return s;
            }
        }
        return null;
    }


    public String getNameOfTable() {
        return nameOfTable;
    }

}
