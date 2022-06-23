package com.example.seniorfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {

    //declare the textviews
    private TextView name;
    private TextView jpName;
    private TextView cardID;
    private TextView cardType;
    private TextView color;
    private TextView cost;
    private TextView power;
    private TextView trigger;
    private TextView series;
    private TextView level;
    private TextView soul;
    private TextView rarity;
    private TextView attributes;
    private TextView jpSeries;
    private TextView effect1;
    private TextView effect2;
    private TextView effect3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        //load serialized data
        Intent mIntent = getIntent();
        ResultTable passedResults = (ResultTable)   mIntent.getSerializableExtra("ResultKey");

        //link textviews
        name = findViewById(R.id.data_name);
        jpName = findViewById(R.id.data_jpname);
        cardID = findViewById(R.id.data_id);
        cardType = findViewById(R.id.data_type);
        color = findViewById(R.id.data_color);
        cost = findViewById(R.id.data_cost);
        power = findViewById(R.id.data_power);
        trigger = findViewById(R.id.data_trigger);
        series = findViewById(R.id.data_series);
        level = findViewById(R.id.data_level);
        soul = findViewById(R.id.data_soul);
        rarity = findViewById(R.id.data_rarity);
        attributes = findViewById(R.id.data_attribute);
        jpSeries = findViewById(R.id.data_seriesjp);
        effect1 = findViewById(R.id.data_effect1);
        effect2 = findViewById(R.id.data_effect2);
        effect3 = findViewById(R.id.data_effect3);



        //set data to textview
        name.setText(passedResults.getName());
        jpName.setText(passedResults.getJpName());
        cardID.setText(passedResults.getID());
        cardType.setText(passedResults.getType());
        color.setText(passedResults.getColor());
        cost.setText(String.valueOf(passedResults.getCost()));
        power.setText(String.valueOf(passedResults.getPower()));
        trigger.setText(passedResults.getTrigger());
        series.setText(passedResults.getSeries_name());
        level.setText(String.valueOf(passedResults.getLevel()));
        soul.setText(passedResults.getSoul());
        rarity.setText(passedResults.getRarity());
        attributes.setText(passedResults.getAttribute());
        jpSeries.setText(passedResults.getSeries_jpname());
        effect1.setText(passedResults.getEffect1());
        effect2.setText(passedResults.getEffect2());
        effect3.setText(passedResults.getEffect3());



    }
}