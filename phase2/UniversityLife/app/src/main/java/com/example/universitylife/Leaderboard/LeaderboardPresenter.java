package com.example.universitylife.Leaderboard;

import com.example.universitylife.GameManager;
import com.example.universitylife.IData;
import com.example.universitylife.Student.StudentFacade;

class LeaderboardPresenter {
    private ILeaderboard.ILeaderboardView view;
    private Leaderboard leaderboard;
    private GameManager gameManager;
    private StudentFacade[] top5;

    LeaderboardPresenter(IData dataHandler, String username){
        gameManager = new GameManager(dataHandler, username);
        leaderboard = new Leaderboard(gameManager.getCurrentStudent(), dataHandler);
        top5 = leaderboard.getTop5();
        displayRankingInfo();
        view.displayUserInfo(leaderboard.getOnScreenAppearance(),
                leaderboard.getOnScreenName(), leaderboard.getOnScreenGpa());
    }

    private void displayRankingInfo(){
        for (int i=0; i<5; i++){
            view.displayAvatar(i, leaderboard.getAppearanceOf(i));
            view.displayName(i, leaderboard.getNameOf(i));
            view.displayGpa(i, leaderboard.getGpaOf(i));
        }
    }
}
