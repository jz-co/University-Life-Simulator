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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
