package com.example.game.Model.Level3;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.example.game.View.Lvl3GameView;

/**
 * Referenced https://www.androidauthority.com/android-game-java-785331/
 */

public class MainThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private Lvl3GameView gameView;
    private boolean running;
    private static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, Lvl3GameView gameView) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;

    }

    @Override
    public void run() {
        while (running) {
            canvas = null;
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gameView.update();
                    this.gameView.draw(canvas);
                }
            } catch (Exception e) {
            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void setRunning(boolean isRunning) {
        running = isRunning;
    }
}
