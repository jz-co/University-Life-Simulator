package com.example.universitylife.Leaderboard;

import com.example.universitylife.IData;
import com.example.universitylife.Student.StudentFacade;

import java.lang.reflect.Array;


class Leaderboard {
    private StudentFacade[] top5 = new StudentFacade[5];
    private StudentFacade currentStudent;

    Leaderboard(StudentFacade s, IData dataHandler){
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

    StudentFacade[] getTop5() {return top5;}
}
