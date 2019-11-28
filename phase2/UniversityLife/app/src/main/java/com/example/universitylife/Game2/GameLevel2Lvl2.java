package com.example.universitylife.Game2;

import com.example.universitylife.Student.StudentFacade;

import java.util.ArrayList;

public class GameLevel2Lvl2 extends GameLevel2Lvl1{
    private ILevel2.ILevel2PresenterLvl2 presenter;
    // In this level the user can use the umbrella if they have bought one from the bookstore
    private boolean umbrellaOpen = false;

    public GameLevel2Lvl2(StudentFacade student, Basket basket, int FrameWidth, int FrameHeight, ArrayList<FallingObject> fallingObjects, ILevel2.ILevel2PresenterLvl2 presenter) {
       super(student, basket, FrameWidth, FrameHeight, fallingObjects, presenter);
       this.presenter = presenter;
    }

    /** set umbrella open, so that even if player eats an item with negative hp worth, score won't
     * be reduced
     */
    public void setUmbrellaOpen(){
      // student.getItems()[1] -=1;
        umbrellaOpen = true;
    }

    /** set the umbrella close, so that the blocking method can't be used anymore
     *
     */
    public void setUmbrellaClose(){
        umbrellaOpen = false;
    }

    /** get the umbrella status of the player
     *
     * @return boolean
     */
    public boolean getUmbrellaStatus(){
        return umbrellaOpen;
    }

    /** method of how the game works
     *
     * @param element the element of the fallingObjects list
     * @return the hp worth of the item eaten by the user
     */
    private int game(int element) {
        int result;
        FallingObject item = this.getFallingObjects().get(element);
        item.fall(this.getFrameHeight(), this.getFramewidth());
        boolean eat = this.getBasket().eatBall(item, this.getFrameHeight(), this.getFramewidth());
        if (eat) {
            result = item.getScore_worth();
            if (umbrellaOpen){
                if (result < 0){
                    result = 0;
                }
            }
        }else{
            result = 0;
        }
        presenter.updateViewPosById(item.getFrontEndImageID());
        return result;
    }


    public void levelClear(){
        this.getStudent().registerLevelResults(2, 2, this.getScore());
    }



}
