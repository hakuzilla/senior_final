package com.example.seniorfinal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    Context mcontext;
    String dbname;
    String dbPath;

    public DatabaseHelper(Context context, String name, int version) {
        super(context, name, null, version);

        this.dbname = name;
        this.mcontext = context;

        this.dbPath = "/data/data/" + "com.example.seniorfinal" + "/databases/";

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void CheckDB(){
        SQLiteDatabase checkdb = null;
        String filePath = dbPath + dbname;
        try{
            checkdb = SQLiteDatabase.openDatabase(filePath, null, 0);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(checkdb != null){
            Toast.makeText(mcontext, "Database up to date", Toast.LENGTH_SHORT).show();
        } else {
            copyDatabase();
        }
    }

    public void copyDatabase(){
        this.getReadableDatabase();
        try{
            InputStream ios = mcontext.getAssets().open(dbname);
            OutputStream os = new FileOutputStream(dbPath + dbname);

            byte[] buffer = new byte[1024];

            int len = 0;
            while ((len = ios.read(buffer)) > 0 ){
                os.write(buffer, 0, len);
            }
            os.flush();
            ios.close();
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        Log.d("CopyDb", "Database Copied");


    }

    public static void openDatabase(){
        //String filePath = dbPath + dbname;
        //SQLiteDatabase.openDatabase(filePath, null, 0);
        SQLiteDatabase.openDatabase("data/data/com.example.seniorfinal/databases/jptranslations.db", null, 0);


    }
    /*
    public List<ResultTable> selectAll(){
        List<ResultTable> rList = new ArrayList<>();

        String query = "select Card.card_id, Card.card_name, Card.card_jpname from Card";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do {
                String cID = cursor.getString(0);
                String cName = cursor.getString(1);
                String cJPName = cursor.getString(2);

                ResultTable newResults = new ResultTable(cID, cName, cJPName);
                rList.add(newResults);

            } while (cursor.moveToFirst());

        } else {
            //fail. nothing added

        }

        cursor.close();
        db.close();
        return rList;
    }

     */
}
