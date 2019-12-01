package com.example.universitylife.Leaderboard;

public interface ILeaderboard {
    interface ILeaderboardView {
//        void displayAvatar(int i, int picIndex);
//        void displayName(int i, String name);
//        void displayGpa(int i, double gpa);
//        void displayUserInfo(int picIndex, String name, double gpa);
    }

    interface ILeaderboardStudent {
        String getUsername();

        double getGpa();
    }
}
