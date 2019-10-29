package com.example.game.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.game.Contract.ICustomization;
import com.example.game.DataHandler.DataLoader;
import com.example.game.DataHandler.DataSaver;
import com.example.game.Presenter.CustomizationPresenter;
import com.example.game.R;

public class CustomizationActivity extends AppCompatActivity implements ICustomization.ICustomizationView {
    private CustomizationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customization);
        String username = (String) getIntent().getSerializableExtra("UserName");
        presenter = new CustomizationPresenter(this, new DataSaver(), new DataLoader(), username);
    }

    @Override
    public void nextPicture() {

    }

    @Override
    public void previousPicture() {

    }

    @Override
    public int getPictureIndex() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getLang() {
        return null;
    }

    @Override
    public void goToLevel1(String username) {
        //TODO: send gameManager to the next page with intent
    }
}
