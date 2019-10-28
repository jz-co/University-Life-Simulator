package com.example.game.Model;

import com.example.game.Model.Student;

abstract class GameLevel {
    private Student student;

    /** progress the game result, measure how good the player plays
     *
     */
    abstract void progressGameResults();

    abstract GameLevel makeCopy();
}
