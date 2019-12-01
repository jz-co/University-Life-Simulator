package com.example.universitylife.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.universitylife.CourseSelector.CourseSelectorActivity;
import com.example.universitylife.Customization.CustomizationActivity;
import com.example.universitylife.Login.ILogin;
import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.Profile.ProfileActivity;
import com.example.universitylife.R;
import com.example.universitylife.Login.LoginPresenter;


public class MainActivity extends AppCompatActivity implements ILogin.ILoginView {

    private LoginPresenter loginPresenter;
    private TextView messageView;
    private EditText usernameText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);


        // Create an instance of the LoginPresenter for this Activity
        loginPresenter = new LoginPresenter(this, new DataHandler(this));

        // Set references to the editTexts and TextViews in the layout
        usernameText = findViewById(R.id.usernameText);
        passwordText = findViewById(R.id.passwordText);

        messageView = findViewById(R.id.messageView);

    }


    /**
     *  Method is called when the user clicks the LoginButton.
     */
    public void onLoginClick (View view){
        // Get user's input for username and password
        // Pass information to LoginPresenter to validate whether it is a valid login
        loginPresenter.validateLogin(usernameText.getText().toString(), passwordText.getText().toString());
    }

    /**
     * Method is called when the user clicks the SignUpButton.
     */
    public void onSignUpClick (View view) {
        // Get user's input for username and password
        // Pass information to LoginPresenter to validate whether it is a valid sign up
        loginPresenter.validateSignUp(usernameText.getText().toString(), passwordText.getText().toString());
    }

    /**
     * Navigate to the customization page for a user with "username".
     */ @Override
    public void navigateToCustomization(String username) {
        Intent intent = new Intent(this, CustomizationActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    /**
     * Navigate to the course selection page for a user with "username".
     */ @Override
    public void navigateToProfile(String username) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    /**
     * Displays "message" to user.
     */ @Override
    public void displayWarning(String message) {
        messageView.setText(message);
    }

}
