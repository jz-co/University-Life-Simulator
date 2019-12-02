package com.example.universitylife.Leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.universitylife.R;

import java.util.List;

public class LeaderboardListAdapter extends BaseAdapter {
    private LeaderboardActivity context;
    private List<ILeaderboard.ILeaderboardStudent> topFiveStudents;

    LeaderboardListAdapter(LeaderboardActivity context, ILeaderboard.ILeaderboardPresenter presenter) {
        this.context = context;
        this.topFiveStudents = presenter.getLeaderBoardList();
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
            scoreView = LayoutInflater.from(context).inflate(R.layout.leaderboard_list_row_layout, parent, false);
        }
        
        // get current student to be displayed in leaderboard
        ILeaderboard.ILeaderboardStudent currStudent = (ILeaderboard.ILeaderboardStudent) getItem(rank);

        // get the TextView for the ranking, username and gpa,
        TextView textViewRanking = scoreView.findViewById(R.id.ranking);
        TextView textViewUsername = scoreView.findViewById(R.id.username);
        TextView textViewGPA = scoreView.findViewById(R.id.gpa);
        ImageView userImage = scoreView.findViewById(R.id.user_image);

        textViewRanking.setText(String.valueOf(rank));
        textViewUsername.setText(currStudent.getUsername());
        textViewGPA.setText(String.valueOf(currStudent.getGpa()));
        userImage.setImageResource(context.getIconIdentifier(currStudent.getAppearance()));

        return scoreView;
    }


}
