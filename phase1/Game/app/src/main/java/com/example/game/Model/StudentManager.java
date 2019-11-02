package com.example.game.Model;

import com.example.game.Contract.IData;

class StudentManager {

    /**
     * Data handler, used to save and load student data.
     */
    private IData dataHandler;


    StudentManager(IData dataHandler) {
        this.dataHandler = dataHandler;
    }

    /**
     * Saves data for all students.
     */
    void saveStudentData(Student student) {
        dataHandler.updateStudentData(student);
    }


    /**
     * Create a new student, add to the list, and return the new student.
     *
     * @param username The new student's username
     * @param password The new student's password
     * @return the new student
     */
    Student getNewStudent(String username, String password) {
        Student newStudent = new Student(username, password);
        addStudent(newStudent);
        return newStudent;
    }


    /**
     * Return the Model.Student with the given username.
     *
     * @param username The username we are looking for.
     * @return The student with the given username.
     */
    Student getStudentByUsername(String username) {
        return dataHandler.getStudentByUserName(username);
    }


    /**
     * Adds a student to the student list.
     *
     * @param s A student to add to the list.
     */
    private void addStudent(Student s) {
        dataHandler.addStudentData(s);
    }


    /**
     * Check whether the username exists.
     *
     * @param username The username to check.
     */
    boolean studentExists(String username) {
        return !(getStudentByUsername(username) == null);
    }


    /**
     * Check whether given username and password match.
     * Precondition: the student exists.
     */
    boolean passwordMatches(String username, String password) {
        Student thisStudent = getStudentByUsername(username);
        return thisStudent.getPassword().equals(password);
    }


}
