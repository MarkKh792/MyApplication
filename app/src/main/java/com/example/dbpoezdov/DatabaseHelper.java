package com.example.dbpoezdov;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
            super(context, "Registration.db", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create table user(username text primary key, password text)");
        db.execSQL("insert into user values('operator', 'password'), "+" ('cashier', 'password')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists user");
    }

    //inserting in the database
    public boolean insert(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);

        long ins = db.insert("user",null,contentValues);
        if(ins==1)
            return false;
        else
            return true;
    }


    //checking the username and the password
    public Boolean userpassw(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username=? and password=?",new String[]{username,password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }


    }
}
