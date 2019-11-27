package com.example.universitylife.Customization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.universitylife.Customization.ICustomization.*;
import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.Profile.ProfileActivity;
import com.example.universitylife.R;
import com.example.universitylife.CharacterIcons;


public class CustomizationActivity extends AppCompatActivity implements ICustomizationView {
    private CustomizationPresenter presenter;
    private CharacterIcons icons;
    private EditText customName;
    private ImageView characterIconView;

    private int currPicIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_customization);

        //
        String username = (String) getIntent().getSerializableExtra("Username");

        presenter = new CustomizationPresenter(this, new DataHandler(this), username);

        customName = findViewById(R.id.customNameText);
        characterIconView = findViewById(R.id.characterIconView);

        icons = new CharacterIcons(this);
        int picIdentifier = icons.getIconByIndex(currPicIndex);
        characterIconView.setImageResource(picIdentifier);
    }


    /**
     * Executes when the switch avatar button is clicked.
     */
    public void nextPicture(View view) {
        currPicIndex += 1;
        if (currPicIndex == icons.getNumberOfPics()) {
            currPicIndex = 0;
        }
        int picIdentifier = icons.getIconByIndex(currPicIndex);
        characterIconView.setImageResource(picIdentifier);
    }

    /**
     * Method executes when confirm button clicked.
     */
    public void onConfirmClick(View view) {
        presenter.setCustomizations(customName.getText().toString(), currPicIndex, "English");
    }

    /**
     * Navigate to course selection activity.
     */ @Override
    public void navigateToProfile(String username) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }
}
