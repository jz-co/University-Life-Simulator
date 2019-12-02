package com.example.universitylife.DataHandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.universitylife.Student.StudentData;

import java.util.ArrayList;

/**
 * inspired by
 * Android SQLite - Very basic SQLite Contact App
 * https://www.youtube.com/watch?v=pXn9s-2YsIw
 */

public class DataHandler extends SQLiteOpenHelper implements IData, IRanking {

    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "studentData";
    static final String TABLE_STUDENTS = "students";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_APPEARANCE = "appearance";
    private static final String COLUMN_GAME1 = "game1";
    private static final String COLUMN_GAME2 = "game2";
    private static final String COLUMN_GAME3 = "game3";
    private static final String COLUMN_HIGHESTLEVELS = "highestLevels";
    private static final String COLUMN_GIFTCARDS = "giftcards";
    private static final String COLUMN_ITEMS = "items";
    static final String COLUMN_GPA = "gpa";

    public DataHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE	TABLE " + TABLE_STUDENTS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_USERNAME + " TEXT," + COLUMN_PASSWORD +
                " TEXT," + COLUMN_APPEARANCE + " TEXT," + COLUMN_GAME1 + " TEXT," + COLUMN_GAME2 + " TEXT," + COLUMN_GAME3 + " TEXT," + COLUMN_HIGHESTLEVELS + " TEXT," +
                COLUMN_GIFTCARDS + " TEXT," + COLUMN_ITEMS + " TEXT," + COLUMN_GPA + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        onCreate(db);
    }

    /**
     * Add a new student to the database.
     *
     * @param studentData the new student.
     */
    @Override
    public void addStudentData(StudentData studentData) {
        ContentValues values = new ContentValues();
        storeThisStudent(values, studentData);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_STUDENTS, null, values);
    }

    /**
     * Update the information of an existing student.
     *
     * @param student an existing student.
     */
    @Override
    public void updateStudentData(StudentData student) {
        ContentValues values = new ContentValues();
        storeThisStudent(values, student);
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_STUDENTS, values, COLUMN_USERNAME + "	= ?", new String[]{student.getUsername()});
    }

    /**
     * Return the existing student with the given username.
     *
     * @param userName the username to search for.
     * @return the student.
     */
    @Override
    public StudentData getStudentByUserName(String userName) {
        String query = "Select * FROM " + TABLE_STUDENTS + " WHERE " + COLUMN_USERNAME + " = " + "userName";
        SQLiteDatabase db = this.getWritableDatabase();
        StudentData student = null;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                if (userName.equals(cursor.getString(1))) {
                    student = getThisStudent(cursor);
                    break;
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return student;
    }

    /**
     * Helper method to build a student from data.
     */
    StudentData getThisStudent(Cursor cursor) {
        String username = cursor.getString(1);
        String password = cursor.getString(2);
        String appearance = cursor.getString(3);
        String game1 = cursor.getString(4);
        String game2 = cursor.getString(5);
        String game3 = cursor.getString(6);
        String highestLevel = cursor.getString(7);
        String giftcards = cursor.getString(8);
        String items = cursor.getString(9);

        StudentData data = new StudentData();
        data.setUsername(username);
        data.setPassword(password);
        data.setAppearance(Integer.parseInt(appearance));
        data.setGame1(game1);
        data.setGame2(game2);
        data.setGame3(game3);
        data.setHighestLevels(highestLevel);
        data.setGiftcards(Integer.parseInt(giftcards));
        data.setItems(items);

        return data;
    }

    /**
     * Helper method to input a student's information.
     */
    private void storeThisStudent(ContentValues values, StudentData student) {
        values.put(COLUMN_USERNAME, student.getUsername());
        values.put(COLUMN_PASSWORD, student.getPassword());
        values.put(COLUMN_APPEARANCE, Integer.toString(student.getAppearance()));
        values.put(COLUMN_GAME1, student.getGame1());
        values.put(COLUMN_GAME2, student.getGame2());
        values.put(COLUMN_GAME3, student.getGame3());
        values.put(COLUMN_HIGHESTLEVELS, student.getHighestLevels());
        values.put(COLUMN_GIFTCARDS, Integer.toString(student.getGiftcards()));
        values.put(COLUMN_ITEMS, student.getItems());
        values.put(COLUMN_GPA, student.getGpa());
    }

    public ArrayList<StudentData> getTopFive(){
        int count = 0;
        ArrayList<StudentData> students = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_STUDENTS + " ORDER BY " +
                COLUMN_GPA + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                StudentData student = getThisStudent(cursor);
                count += 1;
                students.add(student);
            } while (cursor.moveToNext());
        }
        return new ArrayList(students.subList(0, 4));
    }

}
