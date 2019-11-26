package com.example.universitylife.DataHandler;

import android.service.notification.NotificationListenerService;

import androidx.annotation.NonNull;

import com.example.universitylife.Student;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RankingHandler {
    private FireBaseDataHandler dataBaseHandler;
    public RankingHandler(FireBaseDataHandler fireBaseDataHandler){
        this.dataBaseHandler = fireBaseDataHandler;
    }

    /** get top five gpa
     *
     * @return ArrayList<Student> student
     */
    public ArrayList<Student> getTop5gpaStudent(){
        final ArrayList<Student> topFive = new ArrayList<>();
        Query query = dataBaseHandler.getStudentDatabase().orderByChild("gpa").limitToLast(5);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                        Student student = userSnapshot.getValue(Student.class);
                        topFive.add(student);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return topFive;

    }
}
