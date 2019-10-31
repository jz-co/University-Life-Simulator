package com.example.game.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.game.Contract.IGameManager;
import com.example.game.Contract.ILogin;
import com.example.game.DataHandler.DataLoader;
import com.example.game.DataHandler.DataSaver;
import com.example.game.R;
import com.example.game.Presenter.LoginPresenter;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements ILogin.ILoginView {

    private LoginPresenter loginPresenter;
    private TextView messageView;
    private EditText usernameText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an instance of the LoginPresenter for this Activity
        loginPresenter = new LoginPresenter(this, new DataSaver(), new DataLoader());

        usernameText = (EditText) findViewById(R.id.usernameText);
        passwordText = (EditText) findViewById(R.id.passwordText);

        messageView = (TextView) findViewById(R.id.messageView);

    }

    // Method for when the LoginButton is clicked

    public void onLoginClick (View view){
        // Get user's input for username and password
        // Pass information to LoginPresenter to validate whether it is a valid login
        loginPresenter.validateLogin(usernameText.getText().toString(), passwordText.getText().toString());

    }

    public void onSignUpClick (View view) {
        // Get user's input for username and password
        // Pass information to LoginPresenter to validate whether it is a valid sign up
        loginPresenter.validateSignUp(usernameText.getText().toString(), passwordText.getText().toString());
    }

    @Override
    public void navigateToCustomization(String username) {
        loginPresenter.prepareToLeavePage();
        Intent intent = new Intent(this, CustomizationActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    @Override
    public void navigateToCourseSelector(String username) {
        loginPresenter.prepareToLeavePage();
        Intent intent = new Intent(this, CourseSelectorActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    @Override
    public void displayWarning(String message) {
        messageView.setText(message);
    }

}
