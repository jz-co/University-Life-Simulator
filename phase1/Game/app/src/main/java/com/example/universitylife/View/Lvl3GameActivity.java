package com.example.universitylife.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * Referenced https://www.androidauthority.com/android-game-java-785331/
 *
 * Activity that initiate the game view.
 */

public class Lvl3GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        String username;
        username = (String) getIntent().getSerializableExtra("Username");
        Lvl3GameView game = new Lvl3GameView(this, username);
        setContentView(game);
    }
}
