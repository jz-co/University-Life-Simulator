package com.example.game.Model;

import com.example.game.Model.Student;

public abstract class GameLevel {
    private Student student;

    public abstract void init();

    /**
     * progress the game result, measure how good the player plays
     */
    public abstract void progressGameResults();

    public abstract GameLevel makeCopy();

    public void setStudent(Student s){
        this.student = s;
    }

    public abstract void levelClear();
}
