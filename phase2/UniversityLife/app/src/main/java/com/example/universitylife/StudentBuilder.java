package com.example.universitylife;

public class StudentBuilder {
    private Student student = new Student();

    public void buildStudentAccount(String username, String password){
        student.setUsername(username);
        student.setPassword(password);
    }

    public void buildStudentCustomization(String name, int appearance, String language){
        student.setName(name);
        student.setAppearance(appearance);
        student.setLanguage(language);
    }

    public void buildStudentGameHistory(int game, int level, double[] gameScores){
        student.setCurrentLevel(game, level);
        student.setScores(game, gameScores);
    }

    public void buildStudentPerformance(int credit){
        student.setCredit(StudentPerformanceCalculator.calculateCredit(student));
        student.setGpa(StudentPerformanceCalculator.calculateGpa(student));
    }

    public void buildStudentBookstoreItems(int giftcards, int[] items){
        student.setGiftcards(giftcards);
        student.setItems(items);
    }

    public Student getStudent(){
        return student;
    }
}
