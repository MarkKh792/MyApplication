package com.example.dbpoezdov;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

/*class Tableout extends SQLiteOpenHelper {

    private Context context;
    public SQLiteDatabase database;
    private static final String DATABASE_NAME = "OutDB.sqlite";
    private static final int DATABASE_VERSION = 1;
    private static String DB_PATH;

    static final String TABLEOUT = "Out_Ticket"; // Таблица 2 Out
    private static final String COLFname = "Out_Fname";
    private static final String COLLname = "Out_Lname";
    private static final String COLSname = "Out_Sname";
    private static final String COLNPass = "Out_NPass";
    private static final String COLTraiN = "Out_TraiN";
    private static final String COLNOutTicket = "Out_NOutTicket";
    private static final String COLWagClass = "Out_WagClass";
    private static final String COLNWag = "Out_NWag";
    private static final String COLSeat = "Out_Seat";
    private static final String COLPriceOut = "Out_Price";

    Tableout(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        DB_PATH = "/data/data/com.example.dbpoezdov/databases/";
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLEOUT +
                " (" + COLFname + " TEXT, " +
                COLLname + " TEXT, " +
                COLSname + " TEXT, " +
                COLNPass + " STRING, " +
                COLTraiN + " STRING PRIMARY KEY, " +
                COLNOutTicket + " STRING, " +
                COLWagClass + " TEXT, " +
                COLNWag + " INTEGER, " +
                COLSeat + " INTEGER, " +
                COLPriceOut + " INTEGER);";
        db.execSQL(query);

    }


    @Override
    public synchronized void close() {
        if (database != null) {
            database.close();
        }
        super.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLEOUT);
        onCreate(db);
    }

    void addOutinfo(String name1, String name2, String name3, String Passp, String Train, String Ticket, String Class, int NumWag, int OutSeat, int OutPrice){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLFname, name1);
        cv.put(COLLname, name2);
        cv.put(COLSname, name3);
        cv.put(COLNPass, Passp);
        cv.put(COLTraiN, Train);
        cv.put(COLNOutTicket, Ticket);
        cv.put(COLWagClass, Class);
        cv.put(COLNWag, NumWag);
        cv.put(COLSeat, OutSeat);
        cv.put(COLPriceOut, OutPrice);
        long result = db.insert(TABLEOUT,null, cv);
        if(result == -1){
            Toast.makeText(context, "Ошибка", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Добавлено", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllDataOUT(){
        String query = "SELECT * FROM " + TABLEOUT;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }


    void updateOutData(String name1, String name2, String name3, String Passp, String Train, String Ticket, String Class, String NumWag, String OutSeat, String OutPrice){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLFname, name1);
        cv.put(COLLname, name2);
        cv.put(COLSname, name3);
        cv.put(COLNPass, Passp);
        cv.put(COLTraiN, Train);
        cv.put(COLNOutTicket, Ticket);
        cv.put(COLWagClass, Class);
        cv.put(COLNWag, NumWag);
        cv.put(COLSeat, OutSeat);
        cv.put(COLPriceOut, OutPrice);

        long result = db.update(TABLEOUT, cv, "_id=?", new String[]{Ticket});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneOutRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLEOUT, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }
}*/
