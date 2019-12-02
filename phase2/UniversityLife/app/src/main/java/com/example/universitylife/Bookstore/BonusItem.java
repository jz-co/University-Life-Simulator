package com.example.universitylife.Bookstore;

class BonusItem {
    private int id;
    private String name;
    private String description;

    BonusItem(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }

}
