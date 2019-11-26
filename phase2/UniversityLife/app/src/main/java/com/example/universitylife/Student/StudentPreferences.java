package com.example.universitylife.Student;

class StudentPreferences {
    private String name;
    private int appearance = 1;
    private String language = "English";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppearance() {
        return appearance;
    }

    public void setAppearance(int appearance) {
        this.appearance = appearance;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }



    StudentPreferences(){

    }

    StudentPreferences(String name, int appearance, String language){
        this.name = name;
        this.appearance = appearance;
        this.language = language;
    }
}
