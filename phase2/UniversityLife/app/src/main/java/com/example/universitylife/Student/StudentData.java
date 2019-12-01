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

}
