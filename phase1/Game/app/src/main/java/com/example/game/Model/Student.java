package com.example.game.Model;

public class Student{
    private int credit;
    private int appearance = 1;
    private int currentLevel = 1;
    private double gpa = 4.0;
    private double  hp;
    private String username, password, name;
    private String language = "English";

    /** Create a new Student. This student did not exist before and other attributes need to be
     * set separately.
     *
     * @param username: the username of the student
     * @param password: the password of the student
     */
    public Student (String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * Create a new student. This student already exists and is being created from existing data.
     * @param username: the student's username
     * @param password: the student's password
     * @param level: the student's current level
     * @param credits: the number of credits the student has earned
     * @param gpa: the student's gpa
     * @param hp: the student's health point
     * @param name: the student's preferred name
     * @param appearance: the student's profile picture index
     * @param language: the student's preferred language
     */
    public Student(String username, String password, int level, int credits, double gpa,
            double hp, String name, int appearance, String language){
        this.username = username;
        this.password = password;
        this.currentLevel = level;
        this.credit = credits;
        this.gpa = gpa;
        this.hp = hp;
        this.name = name;
        this.appearance = appearance;
        this.language = language;
    }

    /** get the credits of this student**/
    public int getCredit(){
        return credit;
    }


    /** get the gpa of this student**/
    public double getGpa() {
        return gpa;
    }

    /** get the hp of this student**/
    public double getHp(){
        return hp;
    }

    /** set the credit of this student
     * @param credit: set the credit number of this student to be credit
     * **/
    public void setCredit(int credit) {
        this.credit = credit;
    }

    /** set the credit of this student
     * @param gpa: set the gpa of this student to be gpa
     * **/
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /** set the credit of this student
     * @param hp: set the hp of this student to be hp
     * **/
    public void setHp(double hp) {
        this.hp = hp;
    }

    /** get the current currentLevel of this student **/
    public int getCurrentLevel(){
        return currentLevel;
    }

    /** increase the credit of this student
     *
     * @param amount_to_add: the amount to be added to the credit of the student
     */
    public void incrementCredit(int amount_to_add){
        this.credit += amount_to_add;
    }

    /** increase the hp of this student
     *
     * @param amount_to_add: the amount to be added to the hp of the student
     */
    public void incrementHp(int amount_to_add){
        this.hp += amount_to_add;
    }

    /** increase the gpa of the student
     *
     * @param amount_to_add: the amount to be added to the gpa of the student
     */
    public void incrementGpa(int amount_to_add){
        this.gpa += amount_to_add;
        if (gpa>4){
            gpa = 4;
        }
    }

    /** decrease the credit of this student
     *
     * @param amount_to_delete: the amount to be deleted to the credit of the student
     */
    public void decrementCredit(int amount_to_delete){
        this.credit -= amount_to_delete;
    }

    /** decrease the gpa of the student
     *
     * @param amount_to_delete: the amount to be deleted to the gpa of the student
     */
    public void decrementGpa(int amount_to_delete){
        this.gpa -= amount_to_delete;
        if (gpa<0){
            gpa = 0;
        }
    }

    /** decrease the of the hp of the student
     *
     * @param amount_to_delete: the amoun to be deleted to the hp of the student
     */
    public void decrementHp(int amount_to_delete){
        this.hp -= amount_to_delete;
    }

    /** get the username in the login page for this student**/
    public String getUsername(){
        return this.username;
    }

    /** get the password in the login page for this student**/
    public String getPassword(){
        return this.password;
    }

    /** set the username of this student **/
    public void setUsername(String username) {
        this.username = username;
    }

    /** set the password of this student **/
    public void setPassword(String password) {
        this.password = password;
    }

    /** get customized name of this student **/
    public String getName(){
        return name;
    }

    /** get customized language of this student **/
    public String getLanguage(){
        return language;
    }

    /** get the id of the customized appearance of this student **/
    public int getAppearance(){
        return appearance;
    }

    /** increment the level of the student
     *
     */
    public void incrementLevel(){
        currentLevel += 1;
    }


    /** set appearance of this student
     *
     * @param appearance: the id of the customized appearance
     */
    public void setAppearance(int appearance) {
        this.appearance = appearance;
    }

    /** set the currentLevel of this student
     *
     * @param currentLevel: the current currentLevel that this student is playing
     */
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }


    /** set the name of the student
     *
     * @param name: the preferred name of the student
     */
    public void setName(String name) {
        this.name = name;
    }

    /** set the language of the student
     *
     * @param language: the preferred language of the student
     */
    public void setLanguage(String language) {
        this.language = language;
    }



}
