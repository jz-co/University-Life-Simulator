package com.example.universitylife.Game3;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.LevelSelector.Game3LevelSelectorActivity;
import com.example.universitylife.R;

/**
 * Referenced https://www.androidauthority.com/android-game-java-785331/
 */

public class Game3StartActivity extends AppCompatActivity implements ILevel3.ILevel3View {

    Game3Presenter presenter;

    /**
     * The width of the screen.
     */
    int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;

    /**
     * The height of the screen.
     */
    int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_lvl_3);

        final Button start = findViewById(R.id.button2);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame(v);
            }
        });

        username = (String) getIntent().getSerializableExtra("Username");

        presenter = new Game3Presenter(username, new DataHandler(this));
        presenter.initDisplay(this);
    }

    public void startGame(View view) {
        Intent intent;
        intent = new Intent(this, Game3LevelSelectorActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    /**
     * Displays the username of the student
     *
     * @param name of student
     */
    public void displayName(String name) {
        final TextView username = findViewById(R.id.textView5);
        String usernameString = "Username: " + name;
        username.setText(usernameString);
    }

    /**
     * Displays the Score
     *
     * @param score achieved by student
     */
    public void displayScore(double score) {
        final TextView scoreView = findViewById(R.id.textView6);
        String gpaString = "SCORE: " + score;
        scoreView.setText(gpaString);
    }
}
