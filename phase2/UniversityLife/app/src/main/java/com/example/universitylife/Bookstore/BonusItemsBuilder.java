package com.example.universitylife.Bookstore;

import java.util.ArrayList;
import java.util.List;

class BonusItemsBuilder {
    private ArrayList<BonusItem> masterList;

    void buildBonusItemsList() {

        masterList.add(buildFirstBonus());
        masterList.add(buildSecondBonus());
        masterList.add(buildThirdBonus());
    }

    List<BonusItem> getBonusItemsList() {
        return masterList;
    }

    private BonusItem buildFirstBonus() {
        int id = 1;
        String name = "Calculator";
        String description = "Gives hints for quicker answers in Math Mania!";
        return new BonusItem(id, name, description);

    }

    private BonusItem buildSecondBonus() {
        int id = 2;
        String name = "Umbrella";
        String description = "Block and protects against unwanted items for higher score boost";
        return new BonusItem(id, name, description);

    }

    private BonusItem buildThirdBonus() {
        int id = 3;
        String name = "Arrow Bonus";
        String description = "Insert Description"; // TODO
        return new BonusItem(id, name, description);

    }
}
