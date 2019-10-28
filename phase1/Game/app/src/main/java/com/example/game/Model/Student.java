package com.example.gamedraft;

class Student {
    private int credit, appearence, level;
    private double gpa, hp;
    private Campus campus;
    private String username, password, campusName, name, language;

    /** create a new Student
     *
     * @param campus: the campus of the student
     * @param name: the customized name of the student
     * @param Language: the customized language of the student
     * @param Appearence: the customized appearence of the student
     * @param username: the username of the student
     * @param password: the password of the student
     */
    Student(Campus campus, String name, String Language, int Appearence,
            String username, String password){
        this.credit = 0;
        this.gpa = 0;
        this.hp = 0;
        this.campus = campus;
        this.username = username;
        this.password = password;
        this.name = name;
        this.language = Language;
        this.appearence  = Appearence;
        this.campusName = campus.getName();
        this.level = campus.getCurrentLevel();
    }

    Student(String username, String password, String level, String credits, String gpa,
            String hp, Campus campus, String name, String appearence, String language){
        this.username = username;
        this.password = password;
        this.level = Integer.parseInt(level);
        this.credit = Integer.parseInt(credits);
        this.gpa = Double.parseDouble(gpa);
        this.hp = Double.parseDouble(hp);
        this.campus = campus;
        this.campusName = campus.getName();
        this.name = name;
        this.appearence = Integer.parseInt(appearence);
        this.language = language;
    }

    /** get the credits of this student**/
    int getCredit(){
        return credit;
    }

    /** get the gpa of this student**/
    double getGpa() {
        return gpa;
    }

    /** get the hp of this student**/
    double getHp(){
        return hp;
    }

    /** set the credit of this student
     * @param credit: set the credit number of this student to be credit
     * **/
    void setCredit(int credit) {
        this.credit = credit;
    }

    /** set the credit of this student
     * @param gpa: set the gpa of this student to be gpa
     * **/
    void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /** set the credit of this student
     * @param hp: set the hp of this student to be hp
     * **/
    void setHp(double hp) {
        this.hp = hp;
    }

    /** get the current level of this student **/
    int getLevel(){
        return level;
    }

    /** increase the credit of this student
     *
     * @param amount_to_add: the amount to be added to the credit of the student
     */
    void incrementCredit(int amount_to_add){
        this.credit += amount_to_add;
    }

    /** increase the hp of this student
     *
     * @param amount_to_add: the amount to be added to the hp of the student
     */
    void incrementHp(int amount_to_add){
        this.hp += amount_to_add;
    }

    /** increase the gpa of the student
     *
     * @param amount_to_add: the amount to be added to the gpa of the student
     */
    void incrementGpa(int amount_to_add){
        this.gpa += amount_to_add;
    }

    /** decrease the credit of this student
     *
     * @param amount_to_delete: the amount to be deleted to the credit of the student
     */
    void decrementCredit(int amount_to_delete){
        this.credit -= amount_to_delete;
    }

    /** decrease the gpa of the student
     *
     * @param amount_to_delete: the amount to be deleted to the gpa of the student
     */
    void decrementGpa(int amount_to_delete){
        this.gpa -= amount_to_delete;
    }

    /** decrease the of the hp of the student
     *
     * @param amount_to_delete: the amoun to be deleted to the hp of the student
     */
    void decrementHp(int amount_to_delete){
        this.hp -= amount_to_delete;
    }

    /** get the username in the login page for this student**/
    String getUsername(){
        return this.username;
    }

    /** get the password in the login page for this student**/
    String getPassword(){
        return this.password;
    }

    /** set the username of this student **/
    void setUsername(String username) {
        this.username = username;
    }

    /** set the password of this student **/
    void setPassword(String password) {
        this.password = password;
    }

    /** get customized name of this student **/
    String getName(){
        return name;
    }

    /** get customized language of this student **/
    String getLanguage(){
        return language;
    }

    /** get the id of the customized appearence of this student **/
    int getAppearence(){
        return appearence;
    }

    /** get campus name **/
    String getCampusName(){
        return campusName;
    }

    /** resume the game that you were previously playing **/
    void resumeGame(){
        // the campus hold the current level
        this.campus.playCurrentLevel();
    }


    /** set appearence of this student
     *
     * @param appearence: the id of the customized appearence
     */
    void setAppearence(int appearence) {
        this.appearence = appearence;
    }

    /** set the level of this student
     *
     * @param level: the current level that this student is playing
     */
    void setLevel(int level) {
        this.level = level;
    }


    /** set the name of the student
     *
     * @param name: the preferred name of the student
     */
    void setName(String name) {
        this.name = name;
    }

    /** set the language of the student
     *
     * @param language: the preferred language of the student
     */
    void setLanguage(String language) {
        this.language = language;
    }


    /** get the campus of this student
     *
     * @return campus
     */
    public Campus getCampus() {
        return campus;
    }


    /** set the campus of this student
     *
     * @param campus: a new campus
     */
    void setCampus(Campus campus) {
        this.campus = campus;
    }

}
