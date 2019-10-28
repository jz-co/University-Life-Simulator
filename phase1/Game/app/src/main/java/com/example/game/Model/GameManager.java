package Model;

import Model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameManager {
    private StudentManager studentManager = new StudentManager();

    public Student getCurrentStudent() {
        return currentStudent;
    }

    private Student currentStudent;
    private List<Campus> campuses = new ArrayList<Campus>(Arrays.asList(new StGeorge()));

    /**
     * Resumes game for the current player.
     */
    void resumeGame(){
        currentStudent.resumeGame();
    }

    /**
     * Saves the students' data before the app is closed.
     */
    void saveBeforeExit(){
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
    public void setCurrentStudent(String username, String password){
        currentStudent = studentManager.getNewStudent(username, password);
    }

    /**
     * Sets the current student to the student with the given username.
     * Precondition: the student exists.
     *
     * @param username The student's username.
     */
    public void setCurrentStudent(String username){
        currentStudent = studentManager.getStudentByUsername(username);
    }

    public StudentManager getStudentManager(){
        return studentManager;
    }

    public int getCurrentLevel(){
        return this.currentStudent.getCurrentLevel();
    }

    public GameLevel getCurrentGameLevel(){
        int currCampus = currentStudent.getCampus();
        Campus campus = campuses.get(currCampus);
        int currLevel = currentStudent.getCurrentLevel();
        return campus.getLevel(currLevel);
    }
}
