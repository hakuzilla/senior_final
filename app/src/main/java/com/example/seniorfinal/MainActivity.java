package com.example.seniorfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity /*implements AdapterView.OnItemSelectedListener */{
    private Button search_button;
    private Button deckbuilder_button;
    // private Spinner fSpinner;

    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initialize database
        databaseHelper = new DatabaseHelper(this, "jptranslations.db", 1);
        try{
            databaseHelper.CheckDB();

        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            databaseHelper.openDatabase();
        } catch (Exception e){
            e.printStackTrace();
        }

        //initialize search button
        search_button = (Button) findViewById(R.id.openSearch);
        search_button.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View view) {
                //call open search activity method
                openSearch();
            }
        });

        //initialize deckbuilder button
        deckbuilder_button = (Button) findViewById(R.id.openDeckbuilder);
        deckbuilder_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //call open deckbuilder method
                 openDeckBuilder();
            }
        });
        databaseHelper.close();



    } //end on create

    public void openSearch(){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void openDeckBuilder(){
        Intent intent = new Intent(this, Deckbuilder.class);
        startActivity(intent);
    }

    /*
    //fspinner toast
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(), choice, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    */
}