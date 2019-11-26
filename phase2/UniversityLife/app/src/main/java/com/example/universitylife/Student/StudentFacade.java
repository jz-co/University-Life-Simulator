package com.example.universitylife.Student;

public class StudentFacade {
    private StudentAccount account;
    private StudentPreferences preferences;
    private StudentPerformance performance;
    private StudentBag bag;

    StudentFacade(StudentAccount account, StudentPreferences preferences,
                  StudentPerformance performance, StudentBag bag){
        this.account = account;
        this.preferences = preferences;
        this.performance = performance;
        this.bag = bag;
    }

    public boolean passwordMatches(String password) {
        return account.passwordMatches(password);
    }

    public String getUsername() {
        return account.getUsername();
    }

    public int getCredit(){
        return performance.getCredit();
    }

    public double getGpa(){
        return performance.getGpa();
    }

    public int getCurrentLevel(int game){
        return performance.getGameLevel(game);
    }

    public String getName(){
        return preferences.getName();
    }

    public void setName(String name){
        preferences.setName(name);
    }

    public int getAppearance(){
        return preferences.getAppearance();
    }

    public void setAppearance(int appearance){
        preferences.setAppearance(appearance);
    }

    public void setLanguage(String language){
        preferences.setLanguage(language);
    }

    public int getGiftcards(){
        return bag.getGiftcards();
    }

    public void obtainGiftcards(int n){
        bag.obtainGiftcards(n);
    }

    public void purchaseItem(int itemIndex){
        bag.purchaseItem(itemIndex);
    }


}
