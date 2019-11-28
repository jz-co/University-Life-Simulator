package com.example.universitylife;


import com.example.universitylife.Student.StudentFacade;

public class GameManager {
    /**
     * The student manager attached to this game manager.
     */
    private StudentManager studentManager;

    /**
     * The current player.
     */
    private StudentFacade currentStudent;

    /**
     * This constructor is used before the user logged in.
     *
     */
    public GameManager() {
        studentManager = new StudentManager();
    }

    /**
     * This constructor is used after the user logged in.
     *
     * @param username    the username of the current player.
     */
    public GameManager(String username) {
        studentManager = new StudentManager();
        currentStudent = studentManager.getStudentByUsername(username);
    }

    public int getHighestLevel(int game) {
        return currentStudent.getHighestLevel(game);
    }

    public StudentFacade getCurrentStudent() {
        return currentStudent;
    }

    public String getCurrentUsername() {
        return currentStudent.getUsername();
    }

    public void saveBeforeExit() {
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
    public void setCurrentStudent(String username, String password) {
        currentStudent = studentManager.getNewStudent(username, password);
    }


    /**
     * Sets the current student to the student with the given username.
     * Precondition: the student exists.
     *
     * @param username The student's username.
     */
    public void setCurrentStudent(String username) {
        currentStudent = studentManager.getStudentByUsername(username);
    }

    public StudentManager getStudentManager() {
        return studentManager;
    }

    public double getGpa() {
        return currentStudent.getGpa();
    }
}
