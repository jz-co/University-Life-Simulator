package com.example.universitylife.Leaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.universitylife.CharacterIcons;
import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.DataHandler.RankingHandler;
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
        presenter = new LeaderboardPresenter(username, new RankingHandler(this));

        characterIcons = new CharacterIcons(this);

        displayCurrentUserInfo();
        displayLeaderBoard();
    }

    /**
     * Displays on screen the contents of the leaderboard.
     */
    private void displayLeaderBoard() {
        listView = findViewById(R.id.leaderboard_list);
        adapter = new LeaderboardListAdapter(this, presenter);
        listView.setAdapter(adapter);
    }

    /**
     * Displays the contents of the current user.
     */
    private void displayCurrentUserInfo() {
        TextView textViewCurrName = findViewById(R.id.textViewCurrUsername);
        TextView textViewCurrGPA = findViewById(R.id.textViewCurrGPA);
        ImageView imageViewCurrIcon = findViewById(R.id.imageViewCurrIcon);

        textViewCurrName.setText(presenter.getCurrName());
        textViewCurrGPA.setText(presenter.getCurrGPA());
        imageViewCurrIcon.setImageResource(getIconIdentifier(presenter.getPicIndex()));

    }

    /**
     * Executes when back button clicked.
     */
    public void onClickBack(View view) {
        finish();
    }

    /**
     * Returns the image identifier
     */
    int getIconIdentifier(int index) {
        return characterIcons.getIconByIndex(index);
    }
}
