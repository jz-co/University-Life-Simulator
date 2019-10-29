package com.example.game.Model;


import com.example.game.Contract.IData;
import com.example.game.Contract.IGameManager;


public class GameManager implements IGameManager {
    private StudentManager studentManager;
    private Student currentStudent;

    public GameManager(IData.IDataSaver dataSaver, IData.IDataLoader dataLoader){
        studentManager = new StudentManager(dataSaver, dataLoader);
    }

    public Student getCurrentStudent() {
        return currentStudent;
    }
    public String getCurrentUsername(){
        return currentStudent.getUsername();
    }

    /**
     * Saves the students' data before the app is closed.
     */
    public void saveBeforeExit(){
        studentManager.saveStudentData();
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

    StudentManager getStudentManager(){
        return studentManager;
    }

    public int getCurrentLevel(){
        return this.currentStudent.getCurrentLevel();
    }

}
