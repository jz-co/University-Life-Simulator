package com.example.game.Model;

import java.util.ArrayList;

class StGeorge extends Campus {
    private static ArrayList<GameLevel> gameLevels;
    private static String name = "St George";

    StGeorge() {
        super(StGeorge.name, 0);
        StGeorge.gameLevels = new ArrayList<GameLevel>();
    }

    StGeorge(int level) {
        super(StGeorge.name, level);
    }

    /** add a new GameLevel to the current campus)
     *
     * @param newGame: the new game instance of GameLevel that you want to add to the campus
     */
    void add_gameLevel(GameLevel newGame){
        StGeorge.gameLevels.add(newGame);
    }

    /** delete a GameLevel of the current campus
     *
     * @param removeIndex: the index of the game that you want to delete
     */
    void delete_gameLevel(int removeIndex) {
        StGeorge.gameLevels.remove(removeIndex);
    }

    /** play game at the current level
     *
     */
    void playCurrentLevel(){
        GameLevel currentGame = gameLevels.get(this.getCurrentLevel()).makeCopy();
    }

}
