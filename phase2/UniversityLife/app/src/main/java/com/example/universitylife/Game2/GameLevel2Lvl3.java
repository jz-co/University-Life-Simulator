package com.example.universitylife.Game2;

import com.example.universitylife.Student;

import java.util.ArrayList;

public class GameLevel2Lvl3 extends GameLevel2Lvl2 {

    public GameLevel2Lvl3(Student student, Basket basket, int FrameWidth, int FrameHeight, ArrayList<FallingObject> fallingObjects, ILevel2.ILevel2Presenter presenter) {
        super(student, basket, FrameWidth, FrameHeight, fallingObjects, presenter);
    }

    @Override
    public void play() {
        int element = (int) (Math.random() * fallingObjects.size());
        score += game(element);
        // setting the score in the frontend
        presenter.setScore();
    }

    private int game(int element) {
        int result;
        FallingObject item = fallingObjects.get(element);
        item.fall(frameHeight, framewidth);
        boolean eat = basket.eatBall(item, frameHeight, framewidth);
        if (eat) {
            if (item instanceof KillingObject){
                presenter.quitGameByKilling();
                return 0;
            }
            else {
                result = item.getScore_worth();
                if (this.getUmbrellaStatus()){
                    if (result < 0){
                        result = 0;
                    }
                }
            }
        }else{
            result = 0;
        }
        presenter.updateViewPosById(item.getFrontEndImageID());
        return result;
    }
}
