package com.example.universitylife.Leaderboard;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.universitylife.R;

public class LeaderboardActivity extends AppCompatActivity implements ILeaderboard.ILeaderboardView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
    }
    @Override
    public void displayAvatar(int i, int picIndex) {

    }

    @Override
    public void displayName(int i, String name) {

    }

    @Override
    public void displayGpa(int i, double gpa) {

    }

    @Override
    public void displayUserInfo(int picIndex, String name, double gpa) {

    }
}
