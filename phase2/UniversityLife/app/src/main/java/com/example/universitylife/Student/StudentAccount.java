package com.example.universitylife.Student;

class StudentAccount {
    private String username;
    private String password;

    StudentAccount(String username, String password){
        this.username = username;
        this.password = password;
    }

    boolean passwordMatches(String password){
        return password.equals(this.password);
    }

    public String getUsername() {
        return username;
    }
}
