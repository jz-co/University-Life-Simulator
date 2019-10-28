package com.example.game.Model;

import com.example.game.Model.Student;

public abstract class GameLevel {
    private Student student;

    /** progress the game result, measure how good the player plays
     *
     */
    public abstract void progressGameResults();

    public abstract GameLevel makeCopy();
}
