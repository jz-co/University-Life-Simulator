package com.example.universitylife.Game3;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Referenced https://www.androidauthority.com/android-game-java-785331/
 */

public class MainThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private Lvl3GameViewActivity1 gameView1;
    private Lvl3GameViewActivity2 gameView2;
    private Lvl3GameViewActivity3 gameView3;
    private Lvl3GameViewActivity4 gameView4;

    private int level;
    private boolean running;
    private static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, Lvl3GameViewActivity1 gameView) {
        super();
        level = 1;
        this.surfaceHolder = surfaceHolder;
        this.gameView1 = gameView;

    }

    public MainThread(SurfaceHolder surfaceHolder, Lvl3GameViewActivity2 gameView) {
        super();
        level = 2;
        this.surfaceHolder = surfaceHolder;
        this.gameView2 = gameView;
    }

    public MainThread(SurfaceHolder surfaceHolder, Lvl3GameViewActivity3 gameView) {
        super();
        level = 3;
        this.surfaceHolder = surfaceHolder;
        this.gameView3 = gameView;
    }

    public MainThread(SurfaceHolder surfaceHolder, Lvl3GameViewActivity4 gameView) {
        super();
        level = 4;
        this.surfaceHolder = surfaceHolder;
        this.gameView4 = gameView;
    }

    @Override
    public void run() {
        while (running) {
            canvas = null;
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    if (level == 1) {
                        this.gameView1.update();
                        this.gameView1.draw(canvas);
                    } else if (level == 2) {
                        this.gameView2.update();
                        this.gameView2.draw(canvas);
                    } else if (level == 3) {
                        this.gameView3.update();
                        this.gameView3.draw(canvas);
                    } else {
                        this.gameView4.update();
                        this.gameView4.draw(canvas);
                    }
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
