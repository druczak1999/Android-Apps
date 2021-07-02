package com.example.fiszki;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "Fiszki.db", null, 1);
        //SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Angielski (ID INTEGER PRIMARY KEY AUTOINCREMENT, pierwsza INTEGER, druga INTEGER, trzecia INTEGER, czwarta INTEGER, piata INTEGER, szosta INTEGER, siodma INTEGER, osma INTEGER, dziewiata INTEGER, dziesiata INTEGER, jedenasta INTEGER, dwunasta INTEGER)");
        db.execSQL("CREATE TABLE Niemiecki (ID INTEGER PRIMARY KEY AUTOINCREMENT, pierwsza INTEGER, druga INTEGER, trzecia INTEGER, czwarta INTEGER, piata INTEGER, szosta INTEGER, siodma INTEGER, osma INTEGER, dziewiata INTEGER, dziesiata INTEGER, jedenasta INTEGER, dwunasta INTEGER)");
        db.execSQL("CREATE TABLE Hiszpanski (ID INTEGER PRIMARY KEY AUTOINCREMENT, pierwsza INTEGER, druga INTEGER, trzecia INTEGER, czwarta INTEGER, piata INTEGER, szosta INTEGER, siodma INTEGER, osma INTEGER, dziewiata INTEGER, dziesiata INTEGER, jedenasta INTEGER, dwunasta INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS Angielski");
            db.execSQL("DROP TABLE IF EXISTS Niemiecki");
            db.execSQL("DROP TABLE IF EXISTS Hiszpanski");
            onCreate(db);
    }

    public Boolean insertData(String tabela,String kolumna,int value){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(kolumna, value);
        long result=DB.insert(tabela,null,contentValues);
        if (result==-1) return false;
        else return true;
    }
    public Boolean updateData(String tabela,String kolumna,int value,int id){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(kolumna, value);
        Cursor cursor=DB.rawQuery("SELECT * FROM "+tabela+" where id = ?", new String[]{String.valueOf(id)});
        if(cursor.getCount()>0){
            long result=DB.update(tabela,contentValues,"id=?",new String []{String.valueOf(id)});
            if (result==-1) return false;
            else return true;
        }
        else return false;
    }
    public Boolean deleteData(String tabela,String kolumna,int value,int id){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("SELECT * FROM "+tabela+" where id = ?", new String[]{String.valueOf(id)});
        if(cursor.getCount()>0){
            long result=DB.delete(tabela,"id=?",new String []{String.valueOf(id)});
            if (result==-1) return false;
            else return true;
        }
        else return false;
    }

    /*public Cursor getData(String tabela){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("SELECT * FROM "+tabela,null);
        return cursor;
    }*/
    public Cursor getData(String tabela,int id){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("SELECT * FROM "+tabela+" where id = ?",new String[]{String.valueOf(id)});
        return cursor;
    }
}
