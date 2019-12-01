package com.example.universitylife.Student;

import com.example.universitylife.Leaderboard.ILeaderboard;

public class StudentFacade implements ILeaderboard.ILeaderboardStudent {
    private StudentAccount account;
    private StudentPreferences preferences;
    private StudentPerformance performance;
    private StudentBag bag;

    public StudentFacade(String username, String password) {
        account = new StudentAccount(username, password);
        preferences = new StudentPreferences();
        performance = new StudentPerformance();
        bag = new StudentBag();
    }
//
//    // This may not be necessary.
//    StudentFacade(StudentAccount account, StudentPreferences preferences,
//                  StudentPerformance performance, StudentBag bag){
//        this.account = account;
//        this.preferences = preferences;
//        this.performance = performance;
//        this.bag = bag;
//    }

    //ACCOUNT RELATED:
    public boolean passwordMatches(String password) {
        return account.passwordMatches(password);
    }

    public String getUsername() {
        return account.getUsername();
    }


    //CUSTOMIZATION RELATED:
    public String getName() {
        return preferences.getName();
    }

    public void setName(String name) {
        preferences.setName(name);
    }

    public int getAppearance() {
        return preferences.getAppearance();
    }

    public void setAppearance(int appearance) {
        preferences.setAppearance(appearance);
    }


    //GAME PERFORMANCE RELATED:
    public int getCredit(){
        return performance.getCredit();
    }

    @Override
    public double getGpa(){
        return performance.getGpa();
    }

    public double getGameTotal(int game) {
        return performance.calculateGameTotal(game);
    }

    public boolean canGraduate() {
        return performance.validateGraduation();
    }

    public int getHighestLevel(int game) {
        return performance.highestLevelOf(game);
    }


    /**
     * Register results for a non-bonus game level
     *
     * @param game  index of the game
     * @param level level the user has just completed
     * @param score score the user received
     */
    public void registerLevelResults(int game, int level, double score) {
        performance.registerLevelResults(game, level, score);
    }

    /**
     * Register results for a bonus game level
     *
     * @param game      index of the game
     * @param level     index of the level
     * @param giftcards number of giftcards obtained in the level
     */
    public void registerLevelResults(int game, int level, int giftcards) {
        bag.obtainGiftcards(giftcards);
        performance.registerLevelResults(game, level);
    }

    //BAG RELATED:
    public int getGiftcards(){
        return bag.getGiftcards();
    }

    public void obtainGiftcards(int n){
        bag.obtainGiftcards(n);
    }

    public void addItem(int itemIndex) {
        bag.addItem(itemIndex);
    }

    public void spendGiftcard() {
        bag.spendGiftcard();
    }

    public boolean hasGiftcards() {
        return bag.hasGiftcards();
    }

    public int getItem(int game) {
        return bag.getItem(game);
    }

    public void useItem(int game) {
        bag.useItem(game);
    }


}
