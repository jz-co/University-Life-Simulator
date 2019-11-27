package com.example.universitylife.Login;

import com.example.universitylife.GameManager;
import com.example.universitylife.StudentManager;

class LogInManager {
    /**
     * The game manager.
     */
    private GameManager gameManager;

    /**
     * The student manager.
     */
    private StudentManager studentManager;

    LogInManager(GameManager gameManager) {
        this.gameManager = gameManager;
        this.studentManager = gameManager.getStudentManager();
    }

    /**
     * Returns whether a user with the given username exists.
     *
     * @param username The username to check.
     */
    private boolean userExists(String username){ return studentManager.studentExists(username);}


    /**
     * The user tries to log in with the given username and password. Return false if
     * the user does not exist or if the password is incorrect. Otherwise, return true.
     *
     * @param username The username entered by the user.
     * @param password The password entered by the user.
     */
    boolean logIn(String username, String password) {
        if (!userExists(username) || !studentManager.passwordMatches(username,password)) {
            return false;
        } else{
            gameManager.setCurrentStudent(username);
            return true;
        }
    }


    /**
     * The user tries to sign up with the given username and password. Return false if the user already exists.
     * Otherwise, return true.
     *
     * @param username The username entered by the user.
     * @param password The password entered by the user.
     */
    boolean signUp(String username, String password) {
        if (userExists(username)){
            return false;
        } else{
            gameManager.setCurrentStudent(username, password);
            return true;
        }
    }
}
