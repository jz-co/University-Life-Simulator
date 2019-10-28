package com.example.game.Contract;

public interface ICustomization {
    interface ICustomizationView{
        void nextPicture();
        void previousPicture();
        int getPictureIndex();
        String getName();
        String getLang();
        void goToLevel1();
    }
    interface ICustomizationPresenter{
        void leftBtnClicked();
        void rightBtnClicked();
        void confirmBtnClicked();
    }
}
