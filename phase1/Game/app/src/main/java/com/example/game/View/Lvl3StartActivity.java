package com.example.game.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.R;

/**
 * Referenced https://www.androidauthority.com/android-game-java-785331/
 */

public class Lvl3StartActivity extends AppCompatActivity {

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
    }

    public void startGame(View view) {
        Intent intent;
        intent = new Intent(this, Lvl3GameActivity.class);
        startActivity(intent);
    }
}
