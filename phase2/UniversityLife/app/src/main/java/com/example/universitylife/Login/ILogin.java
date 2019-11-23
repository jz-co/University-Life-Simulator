package com.example.universitylife.Login;

public interface ILogin {
    interface ILoginView {
        /**
         * Display a warning message containing the given message.
         * @param message
         */
        public void displayWarning(String message);

        /**
         * Go to the customization activity, and pass the IGameManager to the next page. (via intent)
         */
        public void navigateToCustomization(String username);


        public void navigateToCourseSelector(String username);
//        /**
//         * Go to the Level 1 page, and pass the IGameManager to the next page. (via intent)
//         * @param gameManager
//         */
//        void goToLevel1(IGameManager gameManager);
//
//        /**
//         * Go to the Level 2 page, pass the IGameManager to the next page. (via intent)
//         * @param gameManager
//         */
//        void goToLevel2(IGameManager gameManager);
//
//        /**
//         * Go to the Level 3 Page, pass the IGameManager to the next page. (via intent)
//         * @param gameManager
//         */
//        void goToNextLevel(IGameManager gameManager);
    }

    interface ILoginPresenter {
        public void validateSignUp(String username, String password);
        public void validateLogin(String username, String password);
    }
}
