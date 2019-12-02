package com.example.universitylife.DataHandler;

import android.content.Context;
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

    private DataHandler dataHandler;

    public RankingHandler(Context context){
        this.dataHandler = new DataHandler(context);
    }
//
//    public ArrayList<StudentData> getTopFive(){
//        String query = "Select * FROM " + TABLE_STUDENTS + " WHERE " + COLUMN_USERNAME + " = " + "userName";
//    }

}
