package com.example.universitylife.DataHandler;

import android.renderscript.Sampler;
import android.service.notification.NotificationListenerService;

import androidx.annotation.NonNull;

import com.example.universitylife.Leaderboard.ILeaderboard;
import com.example.universitylife.Student.StudentData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RankingHandler {

    private FireBaseDataHandler fireBaseDataHandler;
    private ArrayList<ILeaderboard.ILeaderboardStudent> topFive = new ArrayList<>();

    public RankingHandler() {
        this.fireBaseDataHandler = new FireBaseDataHandler();
    }

    /** get top five gpa
     *
     * @return ArrayList<Student> student
     */
    public ArrayList<ILeaderboard.ILeaderboardStudent> getTop5gpaStudent() {
        Query query = FirebaseDatabase.getInstance().getReference().child(fireBaseDataHandler.getNameOfTable()).orderByChild("gpa").limitToLast(5);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    StudentData student = postSnapshot.getValue(StudentData.class);
                    topFive.add(student.dataToStudent());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return reverseTopFive();
    }

    private ArrayList<ILeaderboard.ILeaderboardStudent> reverseTopFive() {
        ArrayList<ILeaderboard.ILeaderboardStudent> reversedList = new ArrayList<>();
        for (int i = topFive.size() - 1 ; i >= 0; i--){
            reversedList.add(topFive.get(i));
        }
        return reversedList;
    }
}
