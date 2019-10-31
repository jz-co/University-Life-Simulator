package com.example.game.View;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.game.DataHandler.DataHandler;
import com.example.game.DataHandler.DataLoader;
import com.example.game.DataHandler.DataSaver;
import com.example.game.Model.GameManager;
import com.example.game.Model.Level3.Arrow;
import com.example.game.Model.Level3.Bow;
import com.example.game.Model.Level3.GameContents;
import com.example.game.Model.Level3.Wheel;
import com.example.game.Model.Level3.Lvl3GameItemManager;
import com.example.game.Model.Student;
import com.example.game.Presenter.MainThread;
import com.example.game.R;

/**
 * Referenced https://www.androidauthority.com/android-game-java-785331/
 */

public class Lvl3GameView extends SurfaceView implements SurfaceHolder.Callback {

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
     * GameManager instance
     */
    private GameManager manager;

    /**
     * Username of student playing the game
     */
    String username;

    private com.example.game.Presenter.MainThread thread;

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
        Bow bow = new Bow(BitmapFactory.decodeResource(getResources(), R.drawable.bow), screenWidth, screenHeight);
        gameItemManager.createGameItems(bow);

        // add a wheel to the game
        Wheel wheel = new Wheel(BitmapFactory.decodeResource(getResources(), R.drawable.circle),
                screenWidth, screenHeight);
        gameItemManager.createGameItems(wheel);

        // add an arrow to the game
        Arrow arrow = new Arrow(BitmapFactory.decodeResource(getResources(), R.drawable.arrow),
                screenWidth, screenHeight);
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
     * Updates the game
     */
    public void update() {
        gameItemManager.update();
    }

    /**
     * Draws the canvas
     */
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            for (GameContents item : gameItemManager.getGameItems()) {
                item.draw(canvas);
            }
        }
        String score = "High Score: " + (gameItemManager.getHighScore());
        Paint paint = new Paint();
        paint.setColor(Color.MAGENTA);
        paint.setTextSize(60);
        canvas.drawText(score, screenWidth - 500, 100, paint);

        String life = "Lives: " + (gameItemManager.getLives());
        canvas.drawText(life, 100, 100, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            Arrow moving_arrow = (Arrow) gameItemManager.getGameItems().get(2);
            moving_arrow.setTouch(true);
            if (gameItemManager.getGameItems().size() - 2 <= 1) {
                gameItemManager.getGameItems().add(new Arrow(BitmapFactory.decodeResource(getResources(), R.drawable.arrow),
                        screenWidth, screenHeight));
            }
        }

        if (gameItemManager.getLives() == 0) {
            Student s = manager.getCurrentStudent();
            s.setGpa(4.0);
            s.setHp(s.getHp() + gameItemManager.getHighScore());
            Intent intent = new Intent(super.getContext(), GameResultActivity.class);
            super.getContext().startActivity(intent);
            intent.putExtra("Completion", "You have successfully completed level 3");
            intent.putExtra("Level", 3);
            intent.putExtra("Score", gameItemManager.getHighScore());
            intent.putExtra("Username", username);

        }


        invalidate();
        return true;
    }
}
