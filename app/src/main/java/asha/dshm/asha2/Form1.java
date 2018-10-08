package asha.dshm.asha2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Form1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1);

        next= (Button) findViewById(R.id.save);
        next.setOnClickListener(this);
        Spinner spinner_house = (Spinner) findViewById(R.id.house_type_array);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_house = ArrayAdapter.createFromResource(this,
                R.array.house_type_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter_house.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_house.setAdapter(adapter_house);

        //age = (EditText)findViewById(R.id.E_Age);
        spinner_house.setOnItemSelectedListener(this);

        Spinner spinner_own = (Spinner) findViewById(R.id.ownership_array);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_own = ArrayAdapter.createFromResource(this,
                R.array.ownership_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter_own.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_own.setAdapter(adapter_own);

        //age = (EditText)findViewById(R.id.E_Age);
        spinner_own.setOnItemSelectedListener(this);

        Spinner spinner_rooms = (Spinner) findViewById(R.id.rooms_array);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_rooms = ArrayAdapter.createFromResource(this,
                R.array.rooms_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter_rooms.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_rooms.setAdapter(adapter_rooms);

        //age = (EditText)findViewById(R.id.E_Age);
        spinner_rooms.setOnItemSelectedListener(this);

        Spinner spinner_water = (Spinner) findViewById(R.id.water_source_array);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_water = ArrayAdapter.createFromResource(this,
                R.array.water_source_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter_water.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_water.setAdapter(adapter_water);

        //age = (EditText)findViewById(R.id.E_Age);
        spinner_water.setOnItemSelectedListener(this);


        Spinner spinner_wheeler = (Spinner) findViewById(R.id.wheeler_array);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_wheeler = ArrayAdapter.createFromResource(this,
                R.array.wheeler_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter_wheeler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_wheeler.setAdapter(adapter_wheeler);

        //age = (EditText)findViewById(R.id.E_Age);
        spinner_wheeler.setOnItemSelectedListener(this);


        Spinner spinner_toilet = (Spinner) findViewById(R.id.toilet_array);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_toilet = ArrayAdapter.createFromResource(this,
                R.array.toilet_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter_toilet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_toilet.setAdapter(adapter_toilet);

        //age = (EditText)findViewById(R.id.E_Age);
        spinner_toilet.setOnItemSelectedListener(this);


        Spinner spinner_drainage = (Spinner) findViewById(R.id.drainage_array);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_drainage = ArrayAdapter.createFromResource(this,
                R.array.drainage_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter_drainage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_drainage.setAdapter(adapter_drainage);

        //age = (EditText)findViewById(R.id.E_Age);
        spinner_drainage.setOnItemSelectedListener(this);


        Spinner spinner_garbage = (Spinner) findViewById(R.id.garbage_array);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_garbage = ArrayAdapter.createFromResource(this,
                R.array.garbage_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter_garbage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_garbage.setAdapter(adapter_garbage);

        //age = (EditText)findViewById(R.id.E_Age);
        spinner_garbage.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.save:
            {
                Intent nextIntent= new Intent(this, Form4.class);
                startActivity(nextIntent);
            }
        }
    }
}
