package com.example.seniorfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Deckbuilder extends AppCompatActivity {

    //declare buttons and listviews
    private Button newDeck;
    //private Button deleteDeck;
    private ListView decklists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deckbuilder);

        newDeck = findViewById(R.id.newDeck);
        newDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewDeck();
            }
        });




    } //end oncreate
    //todo make new deck class and activity
    public void openNewDeck(){
        Intent intent = new Intent(this, DecklistsBuilder.class);
        startActivity(intent);
    }


}