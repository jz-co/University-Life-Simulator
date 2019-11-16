package com.example.universitylife.Model.Level2;


public class Basket {
    private int appearence;
    private int imageId;
    private int x, y;

    public Basket(int imageId, int x, int y){
        this.imageId = imageId;
        this.x = x;
        this.y = y;
    }

    /** the basket moves right by unit units in the front end when this is called
     *
     * @param unit: basket move right by unit units
     * @param right_boundary: the boundary of the right end of the frameLayout
     */
    public void move_right(int unit, int right_boundary){
        if (x + unit <= right_boundary){
            x += unit;
        }
    }

    /** the basket moves left by unit units in the backend when this is called
     *
     * @param unit: basket move left by unit units
     * @param left_boundary: the boundary of the left end of the frameLayout
     */
    public void move_left(int unit, int left_boundary) {
        if (x - unit >= left_boundary) {
            x -= unit;
        }
    }


    boolean eatBall(FallingObject fallingObject, int frameHeight, int frameWidth){
        int center_x = fallingObject.getX_coordinate();
        int center_y = fallingObject.getY_coordinate();
        if ((x <= center_x) && (center_x <= x + 200) && (y <= center_y) && (center_y <= frameHeight)){
            fallingObject.restoreHeight(frameWidth);
            return true;
        }
        return false;
    }

    public int getAppearence() {
        return appearence;
    }

    /** set the id of the image for the appearence of the basket
     *
     * @param appearence: the id of the image
     */
    void setAppearence(int appearence) {
        this.appearence = appearence;
    }

    /** get the id of the imageview that displays the basket in the xml file
     *
     * @return id of the imageView
     */
    int getImageId() {
        return imageId;
    }

    /** get the x coordinate of the basket
     *
     * @return int x coordinate of basket
     */
    public int getX() {
        return x;
    }

    /** get the y coordinate of the basket
     *
     * @return int y coordinate of the basket
     */
    public int getY() {
        return y;
    }
}
