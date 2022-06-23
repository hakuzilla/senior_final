package com.example.seniorfinal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.ResultSet;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    //constructor
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);

    }


    //return instance of db
    public static DatabaseAccess getInstance(Context context){
        if(instance==null){
            instance=new DatabaseAccess(context);

        }
        return instance;
    }

    //open database
    public void openDB(){
        this.db=openHelper.getReadableDatabase();

    }

    //close the db
    public void closeDB(){
        if(db!=null){
            this.db.close();
        }
    }

    //method to query and return result from db
    public String getName(String input){
        //String query = "Select Card.card_id, Card.card_name, Card.card_jpname from Card Where Card.card_name LIKE ?";
        //String[] selectionArgs = {input};
        c=db.rawQuery("select Card.card_name from Card Where Card.card_name LIKE '" +input+ "'", null);
        //c=db.rawQuery("Select Card.card_id, Card.card_name, Card.card_jpname from Card Where Card.card_name LIKE '" + input + "'", null);


        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String result = c.getString(0);
            buffer.append(""+result);

        }
        return buffer.toString();

    }
}
