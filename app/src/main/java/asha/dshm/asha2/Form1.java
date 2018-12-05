package asha.dshm.asha2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Form1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Button next;
    private static final String TAG = "response";
    Spinner spinner_house, spinner_own, spinner_rooms, spinner_water, spinner_wheeler, spinner_toilet, spinner_drainage, spinner_garbage;
    private RadioGroup radioRoomGroup, radioElectricityGroup, radioWaterGroup;
    private RadioButton radioRoomButton, radioElectricityButton, radioWaterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        next = (Button) findViewById(R.id.save);
        next.setOnClickListener(this);
        spinner_house = (Spinner) findViewById(R.id.house_type_array);
        ArrayAdapter<CharSequence> adapter_house = ArrayAdapter.createFromResource(this,
                R.array.house_type_array, android.R.layout.simple_spinner_item);
        adapter_house.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_house.setAdapter(adapter_house);

        spinner_house.setOnItemSelectedListener(this);

        spinner_own = (Spinner) findViewById(R.id.ownership_array);
        ArrayAdapter<CharSequence> adapter_own = ArrayAdapter.createFromResource(this,
                R.array.ownership_array, android.R.layout.simple_spinner_item);
        adapter_own.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_own.setAdapter(adapter_own);

        spinner_own.setOnItemSelectedListener(this);

        spinner_rooms = (Spinner) findViewById(R.id.rooms_array);
        ArrayAdapter<CharSequence> adapter_rooms = ArrayAdapter.createFromResource(this,
                R.array.rooms_array, android.R.layout.simple_spinner_item);
        adapter_rooms.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_rooms.setAdapter(adapter_rooms);

        spinner_rooms.setOnItemSelectedListener(this);

        spinner_water = (Spinner) findViewById(R.id.water_source_array);
        ArrayAdapter<CharSequence> adapter_water = ArrayAdapter.createFromResource(this,
                R.array.water_source_array, android.R.layout.simple_spinner_item);
        adapter_water.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_water.setAdapter(adapter_water);

        spinner_water.setOnItemSelectedListener(this);


        spinner_wheeler = (Spinner) findViewById(R.id.wheeler_array);
        ArrayAdapter<CharSequence> adapter_wheeler = ArrayAdapter.createFromResource(this,
                R.array.wheeler_array, android.R.layout.simple_spinner_item);
        adapter_wheeler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_wheeler.setAdapter(adapter_wheeler);

        spinner_wheeler.setOnItemSelectedListener(this);


        spinner_toilet = (Spinner) findViewById(R.id.toilet_array);
        ArrayAdapter<CharSequence> adapter_toilet = ArrayAdapter.createFromResource(this,
                R.array.toilet_array, android.R.layout.simple_spinner_item);
        adapter_toilet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_toilet.setAdapter(adapter_toilet);

        spinner_toilet.setOnItemSelectedListener(this);


        spinner_drainage = (Spinner) findViewById(R.id.drainage_array);
        ArrayAdapter<CharSequence> adapter_drainage = ArrayAdapter.createFromResource(this,
                R.array.drainage_array, android.R.layout.simple_spinner_item);
        adapter_drainage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_drainage.setAdapter(adapter_drainage);

        spinner_drainage.setOnItemSelectedListener(this);


        spinner_garbage = (Spinner) findViewById(R.id.garbage_array);
        ArrayAdapter<CharSequence> adapter_garbage = ArrayAdapter.createFromResource(this,
                R.array.garbage_array, android.R.layout.simple_spinner_item);
        adapter_garbage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_garbage.setAdapter(adapter_garbage);

        spinner_garbage.setOnItemSelectedListener(this);

        radioRoomGroup = (RadioGroup) findViewById(R.id.room);
        radioElectricityGroup = (RadioGroup) findViewById(R.id.electricity);
        radioWaterGroup = (RadioGroup) findViewById(R.id.water_toilet);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save: {
                radioRoomButton = (RadioButton) findViewById(radioRoomGroup.getCheckedRadioButtonId());
                radioElectricityButton = (RadioButton) findViewById(radioElectricityGroup.getCheckedRadioButtonId());
                radioWaterButton = (RadioButton) findViewById(radioWaterGroup.getCheckedRadioButtonId());


                postData().enqueue(new Callback<BasicAmenitiesResponse>() {

                    @Override
                    public void onResponse(Call<BasicAmenitiesResponse> call, Response<BasicAmenitiesResponse> response) {
                        if (response.isSuccessful()) {
                            Log.i(TAG, "post submitted to API." + response.body().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<BasicAmenitiesResponse> call, Throwable t) {
                        Log.e(TAG, "Unable to submit post to API.");
                    }
                });

                Intent nextIntent = new Intent(this, Form4.class);
                startActivity(nextIntent);
            }
        }
    }


    private Call<BasicAmenitiesResponse> postData() {
        ApiInterface apii = Api.getClient().create(ApiInterface.class);
        Boolean seprateRooms = radioRoomButton.getText().toString().trim().compareTo("YES") == 0;
        Boolean electricity = radioElectricityButton.getText().toString().trim().compareTo("YES") == 0;
        Boolean water = radioWaterButton.getText().toString().trim().compareTo("YES") == 0;
        int a[] = mapValues();
        Log.d("ba","BA");
        for(int i=0;i<a.length;i++){
            Log.d("ARRAY",a[i]+"\n");
        }

        return apii.basicAmenities(
                51 + "",
                a[0]+"",
                a[1]+"",
                Integer.parseInt(spinner_rooms.getSelectedItem().toString()),
                seprateRooms,
                electricity,
                a[2]+"",
                a[3]+"",
                a[4]+"",
                water,
                a[5]+"",
                a[6]
        );
    }

    public int[] mapValues() {
        int a[] = new int[7];
        switch (spinner_house.getSelectedItem().toString()) {
            case "Kachha": {
                Log.d("kachha","kachha");
                a[0] = 5;
                break;
            }
            case "Pakka": {
                a[0] = 2;
                break;
            }
            case "Semi-Pakka": {
                a[0] = 3;
                break;
            }
            case "Jhuggi": {
                a[0] = 4;
                break;
            }
            case "Homeless": {
                a[0] = 5;
                break;
            }
        }
        switch (spinner_own.getSelectedItem().toString()) {
            case "Rented": {
                a[1] = 1;
                break;
            }
            case "Own": {
                a[1] = 2;
                break;
            }
            case "Government": {
                a[1] = 3;
                break;
            }

        }

        switch (spinner_water.getSelectedItem().toString()) {
            case "Govt. Tap Water": {
                a[2] = 1;
                break;
            }
            case "Hand Pump": {
                a[2] = 2;
                break;
            }
            case "Tanker": {
                a[2] = 3;
                break;
            }
            case "Other": {
                a[2] = 4;
                break;
            }
        }

        switch (spinner_wheeler.getSelectedItem().toString()) {
            case "Two Wheeler": {
                a[3] = 1;
                break;
            }
            case "Three Wheeler": {
                a[3] = 2;
                break;
            }
            case "Four Wheeler": {
                a[3] = 3;
                break;
            }
        }

        switch (spinner_toilet.getSelectedItem().toString()) {
            case "Own in house": {
                a[4] = 1;
                break;
            }
            case "Public": {
                a[4] = 2;
                break;
            }
            case "Open Defacation": {
                a[4] = 3;
                break;
            }
        }

        switch (spinner_drainage.getSelectedItem().toString()) {
            case "Closed": {
                a[5] = 1;
                break;
            }
            case "Open": {
                a[5] = 2;
                break;
            }
            case "Blocked": {
                a[5] = 3;
                break;
            }
        }
        switch (spinner_garbage.getSelectedItem().toString()) {
            case "By Sweeper": {
                a[6] = 1;
                break;
            }
            case "Open": {
                a[6] = 2;
                break;
            }
            case "Other": {
                a[6] = 3;
                break;
            }
        }
        return a;

    }


}



