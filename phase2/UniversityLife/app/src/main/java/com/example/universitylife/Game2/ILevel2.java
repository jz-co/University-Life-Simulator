package com.example.universitylife.Game2;


import com.example.universitylife.ILevel;

public interface ILevel2 extends ILevel {
    interface ILevel2View extends ILevelView{
        /** proceed to the level 3 of the game
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
        void quitGame();

        /** set the score of the player in the frontend
         *
         */
        void setScore();

        /** set the amount of seconds left in the frontend
         *
         */
        void setSecondRemaining();

        /** display the message in the view
         *
         * @param message: String message
         */
        void displayMessage(String message);

        /** stop the count down timer in the game
         *
         */
        void stopTimer();

    }

    // interface for Presenter at Level 1
    interface ILevel2PresenterLvl1{
        /** go the next level of the game
         *
         */
        void goToNextLevel();
        /** update the x and y coordinate of the imageview in the frontend
         *
         * @param id the id of the imageview
         */
        void updateViewPosById(int id);
        /** set the score of the player in the view
         *
         */
        void setScore();

        /** quit the game level
         *
         */
        void quitGame();

        /** play the game
         *
         */
        void play();

        /** return the score of the player from the game level
         *
         * @return int score
         */
        int getScore();

        /** move the basket to the left
         *
         */
        void move_left();

        /** move the basket to the right
         *
         */
        void move_right();

        /** initialize the game
         *
         */
        void initializeGame();

        /** get the appearence of the red object
         *
         * @return int id of the imageview
         */
        int getRedAppearence();

        /** get the appearence of the blue object
         *
         * @return int id of the imageview
         */
        int getBlueAppearence();

        /** get the appearence of the yellow object
         * @return int id of the imageview
         */
        int getYellowAppearence();


        /** get the appearence of the basket
         * @return int id of the imageview
         */
        int getBasketAppearence();

        /** get the x coordinate of the red object
         *
         * @return int x coordinate of the red object
         */
        int getRedX();

        /** get the y coordinate of the red object
         *
         * @return int y coordinate of the red object
         */
        int getRedY();

        /** get the x coordinate of the blue object
         *
         * @return int x coordinate of the blue object
         */
        int getBlueX();

        /** get the y coordinate of the blue object
         *
         * @return int y coordinate of the blue object
         */
        int getBlueY();

        /** get the x coordinate of the yellow object
         *
         * @return int x coordinate of the yellow object
         */
        int getYellowX();

        /** get the y coordinate of the yellow object
         *
         * @return int y coordinate of the yellow object
         */
        int getYellowY();

        /** get the x coordinate of the basket object
         *
         * @return int x coordinate of the basket object
         */
        int getBasketX();

        /** get the y coordinate of the basket object
         *
         * @return int y coordinate of the basket object
         */
        int getBasketY();

    }

    interface ILevel2PresenterLvl2 extends ILevel2PresenterLvl1{

        /** get the appearence of the whatYouShouldDo object
         * @return int id of the imageview
         */
        int getWhatYouShouldDoAppearance();

        /** get the appearence of the whatYouShouldNotDo object
         * @return int id of the imageview
         */
        int getWhatYouShouldNotDoAppearance();

        /** get the x coordinate of the yellow object
         *
         * @return int x coordinate of the yellow object
         */
        int getWhatYouShouldDoX();

        /** get the y coordinate of the yellow object
         *
         * @return int y coordinate of the yellow object
         */
        int getWhatYouShouldDoY();

        /** get the x coordinate of the basket object
         *
         * @return int x coordinate of the basket object
         */
        int getWhatYouShouldNotDoX();

        /** get the y coordinate of the basket object
         *
         * @return int y coordinate of the basket object
         */
        int getWhatYouShouldNotDoY();

        /** set the umbrella open
         *
         */
        void setUmbrellaOpen();

        /** set the umbrella close
         *
         */
        void setUmbrellaClose();

        /** indicates whether we have bought an umbrella or not
         *
         * @return boolean boughtUmbrella
         */
        boolean isBoughtUmbrella();

    }

    interface ILevel2PresenterLvl3 extends ILevel2PresenterLvl2 {
        /** gets the appearance of the killing object
         * @return int appearance
         */
        int getKillingAppearance();

        /** get x coordinate of killing object
         * @return x coordinate of the killing object
         */
        int getKillingX();

        /** get y coordinate of killing object
         * @return y coordinate of the killing object
         */
        int getKillingY();

        /** quit game by killing
         *
         */
        void quitGameByKilling();
    }
}
