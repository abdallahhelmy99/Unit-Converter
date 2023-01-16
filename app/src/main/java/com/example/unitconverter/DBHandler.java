package com.example.unitconverter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.jar.Attributes;
public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "usersDB";
    // below int is our database version
    private static final int DB_VERSION = 1;
    // below variable is for our table name.
    private static final String TABLE_NAME = "users";
    // below variable is for our id column.
    private static final String ID_COL = "user_ID";
    // below variable is for our course name column
    private static final String NAME_COL = "username";
    private static final String PASS_COL = "password";
    private static final String EMAIL_COL= "email";
    // creating a constructor for our database handler.
    public DBHandler(Context context ) {
        super(context, DB_NAME,null, DB_VERSION);
    }
    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUsersTable = "CREATE TABLE " + TABLE_NAME + "("
                + ID_COL + " INTEGER PRIMARY KEY," + NAME_COL + " TEXT,"
                + PASS_COL + " TEXT," + EMAIL_COL + " TEXT " + " ) ;";
        db.execSQL(createUsersTable);
    }
    public void insertNewAccount(String email , String username , String password,int userID){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL,username);
        values.put(ID_COL,userID);
        values.put(EMAIL_COL,email);
        values.put(PASS_COL,password);
        db.insert(TABLE_NAME,null,values);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}