package com.example.universitylife.Bookstore;

import com.example.universitylife.GameManager;
import com.example.universitylife.IData;

class BookstorePresenter {
    private IBookstore.IBookstoreView view;
    private Bookstore store;
    private GameManager gameManager;

    BookstorePresenter(IBookstore.IBookstoreView view, IData dataHandler, String username){
        this.view = view;
        gameManager = new GameManager(dataHandler, username);
        store = new Bookstore(gameManager.getCurrentStudent());
    }

    void save(){
        gameManager.saveBeforeExit();
    }

    void validateBonusPurchase(int bonusIdNum) {
        if (store.studentCanAfford(1)){
            store.buyItem(bonusIdNum);
        } else{
            view.displayWarning("You do not have enough giftcards for this purchase!");
        }
        view.updateMoneyDisplay(store.getStudentGiftcards());
    }
}
