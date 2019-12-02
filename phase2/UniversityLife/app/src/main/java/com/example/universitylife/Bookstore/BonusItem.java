package com.example.universitylife.Bookstore;

/**
 * Bonus item that allows users to earn extra points or complete levels faster, and which can be
 * displayed in the Bookstore for purchase.
 */
class BonusItem {
    private int id;
    private String name;
    private String description;

    BonusItem(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * Returns the unique id of this bonus.
     */
    int getId() {
        return id;
    }
    /**
     * Returns name of this bonus.
     */
    String getName() {
        return name;
    }

    /**
     * Returns a description of what this bonus does.
     */
    String getDescription() {
        return description;
    }

}
