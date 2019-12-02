package com.example.universitylife.DataHandler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

public class RankingHandler extends DataHandler implements IRanking {


    public RankingHandler(Context context){
        super(context);
    }

    public ArrayList<StudentData> getTopFive() {
        int count = 0;
        ArrayList<StudentData> students = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_STUDENTS + " ORDER BY " +
                COLUMN_GPA + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                StudentData student = getThisStudent(cursor);
                count += 1;
                students.add(student);
            } while (cursor.moveToNext() && count <= 5);
        }
        return new ArrayList(students.subList(0, 4));
    }
}
