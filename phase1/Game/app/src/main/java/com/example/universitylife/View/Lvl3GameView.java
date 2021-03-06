package com.example.universitylife.View;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.universitylife.Contract.ILevel3;
import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.Model.GameManager;
import com.example.universitylife.Model.Level3.Arrow;
import com.example.universitylife.Model.Level3.Bow;
import com.example.universitylife.Model.Level3.GameContents;
import com.example.universitylife.Model.Level3.Wheel;
import com.example.universitylife.Model.Level3.Lvl3GameItemManager;
import com.example.universitylife.Model.Student;
import com.example.universitylife.R;

/**
 * Referenced https://www.androidauthority.com/android-game-java-785331/
 *
 * A view of the level 3 game.
 */

public class Lvl3GameView extends SurfaceView implements SurfaceHolder.Callback, ILevel3.ILevel3GameView {

    /**
     * A game item manager object.
     */
    public Lvl3GameItemManager gameItemManager;

    /**
     * The width of the screen.
     */
    int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;

    /**
     * The height of the screen.
     */
    int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    /**
     * GameManager instance.
     */
    private GameManager manager;

    /**
     * Username of student playing the game
     */
    String username;

    private MainThread thread;

    private Bitmap wheelImage = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
    private Bitmap arrowImage = BitmapFactory.decodeResource(getResources(), R.drawable.arrow);
    private Bitmap bowImage = BitmapFactory.decodeResource(getResources(), R.drawable.bow);

    /**
     * Constructs the level 3 game view.
     *
     * @param context of game
     * @param username of student player
     */
    public Lvl3GameView(Context context, String username) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        this.username = username;
        this.manager = new GameManager(new DataHandler(context), username);
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        gameItemManager = new Lvl3GameItemManager(screenWidth, screenHeight);

        // add a bow to the game
        Bow bow = new Bow(this, screenWidth, screenHeight);
        gameItemManager.createGameItems(bow);

        // add a wheel to the game
        Wheel wheel = new Wheel(this, screenWidth, screenHeight);
        gameItemManager.createGameItems(wheel);

        // add an arrow to the game
        Arrow arrow = new Arrow(this, screenWidth, screenHeight);
        gameItemManager.createGameItems(arrow);

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    /**
     * Updates the game.
     */
    public void update() {
        gameItemManager.update();
    }

    /**
     * Draws the canvas.
     */
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            for (GameContents item : gameItemManager.getGameItems()) {
                if (item instanceof Arrow){
                    drawArrow(canvas, item.getX(), item.getY());
                } else if (item instanceof Bow){
                    drawBow(canvas, item.getX(), item.getY());
                } else if (item instanceof Wheel){
                    drawWheel(canvas, item.getX(), item.getY());
                }
            }
        }
        String score = "High Score: " + (gameItemManager.getScore());
        Paint paint = new Paint();
        paint.setColor(Color.MAGENTA);
        paint.setTextSize(70);
        paint.setFakeBoldText(true);
        canvas.drawText(score, screenWidth - 500, 100, paint);

        String life = "Lives: " + (gameItemManager.getLives());
        canvas.drawText(life, 100, 100, paint);

    }

    /**
     * An onTouchEvent that is called when player touches the screen.
     *
     * @param event or motion
     * @return boolean
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            Arrow moving_arrow = (Arrow) gameItemManager.getGameItems().get(2);
            moving_arrow.setTouch(true);
            if (gameItemManager.getGameItems().size() - 2 <= 1) {
                gameItemManager.getGameItems().add(new Arrow(this, screenWidth, screenHeight));
            }
        }

        if (gameItemManager.getLives() == 0) {
            Student s = manager.getCurrentStudent();
            s.setGpa(4.0);
            s.setHp(s.getHp() + gameItemManager.getScore());
            Intent intent = new Intent(super.getContext(), GameResultActivity.class);
            intent.putExtra("Completion", "You have successfully completed level 3");
            intent.putExtra("Level", 3);
            intent.putExtra("Score", gameItemManager.getScore());
            intent.putExtra("Username", username);
            super.getContext().startActivity(intent);

        }


        invalidate();
        return true;
    }

    /**
     * Draws an arrow object on the canvas.
     *
     * @param canvas of game
     * @param x coordinate
     * @param y coordinate
     */
    public void drawArrow(Canvas canvas, int x, int y){
        canvas.drawBitmap(arrowImage, x, y, null);
    }

    /**
     * Draws a bow object on the canvas.
     *
     * @param canvas of game
     * @param x coordinate
     * @param y coordinate
     */
    public void drawBow(Canvas canvas, int x, int y){
        canvas.drawBitmap(this.bowImage, x, y, null);
    }

    /**
     * Draws a wheel object on the canvas.
     *
     * @param canvas of game
     * @param x coordinate
     * @param y coordinate
     */
    public void drawWheel(Canvas canvas, int x, int y){
        canvas.drawBitmap(this.wheelImage, x, y, null);
    }

    /**
     * Getter for the width of wheel.
     *
     * @return wheelImage.getWidth()
     */
    public int getWheelWidth(){
        return wheelImage.getWidth();
    }

    /**
     * Getter for the height of wheel.
     *
     * @return wheelImage.getHeight()
     */
    public int getWheelHeight(){
        return wheelImage.getHeight();
    }
}
