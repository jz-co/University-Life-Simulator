package com.example.game.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.game.Contract.IProfile;
import com.example.game.DataHandler.DataHandler;
import com.example.game.Presenter.ProfilePresenter;
import com.example.game.R;


public class ProfileActivity extends AppCompatActivity implements IProfile.IProfileView {

    private TextView nameView;
    private TextView gpaView;
    private TextView creditsView;
    private ImageView userIcon;
    private CharacterIcons icons;

    private String username;

    private ProfilePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        username = (String) getIntent().getSerializableExtra("Username");

        nameView = (TextView) findViewById(R.id.nameView);
        gpaView = (TextView) findViewById(R.id.gpaView);
        creditsView = (TextView) findViewById(R.id.creditsView);
        userIcon = (ImageView) findViewById(R.id.characterIconView);

        presenter = new ProfilePresenter(this, new DataHandler(this), username);
        nameView.setText(presenter.getName());
        gpaView.setText(presenter.getGPA());
        creditsView.setText(presenter.getCredits());

        icons = new CharacterIcons(this);
        int picIdentifier = icons.getIconByIndex(presenter.getPicIndex());
        userIcon.setImageResource(picIdentifier);

    }

    public void onClickCustomize (View view) {
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
