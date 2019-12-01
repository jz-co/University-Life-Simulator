package com.example.universitylife.Leaderboard;

import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.DataHandler.RankingHandler;
import com.example.universitylife.GameManager;
import com.example.universitylife.IData;

import java.util.List;

class LeaderboardPresenter implements ILeaderboard.ILeaderboardPresenter {
    private GameManager gameManager;
    private List<ILeaderboard.ILeaderboardStudent> leaderBoardList;

    LeaderboardPresenter(String username, IData dataHandler) {
        this.gameManager = new GameManager(username, dataHandler);
        RankingHandler rankingHandler = new RankingHandler();
        this.leaderBoardList = rankingHandler.getTop5gpaStudent();


//        leaderboardList = leaderboard.getTop5();
//        displayRankingInfo();
//        view.displayUserInfo(leaderboard.getOnScreenAppearance(),
//                leaderboard.getOnScreenName(), leaderboard.getOnScreenGpa());
    }
//
//    private void displayRankingInfo(){
//        for (int i=0; i<5; i++){
//            view.displayAvatar(i, leaderboard.getAppearanceOf(i));
//            view.displayName(i, leaderboard.getNameOf(i));
//            view.displayGpa(i, leaderboard.getGpaOf(i));
//        }
//    }

//    int displayAvatar(int i) {
//        return leaderboard.getAppearanceOf(i);
//    }
//
//    String currentUserName() {
//        return leaderboard.getOnScreenName();
//    }
//
//    String leaderBoardName(int i) {
//        return leaderboard.getNameOf(i);
//    }
//
//    double currentGPA() {
//        return leaderboard.getOnScreenGpa();
//    }
//
//    int currentAvatar() {
//        return leaderboard.getOnScreenAppearance();
//    }
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
