package com.example.universitylife.DataHandler;

import androidx.annotation.NonNull;

import com.example.universitylife.Student.StudentData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FireBaseDataHandler implements IData {
    private DatabaseReference studentDatabase;
    private String nameOfTable = "students";
    private ArrayList<StudentData> students = new ArrayList<>();
    private StudentData studentData;

    public FireBaseDataHandler() {
        studentDatabase = FirebaseDatabase.getInstance().getReference(nameOfTable);
    }

    /**
     * Add a new student to the database.
     *
     * @param student the new student.
     */
    public void addStudentData(StudentData student) {
        studentDatabase.child(student.getUsername()).setValue(student);
    }

    /** get the list of the students in the database
     *
     * @return ArrayList<Student>
     */
    private void getStudentsList() {
        studentDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                students.clear();
                if (dataSnapshot.hasChildren()) {
                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                        StudentData student = userSnapshot.getValue(StudentData.class);
                        students.add(student);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    /**
     * update Student Data
     */
    public void updateStudentData(StudentData student) {
        String username = student.getUsername();
        DatabaseReference student_data = studentDatabase.child(username);
        student_data.setValue(student);
    }

    /** get student by username
     *
     * @param userName the username of the user
     * @return a student with the corresponding username
     */
    public StudentData getStudentByUserName(String userName) {
        getStudentsList();
//        if (students.isEmpty()){
//            System.out.println("no element");
//        }
//        for (StudentData s : students) {
//            System.out.println(s.getUsername());
//            if (s.getUsername().equals(userName)){
//                System.out.println(s.getUsername());
//                return s;
//            }
//        }
        return null;
    }

    public String getNameOfTable() {
        return nameOfTable;
    }

}
