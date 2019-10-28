package com.example.gamedraft;

abstract class GameLevel {
    private Student student;

    /** play the game
     *
     */
    abstract void play();

    /** progress the game result, measure how good the player plays
     *
     */
    abstract void progressGameResults();

    abstract GameLevel makeCopy();
}
