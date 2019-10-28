package com.example.game.Model;

import com.example.game.Model.Level1.GameLevel1;
import com.example.game.Model.Level2.GameLevel2;
import com.example.game.Model.Level3.GameLevel3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StGeorge extends Campus {
    List<GameLevel> gameLevels = new ArrayList<GameLevel>(
            Arrays.asList(new GameLevel1(), new GameLevel2(), new GameLevel3())) ;
    String name = "St George";

//
//    /** add a new GameLevel to the current campus)
//     *
//     * @param newGame: the new game instance of GameLevel that you want to add to the campus
//     */
//    void add_gameLevel(GameLevel newGame){
//        StGeorge.gameLevels.add(newGame);
//    }
//
//    /** delete a GameLevel of the current campus
//     *
//     * @param removeIndex: the index of the game that you want to delete
//     */
//    void delete_gameLevel(int removeIndex) {
//        StGeorge.gameLevels.remove(removeIndex);
//    }



}
