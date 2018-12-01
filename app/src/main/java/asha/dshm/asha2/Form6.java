package asha.dshm.asha2;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Calendar;

public class Form6 extends AppCompatActivity implements View.OnClickListener {

    EditText e11, e12, e21, e22, e31, e32, e41, e42, e51, e52, e61, e62, e71, e72, e81, e82, e91, e92, e101, e102, e111, e112;
    ImageButton c11, c12, c21, c22, c31, c32, c41, c42, c51, c52, c61, c62, c71, c72, c81, c82, c91, c92, c101, c102, c111, c112;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form6);
        e11 = (EditText) findViewById(R.id.e11);
        e12 = (EditText) findViewById(R.id.e12);
        e21 = (EditText) findViewById(R.id.e21);
        e22 = (EditText) findViewById(R.id.e22);
        e31 = (EditText) findViewById(R.id.e31);
        e32 = (EditText) findViewById(R.id.e32);
        e41 = (EditText) findViewById(R.id.e41);
        e42 = (EditText) findViewById(R.id.e42);
        e51 = (EditText) findViewById(R.id.e51);
        e52 = (EditText) findViewById(R.id.e52);
        e61 = (EditText) findViewById(R.id.e61);
        e62 = (EditText) findViewById(R.id.e62);
        e71 = (EditText) findViewById(R.id.e71);
        e72 = (EditText) findViewById(R.id.e72);
        e81 = (EditText) findViewById(R.id.e81);
        e82 = (EditText) findViewById(R.id.e82);
        e91 = (EditText) findViewById(R.id.e91);
        e92 = (EditText) findViewById(R.id.e92);
        e101 = (EditText) findViewById(R.id.e101);
        e102 = (EditText) findViewById(R.id.e102);
        e111 = (EditText) findViewById(R.id.e111);
        e112 = (EditText) findViewById(R.id.e112);
        c11 = (ImageButton) findViewById(R.id.calendar11);
        c12 = (ImageButton) findViewById(R.id.calendar12);
        c21 = (ImageButton) findViewById(R.id.calendar21);
        c22 = (ImageButton) findViewById(R.id.calendar22);
        c31 = (ImageButton) findViewById(R.id.calendar31);
        c32 = (ImageButton) findViewById(R.id.calendar32);
        c41 = (ImageButton) findViewById(R.id.calendar41);
        c42 = (ImageButton) findViewById(R.id.calendar42);
        c51 = (ImageButton) findViewById(R.id.calendar51);
        c52 = (ImageButton) findViewById(R.id.calendar52);
        c61 = (ImageButton) findViewById(R.id.calendar61);
        c62 = (ImageButton) findViewById(R.id.calendar62);
        c71 = (ImageButton) findViewById(R.id.calendar71);
        c72 = (ImageButton) findViewById(R.id.calendar72);
        c81 = (ImageButton) findViewById(R.id.calendar81);
        c82 = (ImageButton) findViewById(R.id.calendar82);
        c91 = (ImageButton) findViewById(R.id.calendar91);
        c92 = (ImageButton) findViewById(R.id.calendar92);
        c101 = (ImageButton) findViewById(R.id.calendar101);
        c102 = (ImageButton) findViewById(R.id.calendar102);
        c111 = (ImageButton) findViewById(R.id.calendar111);
        c112 = (ImageButton) findViewById(R.id.calendar112);

        c11.setOnClickListener(this);
        c12.setOnClickListener(this);
        c21.setOnClickListener(this);
        c22.setOnClickListener(this);
        c31.setOnClickListener(this);
        c32.setOnClickListener(this);
        c41.setOnClickListener(this);
        c42.setOnClickListener(this);
        c51.setOnClickListener(this);
        c52.setOnClickListener(this);
        c61.setOnClickListener(this);
        c62.setOnClickListener(this);
        c71.setOnClickListener(this);
        c72.setOnClickListener(this);
        c81.setOnClickListener(this);
        c82.setOnClickListener(this);
        c91.setOnClickListener(this);
        c92.setOnClickListener(this);
        c101.setOnClickListener(this);
        c102.setOnClickListener(this);
        c111.setOnClickListener(this);
        c112.setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(Form6.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        if(v.getId()==R.id.calendar11)
                            e11.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar12)
                            e12.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar21)
                            e21.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar22)
                            e22.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar31)
                            e31.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar32)
                            e32.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar41)
                            e41.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar42)
                            e42.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar51)
                            e51.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar52)
                            e52.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar61)
                            e61.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar62)
                            e62.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar71)
                            e71.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar72)
                            e72.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar81)
                            e81.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar82)
                            e82.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar91)
                            e91.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar92)
                            e92.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar101)
                            e101.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar102)
                            e102.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar111)
                            e111.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        else if(v.getId()==R.id.calendar111)
                            e112.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);


                    }
                }, mYear, mMonth, mDay);
        if(v.getId()==R.id.calendar11 || v.getId()==R.id.calendar21 || v.getId()==R.id.calendar31 || v.getId()==R.id.calendar41 || v.getId()==R.id.calendar51 || v.getId()==R.id.calendar61 || v.getId()==R.id.calendar71 || v.getId()==R.id.calendar81 || v.getId()==R.id.calendar91 || v.getId()==R.id.calendar101 || v.getId()==R.id.calendar111)
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() - 1000);
        else
            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();


    }
}
