package com.example.universitylife.Game3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.universitylife.GameManager;
import com.example.universitylife.R;
import com.example.universitylife.Result.Game1ResultActivity;
import com.example.universitylife.Student.StudentFacade;

/**
 * Referenced https://www.androidauthority.com/android-game-java-785331/
 * <p>
 * A view of the level 3 game.
 */

public class Lvl3GameViewActivity4 extends Activity implements SurfaceHolder.Callback {
    /**
     * A game surface view
     */
    SurfaceView surfaceView;

    /**
     * A game surface holder
     */
    SurfaceHolder surfaceHolder;

    /**
     * A game contents factory object that behaves as a manager.
     */
    public Game3ContentsFactory gameItemManager;

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

    /**
     * Context of the game
     */
    Context context;

    private MainThread thread;

    private Bitmap wheelImage = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
    private Bitmap arrowImage = BitmapFactory.decodeResource(getResources(), R.drawable.arrow);
    private Bitmap bowImage = BitmapFactory.decodeResource(getResources(), R.drawable.bow);
    private Bitmap background = BitmapFactory.decodeResource(getResources(), R.drawable.game3_background);

    /**
     * Creates the level 3 surface view.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.game_3_layout);

        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        this.manager = new GameManager(username);


        surfaceHolder.addCallback(this);
        thread = new MainThread(surfaceHolder, this);

        this.context = this.getApplicationContext();

        ImageButton exit = (ImageButton) findViewById(R.id.imageButton);
        exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        Button next = (Button) findViewById(R.id.button);
        next.setVisibility(View.INVISIBLE);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        gameItemManager = new Game3ContentsFactory(screenWidth, screenHeight);

        // add an arrow to the game
        Arrow arrow = new Arrow(4, screenWidth, screenHeight);
        gameItemManager.createGameItems(arrow);

        // add a bow to the game
        Bow bow = new Bow(4, screenWidth, screenHeight);
        gameItemManager.createGameItems(bow);

        // add a wheel to the game
        Wheel wheel = new Wheel(4, screenWidth, screenHeight);
        gameItemManager.createGameItems(wheel);


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
    public void draw(Canvas canvas) {
        surfaceView.draw(canvas);
        if (canvas != null) {
            drawBackground(canvas, 0, 0);
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
        paint.setColor(Color.WHITE);
        paint.setTextSize(70);
        paint.setFakeBoldText(true);
        canvas.drawText(score, screenWidth - 500, 100, paint);

        String life = "Lives: " + (gameItemManager.getLives());
        canvas.drawText(life, 100, 100, paint);

        GameContents arrow = gameItemManager.getGameItems().get(0);
        String windSpeed = "WindSpeed: " + (arrow.getWindSpeed());
        canvas.drawText(windSpeed, screenWidth - 500, 200, paint);
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
            Arrow moving_arrow = (Arrow) gameItemManager.getGameItems().get(0);
            GameContents item = gameItemManager.getGameItems().get(1);
            moving_arrow.setTouch(true);
            if (!(item instanceof Arrow)) {
                String wind;
                gameItemManager.getGameItems().add(1, new Arrow(4, screenWidth, screenHeight));
                if (Math.random() < 0.5) {
                    wind = "-";
                } else {
                    wind = "+";
                }
                gameItemManager.getGameItems().get(1).setWindSpeed(wind);
            }
        }


        if (gameItemManager.getLives() == 0) {
            StudentFacade s = manager.getCurrentStudent();
//            s.setGpa(4.0);
//            s.setHp(s.getHp() + gameItemManager.getScore());
            Intent intent = new Intent(context, Game1ResultActivity.class);
            intent.putExtra("Completion", "You have successfully completed level 3");
            intent.putExtra("Level", 3);
            intent.putExtra("Score", gameItemManager.getScore());
            intent.putExtra("Username", username);
            startActivity(intent);

        }


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
     * Draws a background on the canvas.
     *
     * @param canvas of game
     * @param x      coordinate
     * @param y      coordinate
     */
    public void drawBackground(Canvas canvas, int x, int y) {
        canvas.drawBitmap(this.background, x, y, null);
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
