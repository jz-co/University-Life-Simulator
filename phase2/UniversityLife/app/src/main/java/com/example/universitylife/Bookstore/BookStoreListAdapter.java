package com.example.universitylife.Bookstore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.universitylife.R;

import java.util.List;

public class BookStoreListAdapter extends BaseAdapter {
    private BookStoreActivity context;
    private List<BonusItem> bonusItemsList;
    private BookstorePresenter presenter;

    BookStoreListAdapter(BookStoreActivity activity, List<BonusItem> bonusItemsList) {
        this.context = activity;
        this.bonusItemsList = bonusItemsList;
    }

    void setViewPresenter(BookstorePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public int getCount() {
        return bonusItemsList.size();
    }

    @Override
    public Object getItem(int id) {
        return bonusItemsList.get(id);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int id, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.bonus_list_row_layout, viewGroup, false);
        }

        // get current item to be displayed
        final BonusItem currBonus = (BonusItem) getItem(id);

        // get the TextView for displaying the bonus name and description
        TextView bonusTextView = (TextView) view.findViewById(R.id.bonus_text);

        ImageView bonusImageView = (ImageView) view.findViewById(R.id.bonus_image);

        Button buyButton = (Button) view.findViewById(R.id.buy_btn);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validateBonusPurchase(currBonus.getId());
            }
        });

        // Set the display on text views and image view
        String text = currBonus.getName() + ": " + currBonus.getDescription();
        bonusTextView.setText(text);

        bonusImageView.setImageResource(context.getPicIdentifier(currBonus.getId()));

        return view;
    }
}
