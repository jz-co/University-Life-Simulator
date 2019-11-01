package com.example.game.Model;

import com.example.game.Contract.IData;
import com.example.game.DataHandler.DataHandler;

import java.util.List;

class StudentManager {
    /**
     * The list of registered students.
     */
    private List<Student> students;

    /**
     * Data handler, used to save and load student data.
     */
    private IData dataHandler;


    StudentManager(IData dataHandler){
        this.dataHandler = dataHandler;
        students = dataHandler.listStudents();
    }

    /**
     * Saves data for all students.
     */
    void saveStudentData(String username) {
        Student student = dataHandler.getStudentByUserName(username);
        dataHandler.updateStudentData(student);
    }


    /**
     * Create a new student, add to the list, and return the new student.
     *
     * @param username The new student's username
     * @param password The new student's password
     * @return the new student
     */
    Student getNewStudent(String username, String password){
        Student newStudent = new Student(username,password);
        addStudent(newStudent);
        return newStudent;
    }


    /**
     * Return the Model.Student with the given username.
     * Precondition: the student has already registered.
     *
     * @param username The username we are looking for.
     * @return The student with the given username.
     */
    Student getStudentByUsername(String username) {
        for (Student s:students){
            if (s.getUsername().equals(username)){
                return s;
            }
        }
        return null; // future improvement: throw exception.
    }


    /**
     * Adds a student to the student list.
     *
     * @param s A student to add to the list.
     */
    public void addStudent(Student s){
        students.add(s);
        dataHandler.addStudentData(s);
    }


    /**
     * Check whether the username exists.
     *
     * @param username The username to check.
     */
    boolean studentExists(String username){
        for (Student s:students){
            if (s.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }


    /**
     * Check whether given username and password match.
     * Precondition: the student exists.
     */
    boolean passwordMatches(String username, String password){
        Student thisStudent = getStudentByUsername(username);
        return thisStudent.getPassword().equals(password);
    }


}
