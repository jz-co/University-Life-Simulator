package com.example.universitylife.Student;

class StudentPerformance {
    private int credit;
    private double gpa = 0;
    private int[] currentLevels = {1,1,1};
    private double [][] scores = new double [3][3];

    StudentPerformance(){

    }

    StudentPerformance(int[] currentLevels, double[][] scores){
        this.currentLevels = currentLevels;
        this.scores = scores;
        updateCredit();
        updateGpa();
    }

    private double calculateGameTotal(double[] scores){
        double sum  = 0;
        for (double s: scores){
            sum += s;
        }
        return sum;
    }


    private void updateGpa() {
        double tempGpa = 0;
        for (int game = 1; game <= 3; game++) {
            if (currentLevels[game - 1] >= 3) {
                tempGpa += calculateGameTotal(scores[game - 1]);
            }
        }
        if (credit != 0) {
            tempGpa = tempGpa / credit;
        }
        this.gpa = tempGpa;
    }

    private void updateCredit(){
        int credit = 0;
        for (int game = 1; game<=3; game++){
            if (currentLevels[game-1] >= 3){
                credit ++;
            }
        }
        this.credit = credit;
    }

    boolean validateGraduation() {
        return credit >= 3;
    }

    int getCredit() {
        return credit;
    }

    private void gameComplete(){
        credit++;
        updateGpa();
    }

    double getGpa() {
        return gpa;
    }

    public void unlockLevel(int game){
        currentLevels[game-1]++;
        if (currentLevels[game-1]>=3){
            gameComplete();
        }
    }

    public void setLevelScore(int game, int level, double score){
        scores[game-1][level-1] = score;
    }

    int getGameLevel(int game) {
        return currentLevels[game-1];
    }
}
