package com.example.universitylife.Game2;


import com.example.universitylife.ILevel;

public interface ILevel2 extends ILevel {
    interface ILevel2View extends ILevelView{
        /** proceed to the level 3 of the game
         *
         */
        void goToLevel3();

        /** update the x and y coordinate of the imageview in the frontend
         *
         * @param id the id of the imageview
         */
        void updateViewPosById(int id);

        /** quit the GameLevel2Lvl1
         *
         */
        void quitGame();

        /** set the score of the player in the frontend
         *
         */
        void setScore();

        /** set the amount of seconds left in the frontend
         *
         */
        void setSecondRemaining();

        void displayMessage(String message);
    }
    interface ILevel2Presenter{
        /** go the level 3 of the game
         *
         */
        void goToNextLevel();
        /** update the x and y coordinate of the imageview in the frontend
         *
         * @param id the id of the imageview
         */
        void updateViewPosById(int id);
        /** quit the GameLevel2Lvl1
         *
         */
        void setScore();
        /** set the amount of seconds left in the frontend
         *
         */
    }
}
