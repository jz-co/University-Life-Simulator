package com.example.universitylife.Leaderboard;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.universitylife.R;
import com.example.universitylife.Student.StudentFacade;

import static java.lang.Double.valueOf;

public class LeaderboardActivity extends AppCompatActivity implements ILeaderboard.ILeaderboardView {
    LeaderboardPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        ImageView currentAvatar = (ImageView) findViewById(R.id.imageView2);
        currentAvatar.setImageResource(presenter.currentAvatar());
        TextView currentUsername = (TextView) findViewById(R.id.textView30);
        String username = "Username" + presenter.currentUserName();
        currentUsername.setText(username);
        TextView currentGPA = (TextView) findViewById(R.id.textView31);
        String gpa = String.valueOf(presenter.currentGPA());
        currentGPA.setText(gpa);
    }
    @Override
    public void displayAvatar(int i, int picIndex) {
        ImageView image;
        if(i == 1) {
             image = (ImageView) findViewById(R.id.imageView3);
        }
        else if (i == 2) {
            image = (ImageView) findViewById(R.id.imageView4);
        }
        else if (i == 3) {
            image = (ImageView) findViewById(R.id.imageView5);
        }
        else if (i == 4) {
            image = (ImageView) findViewById(R.id.imageView6);
        }
        else{
            image = (ImageView) findViewById(R.id.imageView7);
        }
    }

    @Override
    public void displayName(int i, String name) {
        TextView studentName;
        if(i == 1) {
            studentName = (TextView) findViewById(R.id.textView20);
            studentName.setText(presenter.leaderBoardName(1));
        }
        else if (i == 2) {
            studentName = (TextView) findViewById(R.id.textView21);
            studentName.setText(presenter.leaderBoardName(2));
        }
        else if (i == 3) {
            studentName = (TextView) findViewById(R.id.textView22);
            studentName.setText(presenter.leaderBoardName(3));
        }
        else if (i == 4) {
            studentName = (TextView) findViewById(R.id.textView23);
            studentName.setText(presenter.leaderBoardName(4));
        }
        else{
            studentName = (TextView) findViewById(R.id.textView24);
            studentName.setText(presenter.leaderBoardName(5));
        }
    }

    @Override
    public void displayGpa(int i, double gpa) {
        TextView studentGPA;
        if(i == 1) {
            studentGPA = (TextView) findViewById(R.id.textView25);
            studentGPA.setText(presenter.leaderBoardName(1));
        }
        else if (i == 2) {
            studentGPA = (TextView) findViewById(R.id.textView25);
            studentGPA.setText(presenter.leaderBoardName(2));
        }
        else if (i == 3) {
            studentGPA = (TextView) findViewById(R.id.textView25);
            studentGPA.setText(presenter.leaderBoardName(3));
        }
        else if (i == 4) {
            studentGPA = (TextView) findViewById(R.id.textView25);
            studentGPA.setText(presenter.leaderBoardName(4));
        }
        else{
            studentGPA = (TextView) findViewById(R.id.textView25);
            studentGPA.setText(presenter.leaderBoardName(5));
        }
    }

    @Override
    public void displayUserInfo(int picIndex, String name, double gpa) {

    }
}
