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

class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    public SQLiteDatabase database;
    private static final String DATABASE_NAME = "RailwayDB.sqlite";
    private static final int DATABASE_VERSION = 1;
    private static String DB_PATH;

    static final String TABLEREG = "REG_Ticket"; //Добавить региональный билет
    private static final String COL_RegID = "_id";
    private static final String COLTicket_RegID = "REG_TicketID";
    private static final String COLWagon_classREG = "REG_WagonClass";
    private static final String COLNtrain = "TrainNumber";
    private static final String COLPreveligy = "Preveligy";
    private static final String COLPriceREG = "Price";

    static final String TABLEOUT = "Out_Ticket"; // Таблица 2 Out
    private static final String COL_OutID = "_id";
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

    static final String TABLECHED = "Chedule"; //таблица с расписанием
    private static final String COL_ChID = "_id";
    private static final String COL_ChTrain = "Train";
    private static final String COL_ChWay = "Way";
    private static final String COL_Chday = "Day";
    private static final String COL_ChPribil = "Pribil_v";
    private static final String COL_ChYedet = "Yedet_v";
    private static final String COL_ChPut = "Put";
    private static final String COL_ChPlatform = "Platform";
    private static final String COL_ChVagon = "Vagonov";
    private static final String COL_ChMest = "Mest";

    static final String TABLECARG = "CargoTrains"; //таблица с груз составамм
    private static final String COL_CaID = "_id";
    private static final String COL_CaTrain = "Train";
    private static final String COL_CaWay = "Way";
    private static final String COL_CaDay = "Day";
    private static final String COL_CaPribil = "Pribil_v";
    private static final String COL_CaYedet = "Yedet_v";
    private static final String COL_Cargo = "Cargo";
    private static final String COL_Weight = "Weight";
    private static final String COL_Price = "Price";
    private static final String COL_Vagonov = "Vagonov";
    private static final String COL_Add = "Dobavleno";
    private static final String COL_Addnt = "Ybrano";

        MyDatabaseHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            DB_PATH = "/data/data/com.example.dbpoezdov/databases/";
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLEREG +
                    " (" + COL_RegID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLTicket_RegID + " STRING, " +
                    COLWagon_classREG + " TEXT, " +
                    COLNtrain + " STRING," +//было TEXT
                    COLPreveligy +" TEXT, " +
                    COLPriceREG +" STRING );";
            db.execSQL(query);

            String query1 = "CREATE TABLE " + TABLEOUT +
                    " (" + COL_OutID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLNOutTicket + " STRING, " +
                    COLFname + " TEXT, " +
                    COLLname + " TEXT, " +
                    COLSname + " TEXT, " +
                    COLNPass + " STRING, " +
                    COLTraiN + " STRING, " +
                    COLWagClass + " TEXT, " +
                    COLNWag + " INTEGER, " +
                    COLSeat + " INTEGER, " +
                    COLPriceOut + " STRING);";
            db.execSQL(query1);

            String query2 = "CREATE TABLE " + TABLECHED +
                    " (" + COL_ChID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_ChTrain + " STRING, " +
                    COL_ChWay + " STRING, " +
                    COL_Chday + " STRING, " +
                    COL_ChPribil + " STRING, " +
                    COL_ChYedet + " STRING, " +
                    COL_ChPut + " INTEGER, " +
                    COL_ChPlatform + " INTEGER, " +
                    COL_ChVagon + " INTEGER, " +
                    COL_ChMest + " INTEGER);";
            db.execSQL(query2);

            String query3 = "CREATE TABLE " + TABLECARG +
                    " (" + COL_CaID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_CaTrain + " STRING, " +
                    COL_CaWay + " STRING, " +
                    COL_CaDay + " STRING, " +
                    COL_CaPribil + " STRING, " +
                    COL_CaYedet + " STRING, " +
                    COL_Cargo + " STRING, " +
                    COL_Weight + " INTEGER, " +
                    COL_Price + " INTEGER, " +
                    COL_Vagonov + " INTEGER, " +
                    COL_Add + " INTEGER, " +
                    COL_Addnt + " INTEGER);";
            db.execSQL(query3);
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLEREG);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLEOUT);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLECHED);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLECARG);
        onCreate(db);
    }


    void addREGinfo(String RegID, String classREG, String NTrain, String PrevREG, int PriceREG){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLTicket_RegID, RegID);
        cv.put(COLWagon_classREG, classREG);
        cv.put(COLNtrain, NTrain);
        cv.put(COLPreveligy, PrevREG);
        cv.put(COLPriceREG, PriceREG);
        long result = db.insert(TABLEREG,null, cv);
        if(result == -1){
            Toast.makeText(context, "Ошибка", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Добавлено", Toast.LENGTH_SHORT).show();
        }
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


    void addCHEDinfo(String TrainCh, String WayCh, int DayCh, String PribilCh, String YedetCh, int PutCh,  int PlatformCh, int VagonCh, int MestCh){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_ChTrain, TrainCh);
        cv.put(COL_ChWay, WayCh);
        cv.put(COL_Chday, DayCh);
        cv.put(COL_ChPribil, PribilCh);
        cv.put(COL_ChYedet, YedetCh);
        cv.put(COL_ChPut, PutCh);
        cv.put(COL_ChPlatform, PlatformCh);
        cv.put(COL_ChVagon, VagonCh);
        cv.put(COL_ChMest, MestCh);
        long result = db.insert(TABLECHED,null, cv);
        if(result == -1){
            Toast.makeText(context, "Ошибка", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Добавлено", Toast.LENGTH_SHORT).show();
        }
    }

    void addCargoinfo(String TrainCa, String WayCa, int DayCa, String PribilCa, String YedetCa, String CargoCa, int WeightCa,  int PriceCa, int VagonovCa, int AddCa, int AddntCa){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_CaTrain, TrainCa);
        cv.put(COL_CaWay, WayCa);
        cv.put(COL_CaDay, DayCa);
        cv.put(COL_CaPribil, PribilCa);
        cv.put(COL_CaYedet, YedetCa);
        cv.put(COL_Cargo, CargoCa);
        cv.put(COL_Weight, WeightCa);
        cv.put(COL_Price, PriceCa);
        cv.put(COL_Vagonov, VagonovCa);
        cv.put(COL_Add, AddCa);
        cv.put(COL_Addnt, AddntCa);
        long result = db.insert(TABLECARG,null, cv);
        if(result == -1){
            Toast.makeText(context, "Ошибка", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Добавлено", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllDataREG(){
        String query = "SELECT * FROM " + TABLEREG;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
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

    Cursor readAllDataCHED(){
        String query = "SELECT * FROM " + TABLECHED;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor readAllDataCARGO(){
        String query = "SELECT * FROM " + TABLECARG;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateREGdata(String RegRow_id, String RegID, String classREG, String TrainNum, String PrevREG, String PriceREG){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLTicket_RegID, RegID);
        cv.put(COLWagon_classREG, classREG);
        cv.put(COLNtrain, TrainNum);
        cv.put(COLPreveligy, PrevREG);
        cv.put(COLPriceREG, PriceREG);

        long result = db.update(TABLEREG, cv, "_id=?", new String[]{RegRow_id});
        if(result == -1){
            Toast.makeText(context, "Ошибка обновления", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Успешно обновлено", Toast.LENGTH_SHORT).show();
        }

    }

    void updateOutData(String OutRow_id, String name1, String name2, String name3, String Passp, String Train, String Ticket, String Class, String NumWag, String OutSeat, String OutPrice){
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

        long result = db.update(TABLEOUT, cv, "_id=?", new String[]{OutRow_id});
        if(result == -1){
            Toast.makeText(context, "Ошибка обновления", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Успешно обновлено", Toast.LENGTH_SHORT).show();
        }

    }


    void updateChedData(String ChedRow_id, String TrainCh, String WayCh, String DayCh, String PribilCh, String YedetCh, String PutCh, String PlatformCh, String VagonCh, String MestCh){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_ChTrain, TrainCh);
        cv.put(COL_ChWay, WayCh);
        cv.put(COL_Chday, DayCh);
        cv.put(COL_ChPribil, PribilCh);
        cv.put(COL_ChYedet, YedetCh);
        cv.put(COL_ChPut, PutCh);
        cv.put(COL_ChPlatform, PlatformCh);
        cv.put(COL_ChVagon, VagonCh);
        cv.put(COL_ChMest, MestCh);

        long result = db.update(TABLECHED, cv, "_id=?", new String[]{ChedRow_id});
        if(result == -1){
            Toast.makeText(context, "Ошибка обновления", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Успешно обновлено", Toast.LENGTH_SHORT).show();
        }

    }

    void updateCargoData(String CargoRow_id, String TrainCa, String WayCa, String DayCa, String PribilCa, String YedetCa, String CargoCa, String WeightCa, String PriceCa, String VagonovCa, String AddCa, String AddntCa){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_CaTrain, TrainCa);
        cv.put(COL_CaWay, WayCa);
        cv.put(COL_CaDay, DayCa);
        cv.put(COL_CaPribil, PribilCa);
        cv.put(COL_CaYedet, YedetCa);
        cv.put(COL_Cargo, CargoCa);

        cv.put(COL_Weight, WeightCa);
        cv.put(COL_Price, PriceCa);
        cv.put(COL_Vagonov, VagonovCa);
        cv.put(COL_Add, AddCa);
        cv.put(COL_Addnt, AddntCa);

        long result = db.update(TABLECARG, cv, "_id=?", new String[]{CargoRow_id});
        if(result == -1){
            Toast.makeText(context, "Ошибка обновления", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Успешно обновлено", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneREGrow(String RegRow_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLEREG, "_id=?", new String[]{RegRow_id});
        if(result == -1){
            Toast.makeText(context, "Ошибка удаления", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Билет удалён", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneOutRow(String OutRow_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLEOUT, "_id=?", new String[]{OutRow_id});
        if(result == -1){
            Toast.makeText(context, "Ошибка удаления", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Билет удалён", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneChedRow(String ChedRow_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLECHED, "_id=?", new String[]{ChedRow_id});
        if(result == -1){
            Toast.makeText(context, "Ошибка удаления", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Состав успешно удалён", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneCargoRow(String CargoRow_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLECARG, "_id=?", new String[]{CargoRow_id});
        if(result == -1){
            Toast.makeText(context, "Ошибка удаления", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Состав успешно удалён", Toast.LENGTH_SHORT).show();
        }
    }



}
