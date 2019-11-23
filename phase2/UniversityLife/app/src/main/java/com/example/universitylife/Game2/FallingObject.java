package com.example.universitylife.Game2;

abstract class FallingObject {
    private int x_coordinate;
    private int y_coordinate;
    private int score_worth;
    private String type;
    private int frontEndImage;
    private int appearence;
    private int speed;

    FallingObject(int x, int y, String type,  int score_worth, int speed){
        this.x_coordinate = x;
        this.y_coordinate = y;
        this.type = type;
        this.score_worth = score_worth;
        this.speed = speed;
    }

    /** get x coordinate of the falling object
     *
     * @return int x coordinate
     */
    public int getX_coordinate() {
        return x_coordinate;
    }

    /** set x coordinate of the falling object
     *
     * @param x_coordinate: the new x coordinate
     */
    public void setX_coordinate(int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    /** get y coordinate of the falling obejct
     *
     * @ y coordinate of the falling object
     */
    public int getY_coordinate() {
        return y_coordinate;
    }

    /** set the y coordinate of the falling object
     *
     * @param y_coordinate: the new y coordinate of this falling object
     */
    public void setY_coordinate(int y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    /**
     * get the type of the falling object
     * @return String the type of the falling object
     */
    String getType() {
        return type;
    }

    /** a falling method which each falling object should have, modify the y coordinate of this
     * falling object
     * @param FrameHeight the height of the framelayout of the screen
     * @param frameWidth the width of the framelayout of the screen
     */
    abstract void fall(int FrameHeight, int frameWidth);

    /** restore the height of the falling object after it has fallen out of the frame
     *
     * @param FrameWidth: the width of the framelayout
     */
    public void restoreHeight(int FrameWidth){
        y_coordinate = -200;
        x_coordinate = (int) Math.floor(Math.random() * (FrameWidth));
    }

    /** getting the id of the image the falling object
     *
     * @return the id of the image of the appearence of this falling object
     */
    public int getAppearence() {
        return appearence;
    }

    /**
     * set the appearence of the falling object
     * @param appearence the id of the new image of the appearence of this falling object
     */
    public void setAppearence(int appearence) {
        this.appearence = appearence;
    }

    /** get the id of the imageview of the falling object in the xml file
     *
     * @return the id of the imageview
     */
    int getFrontEndImageID() {
        return frontEndImage;
    }

    /** set the id of the imageview of the falling object
     *
     * @param id the id of the new imageview of the falling object in the xml file
     */
    void setFrontEndImageID(int id) {
        this.frontEndImage = id;
    }

    /** get the score_worth of the falling object
     *
     * @return int score_worth
     */
    int getScore_worth() {
        return score_worth;
    }

    /** get the falling speed of the falling objects
     *
     * @return falling speed
     */
    public int getSpeed() {
        return speed;
    }

    /** increase the speed of the falling object
     *
     */
    public void increaseSpeed() {
        this.speed += 15;
    }
}
