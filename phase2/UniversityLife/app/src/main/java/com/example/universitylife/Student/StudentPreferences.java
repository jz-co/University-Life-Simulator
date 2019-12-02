package com.example.universitylife.Student;

class StudentPreferences {
    private String name;
    private int appearance = 1;

    StudentPreferences() {

    }

    StudentPreferences(String name, int appearance) {
        this.name = name;
        this.appearance = appearance;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getAppearance() {
        return appearance;
    }

    void setAppearance(int appearance) {
        this.appearance = appearance;
    }


}
