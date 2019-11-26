package com.example.universitylife;

class StudentPerformanceCalculator {
    private static double calculateGameTotal(double[] scores){
        double sum  = 0;
        for (double s: scores){
            sum += s;
        }
        return sum;
    }

    /**
     * Calculate the student's cumulative GPA. Only the sGPA of completed courses will be considered.
     * The GPA will be the average of the sGPA of all completed courses.
     * @param s the student
     * @return the student's current GPA
     */
    static double calculateGpa(Student s){
        double tempGpa = 0;
        for (int game = 1; game<= 3; game++){
            if (s.getCurrentLevel(game)>= 3){
                tempGpa += calculateGameTotal(s.getScores(game));
            }
        }
        if (s.getCredit() != 0) {
            tempGpa = tempGpa / s.getCredit();
        }
        return tempGpa;
    }

    static int calculateCredit(Student s){
        int credit = 0;
        for (int game = 1; game<=3; game++){
            if (s.getCurrentLevel(game) >= 3){
                credit ++;
            }
        }
        return credit;
    }

    static boolean validateGraduation(Student s){
        return s.getCredit() >= 3;
    }
}
