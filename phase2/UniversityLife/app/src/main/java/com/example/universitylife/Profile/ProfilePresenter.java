package com.example.universitylife.Profile;

import com.example.universitylife.IData;
import com.example.universitylife.Profile.IProfile.*;
import com.example.universitylife.GameManager;
import com.example.universitylife.Student.StudentFacade;

public class ProfilePresenter implements IProfilePresenter {

    private IProfileView view;
    private GameManager gameManager;
    private StudentFacade student;

    /**
     * Constructor for ProfilePresenter.
     */
    ProfilePresenter(IProfileView view, IData dataHandler, String username) {

        this.view = view;
        gameManager = new GameManager(dataHandler, username);
        student = gameManager.getCurrentStudent();
    }

    @Override
    public String getName() {
        return student.getName();
    }

    @Override
    public String getGPA() {
        return String.valueOf(student.getGpa());
    }

    @Override
    public String getCredits() {
        return String.valueOf(student.getCredit());
    }

    @Override
    public String getMoney() {
        return String.valueOf(student.getGiftcards());
    }

    @Override
    public void validateGraduation() {
        if (student.canGraduate()) {
            // navigate to graduationActivity
        } else {
            view.displayErrorMessage();
        }
    }

    int getPicIndex() {
        return student.getAppearance();
    }

}
