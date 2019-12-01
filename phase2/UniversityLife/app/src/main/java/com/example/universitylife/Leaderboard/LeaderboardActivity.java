package com.example.universitylife.Leaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.universitylife.CharacterIcons;
import com.example.universitylife.R;

public class LeaderboardActivity extends AppCompatActivity {

    private ListView listView;
    private LeaderboardListAdapter adapter;
    private LeaderboardPresenter presenter;

    private CharacterIcons characterIcons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_main);

        String username = (String) getIntent().getSerializableExtra("Username");
        presenter = new LeaderboardPresenter(username);

        characterIcons = new CharacterIcons(this);

        displayCurrentUserInfo();
        displayLeaderBoard();
    }

    private void displayLeaderBoard() {
        listView = findViewById(R.id.leaderboard_list);
        adapter = new LeaderboardListAdapter(this, presenter);
        listView.setAdapter(adapter);
    }

    private void displayCurrentUserInfo() {
        TextView textViewCurrName = findViewById(R.id.textViewCurrUsername);
        TextView textViewCurrGPA = findViewById(R.id.textViewCurrGPA);
        ImageView imageViewCurrIcon = findViewById(R.id.imageViewCurrIcon);

        textViewCurrName.setText(presenter.getCurrName());
        textViewCurrGPA.setText(presenter.getCurrGPA());
        imageViewCurrIcon.setImageResource(getIconIdentifier(presenter.getPicIndex()));

    }

    public void onClickBack(View view) {
        finish();
    }

    int getIconIdentifier(int index) {
        return characterIcons.getIconByIndex(index);
    }
}
