package com.example.universitylife.Student;

public class StudentData {
    private String username;
    private String password;
    private String name;
    private int appearance;
    private String game1;
    private String game2;
    private String game3;
    private String highestLevels;

    private int giftcards;
    private String items;
    private double gpa;

    public StudentData() {

    }

    public StudentData(StudentFacade student) {
        username = student.getUsername();
        password = student.getPassword();
        name = student.getName();
        appearance = student.getAppearance();
        highestLevels = intsToString(student.getHighestLevels());
        game1 = doublesToString(student.getGameScores(1));
        game2 = doublesToString(student.getGameScores(2));
        game3 = doublesToString(student.getGameScores(3));
        giftcards = student.getGiftcards();
        items = intsToString(student.getItems());
        gpa = student.getGpa();
    }

    public StudentFacade dataToStudent() {
        StudentFacadeBuilder builder = new StudentFacadeBuilder();
        builder.buildStudentAccount(username, password);
        builder.buildStudentCustomization(name, appearance);
        builder.buildStudentBag(giftcards, stringToInts(items));
        int[] levels = stringToInts(highestLevels);
        builder.buildStudentPerformance(1, levels[0], stringToDoubles(game1));
        builder.buildStudentPerformance(2, levels[1], stringToDoubles(game2));
        builder.buildStudentPerformance(3, levels[2], stringToDoubles(game3));
        return builder.getStudentFacade();
    }

    private int[] stringToInts(String string) {
        String[] strings = string.split(",");
        int[] ints = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        return ints;
    }

    private double[] stringToDoubles(String string) {
        String[] strings = string.split(",");
        double[] doubles = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            doubles[i] = Double.parseDouble(strings[i]);
        }
        return doubles;
    }

    private String doublesToString(double[] doubles) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < doubles.length; i++) {
            sb.append(Double.toString(doubles[i]));
            if (i < doubles.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private String intsToString(int[] ints) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < ints.length; i++) {
            sb.append(Integer.toString(ints[i]));
            if (i < ints.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppearance() {
        return appearance;
    }

    public void setAppearance(int appearance) {
        this.appearance = appearance;
    }

    public String getGame1() {
        return game1;
    }

    public void setGame1(String game1) {
        this.game1 = game1;
    }

    public String getGame2() {
        return game2;
    }

    public void setGame2(String game2) {
        this.game2 = game2;
    }

    public String getGame3() {
        return game3;
    }

    public void setGame3(String game3) {
        this.game3 = game3;
    }

    public String getHighestLevels() {
        return highestLevels;
    }

    public void setHighestLevels(String highestLevels) {
        this.highestLevels = highestLevels;
    }

    public int getGiftcards() {
        return giftcards;
    }

    public void setGiftcards(int giftcards) {
        this.giftcards = giftcards;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
