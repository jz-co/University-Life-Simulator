package com.example.game.Model;

import java.util.List;

public abstract class Campus {
    List<GameLevel> gameLevels;
    String name;

    /** get the Name of this campus
     *
     * @return name
     */
    String getName() {
        return name;
    }

    /** play game at the current level
     *
     */
    public GameLevel getLevel(int level){
        return this.gameLevels.get(level);
    }
}
