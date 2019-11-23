package com.example.universitylife.Leaderboard;

import com.example.universitylife.IData;
import com.example.universitylife.Student;


class Leaderboard {
    private Student[] top5 = new Student[5];
    private Student currentStudent;

    Leaderboard(Student s, IData dataHandler){
        currentStudent = s;
        //TODO
        // this.top5 = dataHandler.getTop5();
    }

    String getNameOf(int i){
        return top5[i].getName();
    }

    int getAppearanceOf(int i){
        return top5[i].getAppearance();
    }

    double getGpaOf(int i){
        return top5[i].getGpa();
    }

    String getOnScreenName(){
        return currentStudent.getName();
    }

    int getOnScreenAppearance(){
        return currentStudent.getAppearance();
    }

    double getOnScreenGpa(){
        return currentStudent.getGpa();
    }
}
