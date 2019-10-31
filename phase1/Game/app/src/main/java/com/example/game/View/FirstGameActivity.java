package com.example.game.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.game.Contract.ILevel1;
import com.example.game.DataHandler.DataLoader;
import com.example.game.DataHandler.DataSaver;
import com.example.game.Presenter.Level1Presenter;
import com.example.game.R;

public class FirstGameActivity extends AppCompatActivity implements ILevel1.ILevel1View{

    private Level1Presenter level1Presenter;
    private TextView questionTV, correctTV, incorrectTV, hpTV, creditTV, gpaTV;
    private EditText answerTV;
    private Button start
    private boolean nextLevelUnlocked = false;
    private boolean pauseGame = false;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_game);
        this.username = (String) getIntent().getSerializableExtra("UserName");
        this.questionTV = findViewById(R.id.question);
        this.correctTV = findViewById(R.id.correct);
        this.incorrectTV = findViewById(R.id.incorrect);
        this.hpTV = findViewById(R.id.hpLvl1);
        this.creditTV = findViewById(R.id.creditLvl1);
        this.gpaTV = findViewById(R.id.gpaLvl1);
        this.answerTV = findViewById(R.id.answer);
        this.start = findViewById(R.id.startLv1);

        this.questionTV.setVisibility(View.INVISIBLE);
        this.correctTV.setVisibility(View.INVISIBLE);
        this.incorrectTV.setVisibility(View.INVISIBLE);
        this.answerTV.setVisibility(View.INVISIBLE);

        this.level1Presenter = new Level1Presenter(this, new DataSaver(), new DataLoader(), username);
    }

    public void goToLevel2() {
        if (!this.nextLevelUnlocked){
            Toast.makeText(this,
                    "Sorry, the current level has not been unlocked", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, Lvl2GameActivity.class);
            intent.putExtra("UserName", this.username);
            startActivity(intent);
        }
    }

    public void startGame{
        this.start.setVisibility(View.INVISIBLE);
        this.questionTV.setVisibility(View.VISIBLE);
        this.correctTV.setVisibility(View.VISIBLE);
        this.incorrectTV.setVisibility(View.VISIBLE);
        this.answerTV.setVisibility(View.VISIBLE);
        this.level1Presenter.startGame();
    }

    public void pauseOrResume_game(View view) {
        if (pauseGame) {
            this.level1Presenter.resumeGame();
        } else {
            this.level1Presenter.pauseGame();
        }
        this.pauseGame = !this.pauseGame;
    }
}
