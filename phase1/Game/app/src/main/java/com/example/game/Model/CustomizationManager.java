package com.example.game.Model;

public class CustomizationManager {

    /**
     * The current student.
     */
    private Student currentStudent;

    public CustomizationManager(Student curr) {
        this.currentStudent = curr;
    }


    /**
     * Customize the current student's profile picture, preferred name, and language.
     *
     * @param picIndex The index of the student's profile picture
     * @param name     The student's preferred name
     * @param lang     The student's preferred language
     */
    public void customize(int picIndex, String name, String lang) {
        currentStudent.setLanguage(lang);
        currentStudent.setAppearance(picIndex);
        currentStudent.setName(name);
    }

}
