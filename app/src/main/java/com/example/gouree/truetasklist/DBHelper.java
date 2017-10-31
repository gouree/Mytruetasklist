package com.example.gouree.truetasklist;

/**
 * Created by omsai on 28/10/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by omsai on 28/10/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//database class for the tasks added by user
class DBHelper  extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION = 4;

    // Database Name
    private static final String DATABASE_NAME = "crud.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //table creation

        String CREATE_TABLE_STUDENT = "CREATE TABLE " + Task.TABLE  + "("
                + Task.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Task.KEY_name + " TEXT, "
                + Task.KEY_desc+ " TEXT, "
                + Task.KEY_date+ " TEXT, "
                + Task.KEY_status + " INTEGER )";

        db.execSQL(CREATE_TABLE_STUDENT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Task.TABLE);

        // Create tables again
        onCreate(db);

    }

}
