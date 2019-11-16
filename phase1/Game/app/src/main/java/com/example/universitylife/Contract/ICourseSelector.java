package com.example.universitylife.Contract;

public interface ICourseSelector {
    interface ICourseSelectorView{
        void displayWarning(String message);
        void goToLevel1(String username);
        void goToLevel2(String username);
        void goToLevel3(String username);
    }

}
