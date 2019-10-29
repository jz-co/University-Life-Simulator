package com.example.game.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.game.Contract.IGameManager;
import com.example.game.Contract.IMain;
import com.example.game.Presenter.MainPresenter;
import com.example.game.R;

public class MainActivity extends AppCompatActivity implements IMain.IMainView {
    private IMain.IMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.presenter = new MainPresenter(this);

        // Create an instance of the Presenter for this Activity
    }

    // Method for when the Login Button is clicked

    void onLoginClick (View view){
        // 1. Feed the username and password entries to Presenter
        // 2. Get presenter to return whether or not the username exists
        //    a. if the username exists, check if password is correct
        //          i) If password is correct;
        //              move to course selector activity
        //          ii) If password is incorrect;
        //              display error message
        //    b. if username doesn't exist, display error, telling user to sign up

    }

    void onSignUpClick (View view) {
        // 1. Check to see if username and password entries are empty (or space)
        //      a. If empty, then display error message
        //      b. Otherwise, feed username and password entries in to Presenter to have them create new user
        //      If username and password entries are empty,
        // 2. Move to customization page
    }

    @Override
    public void displayWarning(String message) {

    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void goToCustomization(IGameManager gameManager) {
        //TODO: send gameManager to the next page with intent
    }

    @Override
    public void goToLevel1(IGameManager gameManager) {
        //TODO: send gameManager to the next page with intent
    }

    @Override
    public void goToLevel2(IGameManager gameManager) {
        //TODO: send gameManager to the next page with intent
    }

    @Override
    public void goToLevel3(IGameManager gameManager) {
        //TODO: send gameManager to the next page with intent
    }
}
