package com.example.universitylife;

public class StudentManager {

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
    public boolean studentExists(String username) {
        return !(getStudentByUsername(username) == null);
    }


    /**
     * Check whether given username and password match.
     * Precondition: the student exists.
     */
    public boolean passwordMatches(String username, String password) {
        Student thisStudent = getStudentByUsername(username);
        return thisStudent.getPassword().equals(password);
    }

    /**
     * Calculate the student's cumulative GPA. Only the sGPA of completed courses will be considered.
     * The cGPA will be the average of the sGPA of all completed courses.
     * @param s the student
     * @return the student's current cGPA
     */
    static double calculateCGpa(Student s){
        double tempGpa = 0;
        for (int i = 0; i<= 2; i++){
            if (s.currentLevels[i]>= 3){
                for (double grade : s.sGpa[i]){
                    tempGpa += grade;
                }
            }
        }
        if (s.getCredit() != 0) {
            tempGpa = tempGpa / s.getCredit();
        }
        return tempGpa;
    }

    static int calculateCredit(Student s){
        int credit = 0;
        for (int i = 0; i<=2; i++){
            if (s.currentLevels[i] >= 3){
                credit ++;
            }
        }
        return credit;
    }

    static boolean validateGraduation(Student s){
        return s.getCredit() >= 3;
    }


}
