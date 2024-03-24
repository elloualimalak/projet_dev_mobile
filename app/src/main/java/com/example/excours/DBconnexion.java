package com.example.excours;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DBconnexion extends SQLiteOpenHelper {
    public DBconnexion(Context context) {
        super(context,"Personnes.db", null, 1);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Admin (ID INTEGER PRIMARY KEY, Name TEXT);");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Admin");
        onCreate(db);
    }
    public void insertNewAdmin(String name){
        SQLiteDatabase wDB = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put("Name", name);
        wDB.insert("Admin"
                ,null,contentValue);
    }
    public void deleteRow(Integer id){
        SQLiteDatabase wDB = this.getWritableDatabase();
        String[] s = new String[]{String.valueOf(id)};
        wDB.delete("Admin","ID=?",s);
    }
    public void updateRow(String name, Integer id){
        SQLiteDatabase wDB = this.getWritableDatabase();
        wDB.execSQL("update Admin set Name='"+name+"' where ID="+String.valueOf(id));
    }

}
