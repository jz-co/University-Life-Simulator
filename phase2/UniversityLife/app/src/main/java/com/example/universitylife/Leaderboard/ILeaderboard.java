package com.example.universitylife.Leaderboard;

import java.util.List;

public interface ILeaderboard {

    interface ILeaderboardPresenter {
        List<ILeaderboard.ILeaderboardStudent> getLeaderBoardList();

    }

    interface ILeaderboardStudent {
        String getUsername();

        double getGpa();
    }
}
