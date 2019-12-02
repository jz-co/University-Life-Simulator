package com.example.universitylife.Leaderboard;

import com.example.universitylife.DataHandler.IRanking;
import com.example.universitylife.GameManager;
import com.example.universitylife.Student.StudentData;

import java.util.ArrayList;
import java.util.List;

class LeaderboardPresenter implements ILeaderboard.ILeaderboardPresenter {
    private GameManager gameManager;
    private List<ILeaderboard.ILeaderboardStudent> leaderBoardList = new ArrayList<>();

    LeaderboardPresenter(String username, IRanking rankingHandler) {
        this.gameManager = new GameManager(username, rankingHandler);
        List<StudentData> temp = rankingHandler.getTopFive();
        for (StudentData d : temp) {
            leaderBoardList.add(d.dataToStudent());
        }
    }

    @Override
    public List<ILeaderboard.ILeaderboardStudent> getLeaderBoardList() {
        return leaderBoardList;
    }


    String getCurrName() {
        return gameManager.getCurrentUsername();
    }

    String getCurrGPA() {
        return String.valueOf(gameManager.getGpa());
    }

    int getPicIndex() {
        return gameManager.getCurrentStudent().getAppearance();
    }
}
