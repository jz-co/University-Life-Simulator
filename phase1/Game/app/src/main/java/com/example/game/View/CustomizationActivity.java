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
import com.example.game.DataHandler.DataLoader;
import com.example.game.DataHandler.DataSaver;
import com.example.game.Presenter.CustomizationPresenter;
import com.example.game.R;

import java.util.ArrayList;

public class CustomizationActivity extends AppCompatActivity implements ICustomizationView {
    private CustomizationPresenter presenter;
    private ArrayList<Integer> characterIcons;
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

        characterIcons = new ArrayList<Integer>();
        populateCharacterIcons();

        customName = (EditText) findViewById(R.id.customNameText);
        characterIconView = (ImageView) findViewById(R.id.characterIconView);
    }

    void populateCharacterIcons() {
        characterIcons.add(getResources().getIdentifier("@drawable/boy1", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/gir1", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/boy2", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/girl2", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/boy3", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/girl3", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/pikachu", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/cactus", null, this.getPackageName()));
    }

    /**
     * Executes when the switch avatar button is clicked.
     * @param view
     */
    public void nextPicture(View view) {
        currPicIndex += 1;
        if (currPicIndex == characterIcons.size()) {
            currPicIndex = 0;
        }

        characterIconView.setImageResource(characterIcons.get(currPicIndex));
    }

//    @Override
//    public void previousPicture() {
//
//    }

//    @Override
//    public int getPictureIndex() {
//        return 0;
//    }
//
//    @Override
//    public String getName() {
//        return null;
//    }
//
//
//    @Override
//    public String getLang() {
//        return null;
//    }

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
