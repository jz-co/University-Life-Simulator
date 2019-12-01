package com.example.universitylife.Bookstore;

import com.example.universitylife.GameManager;
import com.example.universitylife.IData;

import java.util.List;

class BookstorePresenter {
    private IBookstore.IBookstoreView view;
    private Bookstore store;
    private GameManager gameManager;

    BookstorePresenter(IBookstore.IBookstoreView view, String username, IData dataHandler) {
        this.view = view;
        gameManager = new GameManager(username, dataHandler);
        store = new Bookstore(gameManager.getCurrentStudent());
    }

    void save() {
        gameManager.saveBeforeExit();
    }

    void validateBonusPurchase(int bonusIdNum) {
        if (store.studentHasGiftcards()) {
            store.buyItem(bonusIdNum);
        } else {
            view.displayWarning("You do not have enough giftcards for this purchase!");
        }
        view.updateGiftcardDisplay(store.getStudentGiftcards());
    }

    int getStudentGiftcards() {
        return store.getStudentGiftcards();
    }

    List<BonusItem> getBonusItemsList() {
        return store.getBonusItemList();
    }
}
