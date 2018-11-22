package asha.dshm.asha2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Form4 extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "response";
    Button next;
    private RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4;
    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form4);
        next = (Button) findViewById(R.id.save);
        next.setOnClickListener(this);

        radioGroup1 = (RadioGroup) findViewById(R.id.anganwadi);
        radioGroup2 = (RadioGroup) findViewById(R.id.cats);
        radioGroup3 = (RadioGroup) findViewById(R.id.dispensary);
        radioGroup4 = (RadioGroup) findViewById(R.id.pds);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.save: {
                radioButton1 = (RadioButton) findViewById(radioGroup1.getCheckedRadioButtonId());
                radioButton2 = (RadioButton) findViewById(radioGroup2.getCheckedRadioButtonId());
                radioButton3 = (RadioButton) findViewById(radioGroup3.getCheckedRadioButtonId());
                radioButton4 = (RadioButton) findViewById(radioGroup4.getCheckedRadioButtonId());
                postData().enqueue(new Callback<OtherServiceResponse>() {

                    @Override
                    public void onResponse(Call<OtherServiceResponse> call, Response<OtherServiceResponse> response) {
                        if (response.isSuccessful()) {
                            Log.i(TAG, "post submitted to API." + response.body().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<OtherServiceResponse> call, Throwable t) {
                        Log.e(TAG, "Unable to submit post to API.");
                    }
                });
                Intent nextIntent = new Intent(this, Form2.class);
                startActivity(nextIntent);
            }
        }
    }

    private Call<OtherServiceResponse> postData() {
        ApiInterface apii = Api.getClient().create(ApiInterface.class);
        Boolean anganwadi = radioButton1.getText().toString().trim().compareTo("YES") == 0;
        Boolean cats = radioButton2.getText().toString().trim().compareTo("YES") == 0;
        Boolean disability = radioButton3.getText().toString().trim().compareTo("YES") == 0;
        Boolean pds = radioButton4.getText().toString().trim().compareTo("YES") == 0;


        return apii.otherService(42+"",anganwadi, cats, disability, pds);
    }
}
