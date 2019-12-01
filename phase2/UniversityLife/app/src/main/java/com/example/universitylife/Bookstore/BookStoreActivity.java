package com.example.universitylife.Bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.universitylife.BonusIcons;
import com.example.universitylife.Bookstore.BookStoreListAdapter;
import com.example.universitylife.Bookstore.BookstorePresenter;
import com.example.universitylife.Bookstore.IBookstore;
import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.R;

public class BookStoreActivity extends AppCompatActivity implements IBookstore.IBookstoreView {

    private ListView bonusListView;
    private BookstorePresenter presenter;
    private BonusIcons bonusIcons;

    private TextView messageView;
    private TextView moneyDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_store_main);

        moneyDisplay = findViewById(R.id.moneyView);
        messageView = findViewById(R.id.messageView);

        String username = (String) getIntent().getSerializableExtra("Username");
        presenter = new BookstorePresenter(this, username, new DataHandler(this));

        final String WELCOME_MESSAGE = "Welcome to the Bookstore!";
        moneyDisplay.setText(presenter.getStudentGiftcards());
        messageView.setText(WELCOME_MESSAGE);


        bonusIcons = new BonusIcons(this);
        displayBonusList();

    }


    private void displayBonusList() {
        bonusListView = (ListView) findViewById(R.id.bonus_item_list);
        BookStoreListAdapter adapter = new BookStoreListAdapter(this, presenter.getBonusItemsList());
        adapter.setViewPresenter(this.presenter);
        bonusListView.setAdapter(adapter);
    }

    public void onExitClick(View view) {
        presenter.save();
        finish();
    }

    @Override
    public void displayWarning(String message) {
        messageView.setText(message);
    }

    @Override
    public void updateGiftcardDisplay(int newAmount) {
        moneyDisplay.setText(newAmount);
    }

    BookstorePresenter getPresenter() {
        return presenter;
    }

    int getPicIdentifier(int id) {
        return bonusIcons.getIconIdentifierByIndex(id);
    }
}
