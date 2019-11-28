package com.example.universitylife;

import com.example.universitylife.DataHandler.FireBaseDataHandler;
import com.example.universitylife.Student.StudentFacade;
import com.example.universitylife.Student.StudentFacadeBuilder;

public class StudentManager {

    /**
     * Data handler, used to save and load student data.
     */
    private FireBaseDataHandler dataHandler;


    StudentManager() {
        this.dataHandler = new FireBaseDataHandler();
    }

    /**
     * Saves data for all students.
     */
    void saveStudentData(StudentFacade student) {
        dataHandler.updateStudentData(student);
    }


    /**
     * Create and return a new student facade.
     *
     * @param username The new student's username
     * @param password The new student's password
     * @return the new student
     */
    StudentFacade getNewStudent(String username, String password) {
        StudentFacade student = new StudentFacade(username, password);
        addStudent(student);
        return student;
    }


    /**
     * Return the Model.StudentOld with the given username.
     *
     * @param username The username we are looking for.
     * @return The student with the given username.
     */
    StudentFacade getStudentByUsername(String username) {
        return dataHandler.getStudentByUserName(username);
    }


    /**
     * Adds a student to the student list.
     *
     * @param student A student to add to the list.
     */
    private void addStudent(StudentFacade student) {
        dataHandler.addStudentData(student);
    }


    /**
     * Check whether the username exists.
     *
     * @param username The username to check.
     */
    public boolean studentExists(String username) {
        return !(getStudentByUsername(username) == null);
    }


    /**
     * Check whether given username and password match.
     * Precondition: the student exists.
     */
    public boolean passwordMatches(String username, String password) {
        StudentFacade student = getStudentByUsername(username);
        return student.passwordMatches(password);
    }


}
