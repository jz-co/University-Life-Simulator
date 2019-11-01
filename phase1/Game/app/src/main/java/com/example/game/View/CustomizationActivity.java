package com.example.game.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.game.Contract.ICustomization.*;
import com.example.game.DataHandler.DataHandler;
import com.example.game.Presenter.CustomizationPresenter;
import com.example.game.R;

import java.util.ArrayList;

public class CustomizationActivity extends AppCompatActivity implements ICustomizationView {
    private CustomizationPresenter presenter;
    private CharacterIcons icons;
    private EditText customName;
    private ImageView characterIconView;

    private int currPicIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customization);

        //
        String username = (String) getIntent().getSerializableExtra("Username");

        presenter = new CustomizationPresenter(this, new DataHandler(this), username);

        customName = (EditText) findViewById(R.id.customNameText);
        characterIconView = (ImageView) findViewById(R.id.characterIconView);

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
    public void navigateToCourseSelector(String username) {
        Intent intent = new Intent(this, CourseSelectorActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }
}
