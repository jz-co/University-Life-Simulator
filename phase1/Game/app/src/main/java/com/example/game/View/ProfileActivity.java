package com.example.game.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.game.Contract.IProfile;
import com.example.game.DataHandler.DataHandler;
import com.example.game.Presenter.ProfilePresenter;
import com.example.game.R;


public class ProfileActivity extends AppCompatActivity implements IProfile.IProfileView {

    private String username;

    private ProfilePresenter presenter;

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
        ImageView userIcon = findViewById(R.id.characterIconView);

        presenter = new ProfilePresenter(this, new DataHandler(this), username);
        nameView.setText(presenter.getName());
        gpaView.setText(presenter.getGPA());
        creditsView.setText(presenter.getCredits());

        CharacterIcons icons = new CharacterIcons(this);
        int picIdentifier = icons.getIconByIndex(presenter.getPicIndex());
        userIcon.setImageResource(picIdentifier);

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
}
