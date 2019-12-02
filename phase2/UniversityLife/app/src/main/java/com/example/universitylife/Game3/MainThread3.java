package com.example.universitylife.Game3;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread3 extends Thread {
    private SurfaceHolder surfaceHolder;
    private Game3ViewActivity3 gameView;
    private boolean running;
    private static Canvas canvas;

    public MainThread3(SurfaceHolder surfaceHolder, Game3ViewActivity3 gameView) {
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
