package com.example.universitylife.Login;

interface ILogin {
    interface ILoginView {
        /**
         * Display a warning message containing the given message.
         * @param message
         */
        void displayWarning(String message);

        /**
         * Go to the customization activity, and pass the IGameManager to the next page. (via intent)
         */
        void navigateToCustomization(String username);

        void navigateToCourseSelector(String username);

    }

    interface ILoginPresenter {
        void validateSignUp(String username, String password);

        void validateLogin(String username, String password);
    }
}
