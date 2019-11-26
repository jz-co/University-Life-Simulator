package com.example.universitylife;

public class StudentBuilder {
    private Student student = new Student();

    public void buildStudentAccount(String username, String password){
        student.setUsername(username);
        student.setPassword(password);
    }

    public void buildStudentCustomization(String name, int appearance, String language, boolean leaderboard){
        student.setName(name);
        student.setAppearance(appearance);
        student.setLanguage(language);
        student.setOnLeaderboard(leaderboard);
    }

    public void buildStudentGameHistory(int game, int level, double[] sGpa){
        student.currentLevels[game-1] = level; // game = 1, 2, or 3
        student.sGpa[game-1] = sGpa;
    }

    public void buildStudentPerformance(int credit){
        student.setCredit(StudentManager.calculateCredit(student));
        student.setGpa(StudentManager.calculateCGpa(student));
    }

    public void buildStudentBookstoreItems(int giftcards, int[] items){
        student.setGiftcards(giftcards);
        student.setItems(items);
    }

    public Student getStudent(){
        return student;
    }
}
