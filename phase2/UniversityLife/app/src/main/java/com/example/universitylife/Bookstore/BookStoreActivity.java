package com.example.universitylife.Bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.universitylife.Bookstore.IBookstore.*;
import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.R;

public class BookStoreActivity extends AppCompatActivity implements IBookstoreView {

    BookstorePresenter presenter;
    TextView moneyDisplay;
    TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_store);

        moneyDisplay = findViewById(R.id.moneyView);
        messageView = findViewById(R.id.messageView);

        String username = ""; //TODO: catch intent
        presenter = new BookstorePresenter(this, new DataHandler(this), username);
    }

    @Override
    public void displayWarning(String message) {
        messageView.setText(message);
    }

    @Override
    public void updateMoneyDisplay(int newAmount) {
        moneyDisplay.setText(newAmount);

    }

    public void onClickBuyBonus1(View view) {
        presenter.validateBonusPurchase(1);
    }

    public void onClickBuyBonus2(View view) {
        presenter.validateBonusPurchase(2);
    }

    public void onClickBuyBonus3(View view) {
        presenter.validateBonusPurchase(3);
    }

    public void onExitClick(View view) {
        presenter.save();
        finish();
    }
}
