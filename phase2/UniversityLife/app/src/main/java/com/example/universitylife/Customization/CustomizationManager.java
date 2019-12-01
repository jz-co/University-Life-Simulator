package com.example.universitylife.Customization;

import com.example.universitylife.Student.StudentFacade;

class CustomizationManager {

    /**
     * The current student.
     */
    private StudentFacade currentStudent;

    CustomizationManager(StudentFacade curr) {
        this.currentStudent = curr;
    }


    /**
     * Customize the current student's profile picture, preferred name, and language.
     *
     * @param picIndex The index of the student's profile picture
     * @param name     The student's preferred name
     */
    void customize(int picIndex, String name) {
        currentStudent.setAppearance(picIndex);
        currentStudent.setName(name);
    }

}
