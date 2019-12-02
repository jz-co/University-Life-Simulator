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

    /**
     * Returns a list of all students in the leaderboard
     */
    @Override
    public List<ILeaderboard.ILeaderboardStudent> getLeaderBoardList() {
        return leaderBoardList;
    }

    /**
     * Return name of current user.
     */
    String getCurrName() {
        return gameManager.getCurrentUsername();
    }

    /**
     * Return gpa of current user.
     */
    String getCurrGPA() {
        return String.valueOf(gameManager.getGpa());
    }

    /**
     * Return index of the avatar icon of current user.
     */
    int getPicIndex() {
        return gameManager.getCurrentStudent().getAppearance();
    }
}
