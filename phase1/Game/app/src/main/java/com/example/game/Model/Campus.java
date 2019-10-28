package com.example.gamedraft;

import java.util.ArrayList;

abstract class Campus {
    private int currentLevel;
    private String name;

    /** Create a new Campus
     *
     * @param name: name of the campus
     */
    Campus(String name){
        this.name = name;
        this.currentLevel = 0;
    }

    /** Create a new Campus
     *
     * @param name: the name of the campus
     * @param level: the level of the game the student is in
     */
    Campus(String name, int level){
        this.name = name;
        this.currentLevel = level;
    }

    /** get the level of this campus that the player is at
     *
     * @return currentLevel
     */
    int getCurrentLevel() {
        return currentLevel;
    }

    /** get the Name of this campus
     *
     * @return name
     */
    String getName() {
        return name;
    }

    /** increase te current level by 1 */
    void incrementCurrentLevel(){
        currentLevel += 1;
    }

    /** set currentLevel of this campus to currentLevel
     *
     * @param currentLevel: the level of the student in this campus
     */
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    /** set name of this campus to name
     *
     * @param name: the name of the campus
     */
    public void setName(String name) {
        this.name = name;
    }

    /** play game at the current level
     *
     */
    abstract void playCurrentLevel();
}
