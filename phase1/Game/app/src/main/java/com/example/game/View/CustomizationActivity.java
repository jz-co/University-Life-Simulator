package com.example.game.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.game.Contract.ICustomization.*;
import com.example.game.Contract.IGameManager;
import com.example.game.Presenter.CustomizationPresenter;
import com.example.game.R;

import java.util.ArrayList;

public class CustomizationActivity extends AppCompatActivity implements ICustomizationView {
    private CustomizationPresenter presenter;
    private ArrayList characterIcons;
    private EditText customName;

    private int currPicIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customization);
        String username = (String) getIntent().getSerializableExtra("UserName");

        presenter = new CustomizationPresenter(this, username);
        characterIcons = new ArrayList();

        customName = (EditText) findViewById(R.id.customNameText);
    }

    @Override
    public void nextPicture() {

    }

    @Override
    public void previousPicture() {

    }

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

    public void onConfirmClick(View view) {
        presenter.setCustomizations(customName.getText().toString(), currPicIndex, "English");
    }

    @Override
    public void navigateToCourseSelector(String username) {  // username need not be pa
        Intent intent = new Intent(this, CourseSelectorActivity.class);
        intent.putExtra("UserName", username);
        startActivity(intent);
    }
}
