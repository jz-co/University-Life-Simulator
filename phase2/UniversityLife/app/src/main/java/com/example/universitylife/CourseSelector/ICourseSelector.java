package com.example.universitylife.CourseSelector;

public interface ICourseSelector {
    interface ICourseSelectorView{
        void displayWarning(String message);
        void navigateToCourse1(String username);
        void navigateToCourse2(String username);
        void navigateToCourse3(String username);
    }

}
