package com.example.universitylife.Leaderboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.universitylife.R;
import com.example.universitylife.Student.StudentFacade;

import java.util.List;

public class LeaderboardListAdapter extends BaseAdapter {
    private Context context;
    private List<StudentFacade> topFiveStudents;

    public LeaderboardListAdapter(Context context, List<StudentFacade> topFiveStudents) {
        this.context = context;
        this.topFiveStudents = topFiveStudents;
    }

    @Override
    public int getCount() {
        return topFiveStudents.size();
    }

    @Override
    public Object getItem(int rank) {
        return topFiveStudents.get(rank);
    }

    @Override
    public long getItemId(int rank) {
        return rank;
    }

    @Override
    public View getView(int rank, View scoreView, ViewGroup parent) {
        // inflate the layout for each list row
        if (scoreView == null) {
            scoreView = LayoutInflater.from(context).inflate(R.layout.list_row_layout, parent, false);
        }

        // get current item to be displayed
        StudentFacade currStudent = (StudentFacade) getItem(rank);

        // get the TextView for the ranking, username and gpa
        TextView textViewRanking = (TextView) scoreView.findViewById(R.id.ranking);
        TextView textViewUsername = (TextView) scoreView.findViewById(R.id.username);
        TextView textViewGPA = (TextView) scoreView.findViewById(R.id.gpa);

        textViewRanking.setText(String.valueOf(rank));
        textViewUsername.setText(currStudent.getUsername());
        textViewGPA.setText(String.valueOf(currStudent.getGpa()));

        return scoreView;
    }


}
