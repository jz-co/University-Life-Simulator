package com.example.game.Contract;

public interface ICustomization {
    interface ICustomizationView{
        void nextPicture();
        void previousPicture();
//        int getPictureIndex();
//        String getName();
//        String getLang();
        void navigateToCourseSelector(String username);
    }
    interface ICustomizationPresenter{
        void leftBtnClicked();
        void rightBtnClicked();
        void confirmBtnClicked();
    }
}
