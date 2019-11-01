package com.example.game.View;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.Contract.ILevel3;
import com.example.game.DataHandler.DataHandler;
import com.example.game.Model.Level3.Lvl3GameItemManager;
import com.example.game.Presenter.Level3Presenter;
import com.example.game.R;

import org.w3c.dom.Text;

/**
 * Referenced https://www.androidauthority.com/android-game-java-785331/
 */

public class Lvl3StartActivity extends AppCompatActivity implements ILevel3.ILevel3View {

    Level3Presenter presenter;

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

        presenter = new Level3Presenter(this, new DataHandler(this), username);
        presenter.initDisplay(this);
    }

    public void startGame(View view) {
        Intent intent;
        intent = new Intent(this, Lvl3GameActivity.class);
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
     * Displays the GPA
     *
     * @param gpa achieved by student
     */
    public void displayGPA(double gpa) {
        final TextView Gpa = findViewById(R.id.textView6);
        String gpaString = "GPA: " + gpa;
        Gpa.setText(gpaString);
    }

    /**
     * Displays the Health Points
     *
     * @param hp attained by student
     */
    public void displayHP(double hp) {
        final TextView Hp = findViewById(R.id.textView8);
        String hpaString = "Health Points: " + hp;
        Hp.setText(hpaString);
    }

    /**
     * Displays the Credit
     *
     * @param credit gained by student
     */
    public void displayCredit(int credit) {
        final TextView Credit = findViewById(R.id.textView10);
        String creditString = "Credit: " + credit;
        Credit.setText(creditString);
    }
}
