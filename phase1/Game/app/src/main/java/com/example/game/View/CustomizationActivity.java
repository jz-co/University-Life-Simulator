package com.example.game.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.game.Contract.ICustomization;
import com.example.game.Contract.IGameManager;
import com.example.game.Presenter.CustomizationPresenter;
import com.example.game.R;

public class CustomizationActivity extends AppCompatActivity implements ICustomization.ICustomizationView {
    private ICustomization.ICustomizationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customization);
        //TODO: get gameManager from intent
        //this.presenter = new CustomizationPresenter(this);
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
    public void goToLevel1(IGameManager gameManager) {
        //TODO: send gameManager to the next page with intent
    }
}
