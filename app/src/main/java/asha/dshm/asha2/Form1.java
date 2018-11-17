package asha.dshm.asha2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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


        return apii.basicAmenities(
                spinner_house.getSelectedItem().toString().trim(),
                spinner_own.getSelectedItem().toString().trim(),
                Integer.parseInt(spinner_rooms.getSelectedItem().toString()),
                seprateRooms,
                electricity,
                spinner_water.getSelectedItem().toString().trim(),
                spinner_wheeler.getSelectedItem().toString().trim(),
                spinner_toilet.getSelectedItem().toString().trim(),
                water,
                spinner_drainage.getSelectedItem().toString().trim(),
                spinner_garbage.getSelectedItem().toString().trim()
        );
    }


}
