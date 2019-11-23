package com.example.universitylife.Bookstore;

public class BookstoreActivity implements IBookstore.IBookstoreView {
    @Override
    public int getNumberOfCalculators() {
        return 0;
    }

    @Override
    public int getNumberOfUmbrellas() {
        return 0;
    }

    @Override
    public int getNumberOfLv3Boosters() {
        return 0;
    }

    @Override
    public void displayWarning(String message) {

    }
}
