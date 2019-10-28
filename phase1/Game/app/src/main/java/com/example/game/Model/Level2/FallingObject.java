package com.example.gamedraft;

abstract class FallingObject {
    private int x_coordinate;
    private int y_coordinate;
    private String type;
    private int hp_worth;

    FallingObject(int x, int y, String type, int hp_worth){
        this.x_coordinate = x;
        this.y_coordinate = y;
        this.hp_worth = hp_worth;
        this.type = type;
    }

    int getX_coordinate() {
        return x_coordinate;
    }

    void setX_coordinate(int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    int getY_coordinate() {
        return y_coordinate;
    }

    void setY_coordinate(int y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    int getHp_worth() {
        return hp_worth;
    }

    void setHp_worth(int hp_worth) {
        this.hp_worth = hp_worth;
    }

     String getType() {
        return type;
    }
}
