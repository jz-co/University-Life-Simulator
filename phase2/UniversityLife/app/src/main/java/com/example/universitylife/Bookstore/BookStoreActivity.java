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
        moneyDisplay.setText(String.valueOf(presenter.getStudentGiftcards()));
        messageView.setText(WELCOME_MESSAGE);


        bonusIcons = new BonusIcons(this);
        displayBonusList();

    }


    /**
     * Displays the list of bonuses that cna be purchased.
     */
    private void displayBonusList() {
        bonusListView = (ListView) findViewById(R.id.bonus_item_list);
        BookStoreListAdapter adapter = new BookStoreListAdapter(this, presenter.getBonusItemsList());
        adapter.setViewPresenter(this.presenter);
        bonusListView.setAdapter(adapter);
    }

    /**
     * Executes when exit button is clicked.
     */
    public void onExitClick(View view) {
        presenter.save();
        finish();
    }

    /**
     * Displays message <message> on screen.
     * @param message: message to be displayed
     */
    @Override
    public void displayWarning(String message) {
        messageView.setText(message);
    }

    /**
     * Displays new giftcard amount on screen.
     * @param newAmount: new amount to be displayed.
     */
    @Override
    public void updateGiftCardDisplay(int newAmount) {
        moneyDisplay.setText(String.valueOf(newAmount));
    }

    /**
     * Returns this activity's presenter.
     */
    BookstorePresenter getPresenter() {
        return presenter;
    }

    /**
     * Returns the unique pic Identifier for an image resource corresponding to the bonus's id.
     * @param id id number corresponding to the image who's pic identifier is wanted
     * @return pic identifier number
     */
    int getPicIdentifier(int id) {
        return bonusIcons.getIconIdentifierByIndex(id);
    }
}
