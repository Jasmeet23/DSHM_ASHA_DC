package asha.dshm.asha2;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import static android.app.PendingIntent.getActivity;
import static android.support.design.widget.CoordinatorLayout.Behavior.getTag;

public class Form2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int mYear, mMonth, mDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);

//        Spinner spinner_family = (Spinner) findViewById(R.id.number_member_array);
// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter_family = ArrayAdapter.createFromResource(this,
//                R.array.no_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
//        adapter_family.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
//        spinner_family.setAdapter(adapter_family);

        //age = (EditText)findViewById(R.id.E_Age);
//        spinner_family.setOnItemSelectedListener(this);

//        Spinner spinner_male = (Spinner) findViewById(R.id.male_array);
// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter_male = ArrayAdapter.createFromResource(this,
//                R.array.no_array, android.R.layout.simple_spinner_item);
//// Specify the layout to use when the list of choices appears
//        adapter_male.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
//        spinner_male.setAdapter(adapter_male);

        //age = (EditText)findViewById(R.id.E_Age);
//        spinner_male.setOnItemSelectedListener(this);


//        Spinner spinner_female = (Spinner) findViewById(R.id.female_array);
//        ArrayAdapter<CharSequence> adapter_female = ArrayAdapter.createFromResource(this,
//                R.array.no_array, android.R.layout.simple_spinner_item);
//        adapter_female.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner_female.setAdapter(adapter_male);
//        spinner_female.setOnItemSelectedListener(this);


        final TextView date = (TextView)findViewById(R.id.E_Date);
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        if (mMonth+6<=12)
            mMonth = mMonth+6;
        else {
            mMonth = 12 - mMonth;
            mMonth = 6 - mMonth+1;
                    mYear = mYear+1;
        }

        //date.setText( mDay+ "-" + (mMonth) + "-" + mYear);
        final ImageButton calendar = (ImageButton)findViewById(R.id.calendar);
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(Form2.this,
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

        final Context context = this;

        final Button[] btn = new Button[1];

        ImageButton details = (ImageButton)findViewById(R.id.add);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Form2.this,Family_Details.class);
                startActivity(intent);

//                LinearLayout ll = (LinearLayout) findViewById(R.id.fam_Details);

                btn[0] = new Button(context);
                int iden = 1;
                //btn[0].setId(iden);
                //btn[0].setTag("button");
                btn[0].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//                ll.addView(btn[0]);


            }
        });

        /*Intent b_intent = getIntent();
        Bundle bundle = b_intent.getExtras();*/
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null )
        {
            String value = bundle.getString("Name");
            Integer id = bundle.getInt("id");
            if(value!="") {

                //Button b = (Button)findViewByTag();
                if(btn[0]!=null) {
                    btn[0].setText(value);
                }

            }
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}