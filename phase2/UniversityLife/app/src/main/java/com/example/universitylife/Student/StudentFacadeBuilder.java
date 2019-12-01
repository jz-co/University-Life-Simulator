package com.example.universitylife.Student;

public class StudentFacadeBuilder {
//// this class may not be necessary..
//
//    private StudentAccount account;
//    private StudentPreferences preferences;
//    private StudentPerformance performance = new StudentPerformance();
//    private StudentBag bag;
//
//    public void buildStudentAccount(String username, String password){
//        account = new StudentAccount(username, password);
//    }
//
//    public void buildStudentCustomization(String name, int appearance, String language){
//        preferences = new StudentPreferences(name, appearance, language);
//    }
//
//    /**
//     * Build the student's performance for the given game.
//     *
//     * @param game         index of the game
//     * @param highestLevel highest level reached by the student
//     * @param scores       current scores of the levels
//     */
//    public void buildStudentPerformance(int game, int highestLevel, double[] scores) {
//        performance.setGamePerformance(game, highestLevel, scores);
//    }
//
//
//    public void buildStudentBag(int giftcards, int[] items){
//        bag = new StudentBag(giftcards, items);
//    }
//
//    /**
//     * Return a student facade for a NEW user.
//     * Precondition: student account has been built.
//     * @return the student facade
//     */
//    public StudentFacade getNewFacade(){
//        StudentPerformance emptyPerformance = new StudentPerformance();
//        StudentPreferences defaultPreferences = new StudentPreferences();
//        StudentBag emptyBag = new StudentBag();
//        return new StudentFacade(account, defaultPreferences, emptyPerformance, emptyBag);
//    }
//
//    /**
//     * Return the student facade for an EXISTING user.
//     * Precondition: all parts have been built.
//     * @return the student facade
//     */
//    public StudentFacade getStudentFacade(){
//        return new StudentFacade(account,preferences, performance, bag);
//    }
}
