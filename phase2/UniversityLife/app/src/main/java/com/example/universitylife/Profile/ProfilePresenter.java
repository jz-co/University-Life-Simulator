package com.example.universitylife.Profile;

import com.example.universitylife.DataHandler.DataHandler;
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
    ProfilePresenter(IProfileView view, String username, IData dataHandler) {

        this.view = view;
        gameManager = new GameManager(username, dataHandler);
        student = gameManager.getCurrentStudent();
    }

    @Override
    public String getName() {
        return gameManager.getCurrentUsername();
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
            view.navigateToEnd();
        } else {
            view.displayErrorMessage("Sorry, you have not earned enough credits!");
        }
    }

    int getPicIndex() {
        return student.getAppearance();
    }

}
