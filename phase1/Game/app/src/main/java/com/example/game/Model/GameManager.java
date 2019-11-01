package com.example.game.Model;


import com.example.game.Contract.IData;
import com.example.game.Contract.IGameManager;


public class GameManager implements IGameManager {
    /**
     * The student manager attached to this game manager.
     */
    private StudentManager studentManager;

    /**
     * The current player.
     */
    private Student currentStudent;

    /**
     * This constructor is used before the user logged in.
     * @param dataHandler the data handler created in View.
     */
    public GameManager(IData dataHandler){
        studentManager = new StudentManager(dataHandler);
    }

    /**
     * This constructor is used after the user logged in.
     * @param dataHandler the data handler
     * @param username the username of the current player.
     */
    public GameManager(IData dataHandler, String username){
        studentManager = new StudentManager(dataHandler);
        currentStudent = studentManager.getStudentByUsername(username);
    }

    /**
     * Return the current student
     * @return the current student
     */
    public Student getCurrentStudent() {
        return currentStudent;
    }

    /**
     * Return the username of the current player
     * @return the current player's username.
     */
    public String getCurrentUsername(){
        return currentStudent.getUsername();
    }

    /**
     * Saves the students' data before the app is closed.
     */
    public void saveBeforeExit(){
        studentManager.saveStudentData(currentStudent);
    }


    /**
     * Creates a student with the given username and password, and set this student
     * as the current student.
     * Precondition: the username has not been registered.
     *
     * @param username The student's username
     * @param password The student's password
     */
    void setCurrentStudent(String username, String password){
        currentStudent = studentManager.getNewStudent(username, password);
    }


    /**
     * Sets the current student to the student with the given username.
     * Precondition: the student exists.
     *
     * @param username The student's username.
     */
    void setCurrentStudent(String username){
        currentStudent = studentManager.getStudentByUsername(username);
    }

    /**
     * Return the student manager.
     * @return student manager
     */
    StudentManager getStudentManager(){
        return studentManager;
    }

    /**
     * Return the current level.
     * @return current level
     */
    public int getCurrentLevel(){
        return this.currentStudent.getCurrentLevel();
    }

}
