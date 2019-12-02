package com.example.universitylife.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.universitylife.Bookstore.BookStoreActivity;
import com.example.universitylife.CourseSelector.CourseSelectorActivity;
import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.Leaderboard.LeaderboardActivity;
import com.example.universitylife.R;
import com.example.universitylife.CharacterIcons;
import com.example.universitylife.Customization.CustomizationActivity;
import com.example.universitylife.Login.MainActivity;


public class ProfileActivity extends AppCompatActivity implements IProfile.IProfileView {

    private String username;

    private ProfilePresenter presenter;

    private TextView moneyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_profile);

        username = (String) getIntent().getSerializableExtra("Username");

        TextView nameView = findViewById(R.id.nameView);
        TextView gpaView = findViewById(R.id.gpaView);
        TextView creditsView = findViewById(R.id.creditsView);
        moneyView = findViewById(R.id.moneyView);
        ImageView userIcon = findViewById(R.id.characterIconView);

        presenter = new ProfilePresenter(this, username, new DataHandler(this));
        nameView.setText(presenter.getName());
        gpaView.setText(presenter.getGPA());
        creditsView.setText(presenter.getCredits());
        moneyView.setText(presenter.getMoney());

        CharacterIcons icons = new CharacterIcons(this);
        int picIdentifier = icons.getIconByIndex(presenter.getPicIndex());
        userIcon.setImageResource(picIdentifier);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        moneyView.setText(presenter.getMoney());
    }

    public void onClickCustomize(View view) {
        Intent intent = new Intent(this, CustomizationActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    public void onClickLogOut(View view) {
        logOut();
    }

    public void logOut() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onBackClick(View view) {
        finish();
    }

    public void onClickCourseSelection(View view) {
        Intent intent = new Intent(this, CourseSelectorActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    public void onClickGraduate(View view) {
        presenter.validateGraduation();

    }

    public void onClickBookstore(View view) {
        Intent intent = new Intent(this, BookStoreActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    @Override
    public void displayErrorMessage(String message){
        Toast warning = Toast.makeText(this, message, Toast.LENGTH_LONG);
        warning.show();
    }

    @Override
    public void navigateToEnd() {
        Intent intent = new Intent(this, LeaderboardActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }


}

