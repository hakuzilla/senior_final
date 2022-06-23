package com.example.seniorfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class SearchActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //reference to all spinners
    private Spinner fSpinner;
    private Spinner colorSpinner;
    private Spinner costSpinner;
    private Spinner lSpinner;
    private Spinner sSpinner;
    private Spinner tSpinner;
    private Spinner setSpinner;

    //references to all buttons
    private Button filterButton;

    //reference to list/recycle view
    private ListView listResults;

    //user input text
    public EditText userInput;

    //sanity check result
    //private TextView results;

    //QueriesBank qb = new QueriesBank();
    //ArrayList<resultTable> aList;
    public String searchfilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        userInput = findViewById(R.id.userSearch);

        //populate set spinner
        setSpinner = findViewById(R.id.SetSpinner);
        ArrayAdapter<CharSequence> setAdapter = ArrayAdapter.createFromResource(this, R.array.SetFilter, android.R.layout.simple_spinner_item);
        setAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        setSpinner.setAdapter(setAdapter);
        setSpinner.setOnItemSelectedListener(this);

        //populate filter spinner
        fSpinner = findViewById(R.id.fspinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.searchfilter, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        fSpinner.setAdapter(adapter);
        fSpinner.setOnItemSelectedListener(this);

        //populate color spinner
        colorSpinner = findViewById(R.id.cSpinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.colorfilter, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        colorSpinner.setAdapter(adapter2);
        colorSpinner.setOnItemSelectedListener(this);

        //populate costSpinner

        costSpinner = findViewById(R.id.costSpinner);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.costfilter, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        costSpinner.setAdapter(adapter3);
        costSpinner.setOnItemSelectedListener(this);

        //populate levelspinner
        lSpinner = findViewById(R.id.lSpinner);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.levelfilter, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        lSpinner.setAdapter(adapter4);
        lSpinner.setOnItemSelectedListener(this);

        //populate card type spinner
        tSpinner = findViewById(R.id.tSpinner);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.typefilter, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        tSpinner.setAdapter(adapter5);
        tSpinner.setOnItemSelectedListener(this);

        //populate soul spinner
        sSpinner = findViewById(R.id.sSpinner);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.soulfilter, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sSpinner.setAdapter(adapter6);
        sSpinner.setOnItemSelectedListener(this);


        //dummy list result
        ListView lvResult = findViewById(R.id.Results_screen);
        //TextView sanity = findViewById(R.id.sanitycheck);

        //todo set spinner





        //filter button
        filterButton = findViewById(R.id.filterButton);
        //button listeners
        filterButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {


                //make db an object to query
                SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.example.seniorfinal/databases/jptranslations.db", null, 0);
                //declare arraylist to keep arraylist clean on every click
                ArrayList<ResultTable> qResults = new ArrayList<>();
                //ArrayAdapter arAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, qResults);
                ResultAdapter resultAdapter = new ResultAdapter(getApplicationContext(), qResults);
                lvResult.setAdapter(resultAdapter);


                String ui = "";
                ui = userInput.getText().toString();


                //todo query changes according to spinner changes; figure out how that works
                //spinner selection for search filter param
                String sfilter = "";
                String sf = "";
                sfilter = fSpinner.getSelectedItem().toString();
                switch (sfilter){
                    case "Name": sf = "name";
                                break;
                    case "JP Name": sf = "jpname";
                                break;
                    case "ID": sf = "id";
                                break;
                }

                //if empty leave empty
                //spinner selection for color
                String colorfilter = "";
                String colorf = "";
                colorfilter = colorSpinner.getSelectedItem().toString();
                switch (colorfilter){
                    case "": break;
                    case "Red":     colorf = " AND Card.card_color = 'Red' ";
                                    break;
                    case "Yellow":     colorf = " AND Card.card_color = 'Yellow' ";
                                    break;
                    case "Blue":     colorf = " AND Card.card_color = 'Blue' ";
                                    break;
                    case "Green":     colorf = " AND Card.card_color = 'Green' ";
                                    break;

                }
                //sanity check for color filter
                System.out.println(colorf);

                //spinner selection for set
                //todo add to this whenever a new set is added.
                //todo find out how to populate from database later.
                String setfilter = "";
                String set = "";
                setfilter = setSpinner.getSelectedItem().toString();
                switch (setfilter){
                    case "" : break;
                    case "MARVEL" : set = " AND series.series_name LIKE 'MARVEL'";
                            break;
                    case "Hololive" : set = " AND series.series_name LIKE 'Hololive'";
                            break;
                }


                //spinner selection for cost
                String costfilter = "";
                String costf = "";
                costfilter = costSpinner.getSelectedItem().toString();
                switch (costfilter){
                    case "": break;
                    case "0": costf = " AND Card.card_cost = '0' ";
                        break;
                    case "1": costf = " AND Card.card_cost = '1' ";
                        break;
                    case "2": costf = " AND Card.card_cost = '2' ";
                        break;
                    case "3": costf = " AND Card.card_cost = '3' ";
                        break;
                    case "4": costf = " AND Card.card_cost = '4' ";
                        break;
                    case "5": costf = " AND Card.card_cost = '5' ";
                        break;
                    case "6": costf = " AND Card.card_cost = '6' ";
                        break;
                }

                //sanity check
                System.out.println(costf);

                //spinner selection for level
                String lfilter = "";
                String lf = "";
                lfilter = lSpinner.getSelectedItem().toString();
                switch (lfilter){
                    case "": break;
                    case "0": lf = " AND Card.card_level = '0' ";
                        break;
                    case "1": lf = " AND Card.card_level = '1' ";
                        break;
                    case "2": lf = " AND Card.card_level = '2' ";
                        break;
                    case "3": lf = " AND Card.card_level = '3' ";
                        break;
                }
                System.out.println(lf);

                //spinner selection for card type
                String typefilter = "";
                String tf = "";
                typefilter = tSpinner.getSelectedItem().toString();
                switch (typefilter){
                    case "": break;
                    case "Character": tf = " AND type_name = 'Character'";
                        break;
                    case "Event": tf = " AND type_name = 'Event'";
                        break;
                    case "Climax": tf = " AND type_name = 'Climax'";
                        break;
                }
                System.out.println(tf);

                //spinner selection for soul
                String soulFilter = "";
                String soulf = "";
                soulFilter = sSpinner.getSelectedItem().toString();
                switch (soulFilter){
                    case "": break;
                    case "0": soulf = " AND card_soul = '0' ";
                        break;
                    case "1": soulf = " AND card_soul = '1' ";
                        break;
                    case "2": soulf = " AND card_soul = '2' ";
                        break;
                }
                System.out.println(soulf);
                //todo set filter



                //todo ability to have spinner select how to query data
                //Cursor c = db.rawQuery("Select * from Card where Card.card_name LIKE '%" + ui + "%'", null);
                Cursor c = db.rawQuery("Select * from Card " +
                        "inner join card_rarity on card.card_id = card_rarity.card_id " +
                        "inner join rarity on rarity.rarity_id = card_rarity.rarity_id " +
                        "inner join card_trigger on card.card_id = card_trigger.card_id " +
                        "inner join ctrigger on ctrigger.trigger_id = card_trigger.trigger_id " +
                        "inner join card_series on card.card_id = card_series.card_id " +
                        "inner join series on series.series_id = card_series.series_id " +
                        "inner join card_attributes on card.card_id = card_attributes.card_id " +
                        "inner join attributes on attributes.attribute_id = card_attributes.attribute_id " +
                        "inner join card_type on card.card_id = card_type.card_id " +
                        "inner join type on type.type_id = card_type.type_id " +
                        "WHERE " +
                        //todo this should be held by the filter spinner.
                        //"card search filter" +
                        "Card.card_" + sf +
                        " LIKE '%"
                        //USER INPUT
                        + ui + "%'"
                        //color filter
                        + colorf
                        //cost filter
                        + costf
                        //level filter
                        + lf
                        //type filter
                        + tf
                        //soul filter
                        + soulf
                        //todo set filter
                        + set
                        , null);

                System.out.println(ui);

                /*
                structure of return data w/ column indices
                 0 card id | 1 card name | 2 jp name | 3 color | 4 level | 5 cost | 6 soul | 7 effect1 | 8 effect 2| 9 effect 3 |
                 10 power | 14 rarity | 18 trigger type | 22 series name | 23 series jp name | 27 attribute | 31 type
                 */
                //cursor movetofalse() returns a false if empty
                //sanity check logcat print
                //use if statement for a bad query so it doesn't crash
                if(c.moveToFirst() != false) {

                    String res = c.getString(3);
                    System.out.println(res);
                    //sanity.setText(res);

                    res = c.getString(0);
                    System.out.println(res);
                 }


                //
                if (c.moveToFirst() != false)
                {
                    do {
                        qResults.add(new ResultTable(c.getString(0),
                                                     c.getString(1),
                                                     c.getString(2),
                                                     c.getString(3),
                                                     c.getInt(4),
                                                     c.getInt(5),
                                                     c.getString(6),
                                                     c.getString(7),
                                                     c.getString(8),
                                                     c.getString(9),
                                                     c.getInt(10),
                                                     c.getString(14),
                                                     c.getString(18),
                                                     c.getString(22),
                                                     c.getString(23),
                                                     c.getString(27),
                                                     c.getString(31)
                                                    )
                                    );

                    } while (c.moveToNext());
                    Toast.makeText(SearchActivity.this, "Search finished", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SearchActivity.this, "Nothing found", Toast.LENGTH_SHORT).show();
                }

                //sanity check 2
                //System.out.println(qResults.toString());

                //close resources to prevent leak
                c.close();
                db.close();

            }


        });




    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        //sanity check
        /*
        String choice = adapterView.getItemAtPosition(i).toString();
        System.out.println(choice);
        Toast.makeText(getApplicationContext(), choice, Toast.LENGTH_LONG).show();
        */

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }



}
