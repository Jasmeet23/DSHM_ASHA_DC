package asha.dshm.asha2;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;

public class Form6 extends AppCompatActivity {

    ImageButton calendarbcg, calendardpt, calendardpt2, calendardpt3, calendarmea, calendarmmr, calendardptb, calendartyp, calendardptb2, calendarvit, calendartet;
    ImageButton calendarbcgd, calendardptd, calendardpt2d, calendardpt3d, calendarmead, calendarmmrd, calendardptbd, calendartypd, calendardptb2d, calendarvitd, calendartetd;
    TextView datebcg, datedpt, datedpt2, datedpt3, datemea, datemmr, datedptb, datetyp, datedptb2, datevit, datetet;
    TextView datebcgd, datedptd, datedpt2d, datedpt3d, datemead, datemmrd, datedptbd, datetypd, datedptb2d, datevitd, datetetd;

    private int mYear, mMonth, mDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form6);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        calendarbcg = (ImageButton) findViewById(R.id.calendar_bcg);
        calendardpt = (ImageButton) findViewById(R.id.calendardpt);
        calendardpt2 = (ImageButton) findViewById(R.id.calendardpt2);
        calendardpt3 = (ImageButton) findViewById(R.id.calendardpt3);
        calendarmea = (ImageButton) findViewById(R.id.calendarmea);
        calendarmmr = (ImageButton) findViewById(R.id.calendarmmr);
        calendardptb = (ImageButton) findViewById(R.id.calendardptb);
        calendartyp = (ImageButton) findViewById(R.id.calendartyp);
        calendardptb2 = (ImageButton) findViewById(R.id.calendardptb2);
        calendarvit = (ImageButton) findViewById(R.id.calendarvit);
        calendartet = (ImageButton) findViewById(R.id.calendartet);
        datebcg = (TextView) findViewById(R.id.E_Date_bcg);
        datedpt = (TextView) findViewById(R.id.E_Datedpt);
        datedpt2 = (TextView) findViewById(R.id.E_Datedpt2);
        datedpt3 = (TextView) findViewById(R.id.E_Datedpt3);
        datemea = (TextView) findViewById(R.id.E_Datemea);
        datemmr = (TextView) findViewById(R.id.E_Datemmr);
        datedptb = (TextView) findViewById(R.id.E_Datedptb);
        datevit = (TextView) findViewById(R.id.E_Datevit);
        datetet = (TextView) findViewById(R.id.E_Datetet);
        datetyp = (TextView) findViewById(R.id.E_Datetyp);
        datedptb2 = (TextView) findViewById(R.id.E_Datedptb2);
        calendarbcg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datebcg);
            }
        });
        calendardpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datedpt);
            }
        });
        calendardpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datedpt2);
            }
        });
        calendardpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datedpt3);
            }
        });
        calendarmea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datemea);
            }
        });
        calendarmmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datemmr);
            }
        });
        calendardptb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datedptb);
            }
        });
        calendartyp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datetyp);
            }
        });
        calendardptb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datedpt2);
            }
        });
        calendarvit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datevit);
            }
        });
        calendartet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datetet);
            }
        });
        calendarbcgd = (ImageButton) findViewById(R.id.calendar_bcgd);
        calendardptd = (ImageButton) findViewById(R.id.calendardptd);
        calendardpt2d = (ImageButton) findViewById(R.id.calendardpt2d);
        calendardpt3d = (ImageButton) findViewById(R.id.calendardpt3d);
        calendarmead = (ImageButton) findViewById(R.id.calendarmead);
        calendarmmrd = (ImageButton) findViewById(R.id.calendarmmrd);
        calendardptbd = (ImageButton) findViewById(R.id.calendardptbd);
        calendartypd = (ImageButton) findViewById(R.id.calendartypd);
        calendardptb2d = (ImageButton) findViewById(R.id.calendardptb2d);
        calendarvitd = (ImageButton) findViewById(R.id.calendarvitd);
        calendartetd = (ImageButton) findViewById(R.id.calendartetd);
        datebcgd = (TextView) findViewById(R.id.E_Date_bcgd);
        datedptd = (TextView) findViewById(R.id.E_Datedptd);
        datedpt2d = (TextView) findViewById(R.id.E_Datedpt2d);
        datedpt3d = (TextView) findViewById(R.id.E_Datedpt3d);
        datemead = (TextView) findViewById(R.id.E_Datemead);
        datemmrd = (TextView) findViewById(R.id.E_Datemmrd);
        datedptbd = (TextView) findViewById(R.id.E_Datedptbd);
        datevitd = (TextView) findViewById(R.id.E_Datevitd);
        datetetd = (TextView) findViewById(R.id.E_Datetetd);
        datetypd = (TextView) findViewById(R.id.E_Datetypd);
        datedptb2d = (TextView) findViewById(R.id.E_Datedptb2d);
        calendarbcgd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datebcgd);
            }
        });
        calendardptd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datedptd);
            }
        });
        calendardpt2d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datedpt2d);
            }
        });
        calendardpt3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datedpt3d);
            }
        });
        calendarmead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datemead);
            }
        });
        calendarmmrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datemmrd);
            }
        });
        calendardptbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datedptbd);
            }
        });
        calendartypd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datetypd);
            }
        });
        calendardptb2d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datedpt2d);
            }
        });
        calendarvitd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datevitd);
            }
        });
        calendartetd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCalendarEntries(datetetd);
            }
        });

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

    public void setCalendarEntries(final TextView dateText){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(Form6.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        dateText.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();

    }
}
