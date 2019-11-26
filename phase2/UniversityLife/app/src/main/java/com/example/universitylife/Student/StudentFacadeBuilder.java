package com.example.universitylife.Student;

public class StudentFacadeBuilder {

    private StudentAccount account;
    private StudentPreferences preferences;
    private StudentPerformance performance;
    private StudentBag bag;

    public void buildStudentAccount(String username, String password){
        account = new StudentAccount(username, password);
    }

    public void buildStudentCustomization(String name, int appearance, String language){
        preferences = new StudentPreferences(name, appearance, language);
    }

    public void buildStudentPerformance(int[] currentLevels, double[][] scores){
        performance = new StudentPerformance(currentLevels, scores);
    }

    public void buildStudentBag(int giftcards, int[] items){
        bag = new StudentBag(giftcards, items);
    }

    public StudentFacade getNewFacade(){
        StudentPerformance emptyPerformance = new StudentPerformance();
        StudentPreferences defaultPreferences = new StudentPreferences();
        StudentBag emptyBag = new StudentBag();
        return new StudentFacade(account,preferences, performance, bag);
    }

    public StudentFacade getStudentFacade(){
        return new StudentFacade(account,preferences, performance, bag);
    }
}
