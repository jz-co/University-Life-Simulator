package com.example.universitylife.Bookstore;

interface IBookstore {
    interface IBookstoreView{
        int getNumberOfCalculators();
        int getNumberOfUmbrellas();
        int getNumberOfLv3Boosters();
        void displayWarning(String message);
    }
}
