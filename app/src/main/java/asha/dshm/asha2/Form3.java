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

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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

                                date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

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
//                while(true){
                    if(!validate())
                        AreaCode.setError("Enter code");

//                }
                postData().enqueue(new Callback<FamilyResponse>() {

                    @Override
                    public void onResponse(Call<FamilyResponse> call, Response<FamilyResponse> response) {
                        if (response.isSuccessful()) {
                            Log.i(TAG, "post submitted to API." + response.body().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<FamilyResponse> call, Throwable t) {
                        Log.e(TAG, "Unable to submit post to API.");
                    }
                });
                Intent nextIntent = new Intent(this, Form1.class);
                startActivity(nextIntent);

            }
        }
    }

    Boolean validate(){
        if(AreaCode.getText().toString().compareTo("")==0)
            return false;
        return true;
    }


    private Call<FamilyResponse> postData() {
        ApiInterface apii = Api.getClient().create(ApiInterface.class);
        return apii.family(Asha.getText().toString().trim(),
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
                Category.getSelectedItem().toString(),
                Religion.getSelectedItem().toString()
        );
    }


}

