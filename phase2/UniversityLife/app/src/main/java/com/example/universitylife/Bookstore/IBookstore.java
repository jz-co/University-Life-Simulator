package com.example.universitylife.Bookstore;

interface IBookstore {
    interface IBookstoreView{

        /**
         * Displays message on screen.
         * @param message: message to be displayed
         */
        void displayWarning(String message);

        /**
         * Displays new gift card amount on screen.
         * @param newAmount: new amount to be displayed.
         */
        void updateGiftCardDisplay(int newAmount);
    }

}
