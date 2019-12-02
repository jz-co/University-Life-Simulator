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

import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.GameManager;
import com.example.universitylife.LevelSelector.Game3LevelSelectorActivity;
import com.example.universitylife.R;
import com.example.universitylife.Result.Game1ResultActivity;
import com.example.universitylife.Result.Game3ResultActivity;
import com.example.universitylife.Student.StudentFacade;

/**
 * Referenced https://www.androidauthority.com/android-game-java-785331/
 * <p>
 * A view of the level 3 game.
 */

public class Game3ViewActivity1 extends Activity implements SurfaceHolder.Callback {

    /**
     * A game surface view
     */
    private SurfaceView surfaceView;

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
    int screenWidth;
//    int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;

    /**
     * The height of the screen.
     */
    int screenHeight;
//    int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

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

    private MainThread1 thread;

    private Bitmap wheelImage;
    private Bitmap arrowImage;
    private Bitmap bowImage;
    private Bitmap background;

    private boolean isDoubleArrow = false;

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


        this.context = this.getApplicationContext();

        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        this.username = (String) getIntent().getSerializableExtra("Username");
        this.manager = new GameManager(username, new DataHandler(this.context));


        surfaceHolder.addCallback(this);
        thread = new MainThread1(surfaceHolder, this);

        screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

        wheelImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.circle);
        arrowImage =  BitmapFactory.decodeResource(context.getResources(), R.drawable.arrow);
        bowImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.bow);
        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.game3_background);

    }

    public void nextLevel(View view) {
        Intent intent;
        intent = new Intent(this, Game3ViewActivity2.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        StudentFacade student = manager.getCurrentStudent();
        isDoubleArrow = student.getItem(3) > 0;

        gameItemManager = new Game3ContentsFactory(screenWidth, screenHeight);
        gameItemManager.setDoubleArrow(isDoubleArrow);

        // add an arrow to the game
        Arrow arrow = new Arrow(1, screenWidth, screenHeight);
        setArrowImage();
        gameItemManager.createGameItems(arrow);


        // add a bow to the game
        Bow bow = new Bow(1, screenWidth, screenHeight);
        gameItemManager.createGameItems(bow);

        // add a wheel to the game
        Wheel wheel = new Wheel(1, screenWidth, screenHeight);
        gameItemManager.createGameItems(wheel);

        student.useItem(3);
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
        paint.setTextSize(75);
        paint.setFakeBoldText(true);
        canvas.drawText(score, 100, 100, paint);

        String rules = "Hit the target to earn score, else missing the target results in reduction of lives. Here, target changes position";
        canvas.drawText(rules, screenWidth - 600, 250, paint);

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
                gameItemManager.getGameItems().add(1, new Arrow(1, screenWidth, screenHeight));
            }
        }

        if (gameItemManager.getScore() >= 3) {
            StudentFacade s = manager.getCurrentStudent();
            s.registerLevelResults(3, 1, gameItemManager.getScore());

            Button next = (Button) findViewById(R.id.button);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nextLevel(v);
                }
            });
        }


        return true;
    }

    public void setArrowImage() {
        if (isDoubleArrow) {
            arrowImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.double_arrow);
        } else {
            arrowImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.arrow);
        }
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
