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

    void validatePurchase(){
        int calculators = view.getNumberOfCalculators();
        int umbrellas = view.getNumberOfUmbrellas();
        int lv3s = view.getNumberOfLv3Boosters();
        if (store.studentCanAfford(calculators + umbrellas + lv3s)){
            store.buyCalculator(calculators);
            store.buyUmbrella(umbrellas);
            store.buyLv3Booster(lv3s);
            gameManager.saveBeforeExit();
        } else{
            view.displayWarning("You do not have enough giftcards for the items you selected!");
        }
    }
}
