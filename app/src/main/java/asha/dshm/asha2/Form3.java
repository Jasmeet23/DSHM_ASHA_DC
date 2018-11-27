package asha.dshm.asha2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Form3 extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "response";
    private int mYear, mMonth, mDay;
    Button next;
    TextView date;
    ImageButton calendar;
    EditText Asha, Anm, Health, AreaCode, AreaDesc, FamilyHead, Address, Pincode, MobileNo, LandlineNo;
    Spinner Category, Religion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form3);

        next = (Button) findViewById(R.id.save);
        date = (TextView) findViewById(R.id.E_Date);
        calendar = (ImageButton) findViewById(R.id.calendar);
        Asha = (EditText) findViewById(R.id.asha);
        Anm = (EditText) findViewById(R.id.anm);
        Health = (EditText) findViewById(R.id.health_facility);
        AreaCode = (EditText) findViewById(R.id.area_code);
        AreaDesc = (EditText) findViewById(R.id.area_desc);
        FamilyHead = (EditText) findViewById(R.id.family_head);
        Address = (EditText) findViewById(R.id.address);
        Pincode = (EditText) findViewById(R.id.pincode);
        MobileNo = (EditText) findViewById(R.id.mobile_no);
        LandlineNo = (EditText) findViewById(R.id.landline);
        Category = (Spinner) findViewById(R.id.caste_category);
        Religion = (Spinner) findViewById(R.id.religion);


        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(Form3.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                date.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
            }
        });
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save: {
                if (!validate())
                    AreaCode.setError("Enter code");
                Log.d(TAG, "mahika1");

                postData().enqueue(new Callback<FamilyResponse>() {
                    @Override
                    public void onResponse(Call<FamilyResponse> call, Response<FamilyResponse> response) {
                        if (response.isSuccessful()) {
                            Log.i(TAG, "post submitted to API." + response.body().toString());
                            Log.d(TAG, "pass");
                        }
                        if (!response.isSuccessful()) {
                            Log.i(TAG, "post not done." + response.errorBody().toString());
                            Log.d(TAG, response.code() + "");
                            Log.d(TAG, "fail");
                        }
                    }

                    @Override
                    public void onFailure(Call<FamilyResponse> call, Throwable t) {
                        // logging probably not necessary
                        Log.d(TAG, call.request().body().toString());
                        if (t instanceof IOException) {
                            System.out.println("failure network");
                        }


                        Log.e(TAG, "Unable to submit post to API.");
                        Log.d(TAG, "fail");
                    }
                });
                Intent nextIntent = new Intent(this, Form1.class);
                startActivity(nextIntent);

            }
        }
    }

    Boolean validate() {
        if (AreaCode.getText().toString().compareTo("") == 0)
            return false;
        return true;
    }


    private Call<FamilyResponse> postData() {
        ApiInterface apii = Api.getClient().create(ApiInterface.class);
        Log.d(TAG, "mahika2");
        int category = 0, religion = 0;
        switch (Category.getSelectedItem().toString()) {
            case "General": {
                category = 1;
                break;
            }
            case "SC": {
                category = 2;
                break;
            }
            case "ST": {
                category = 3;
                break;
            }
            case "Other": {
                category = 4;
                break;
            }
        }
        switch (Religion.getSelectedItem().toString()) {
            case "Hindu": {
                religion = 1;
                break;
            }
            case "Muslim": {
                religion = 2;
                break;
            }
            case "Sikh": {
                religion = 3;
                break;
            }
            case "Isai": {
                religion = 4;
                break;
            }
            case "Other": {
                religion = 5;
                break;
            }
        }
        return apii.family(
                44 + "",
                Asha.getText().toString().trim(),
                Anm.getText().toString().trim(),
                Health.getText().toString().trim(),
                Integer.parseInt(AreaCode.getText().toString().trim()),
                AreaDesc.getText().toString().trim(),
                date.getText().toString().trim(),
                FamilyHead.getText().toString().trim(),
                Address.getText().toString().trim(),
                Pincode.getText().toString().trim(),
                MobileNo.getText().toString().trim(),
                LandlineNo.getText().toString().trim(),
                category+"",
                religion+""
        );
    }


}

