package com.example.game.View;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Referenced https://www.androidauthority.com/android-game-java-785331/
 */

public class Lvl3GameView extends SurfaceView implements SurfaceHolder.Callback {

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
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
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
    }

}
