package com.example.game.View;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.game.Model.Level3.Arrow;
import com.example.game.Model.Level3.Bow;
import com.example.game.Model.Level3.GameContents;
import com.example.game.Model.Level3.Wheel;
import com.example.game.Presenter.Lvl3GameItemManager;
import com.example.game.R;

/**
 * Referenced https://www.androidauthority.com/android-game-java-785331/
 */

public class Lvl3GameView extends SurfaceView implements SurfaceHolder.Callback {

    /**
     * A game item manager object.
     */
    public Lvl3GameItemManager gameManager;

    /**
     * The width of the screen.
     */
    int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;

    /**
     * The height of the screen.
     */
    int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    private com.example.game.Model.Level3.MainThread thread;

    public Lvl3GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new com.example.game.Model.Level3.MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        gameManager = new Lvl3GameItemManager(screenWidth, screenHeight);

        // add a bow to the game
        Bow bow = new Bow(BitmapFactory.decodeResource(getResources(), R.drawable.bow), screenWidth, screenHeight);
        gameManager.createGameItems(bow);

        // add a wheel to the game
        Wheel wheel = new Wheel(BitmapFactory.decodeResource(getResources(), R.drawable.circle),
                screenWidth, screenHeight);
        gameManager.createGameItems(wheel);

        // add an arrow to the game
        Arrow arrow = new Arrow(BitmapFactory.decodeResource(getResources(), R.drawable.arrow),
                screenWidth, screenHeight);
        gameManager.createGameItems(arrow);

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
     * Updates the game
     */
    public void update() {
    }

    /**
     * Draws the canvas
     */
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            for (GameContents item : gameManager.getGameItems()) {
                item.draw(canvas);
            }
        }
    }

}
