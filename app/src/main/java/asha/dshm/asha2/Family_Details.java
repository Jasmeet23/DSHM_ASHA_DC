package asha.dshm.asha2;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Period;
import java.util.Calendar;

public class Family_Details extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int mYear, mMonth, mDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family__details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        final Spinner spinner_gender = (Spinner) findViewById(R.id.gender_array);
        ArrayAdapter<CharSequence> adapter_gender = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter_gender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_gender.setAdapter(adapter_gender);
        spinner_gender.setOnItemSelectedListener(this);


        final CheckBox immunisation = (CheckBox) findViewById(R.id.immunisation);
        final CheckBox nutrition = (CheckBox) findViewById(R.id.nutrition);
        final CheckBox pregnancy = (CheckBox) findViewById(R.id.pregnancy);
        final CheckBox nc = (CheckBox) findViewById(R.id.nc);
        final CheckBox visual = (CheckBox) findViewById(R.id.visual);
        final CheckBox rntcp = (CheckBox) findViewById(R.id.rntcp);
        final CheckBox disability = (CheckBox) findViewById(R.id.disability);
        final CheckBox mortality = (CheckBox) findViewById(R.id.mortality);
        immunisation.setVisibility(View.GONE);
        nutrition.setVisibility(View.GONE);
        pregnancy.setVisibility(View.GONE);
        nc.setVisibility(View.GONE);
        visual.setVisibility(View.GONE);
        rntcp.setVisibility(View.GONE);
        disability.setVisibility(View.GONE);
        mortality.setVisibility(View.GONE);

        final TextView problems = (TextView) findViewById(R.id.problems);
        problems.setVisibility(View.GONE);

        final Calendar c = Calendar.getInstance();
        final int cYear = c.get(Calendar.YEAR);
        final int cMonth = c.get(Calendar.MONTH) + 1;
        final int cDay = c.get(Calendar.DAY_OF_MONTH);

        final Context context = this;
        final int flag1 = 0, flag2 = 0;

        final TextView date = (TextView) findViewById(R.id.E_Date);
        date.setText("");
        final ImageButton calendar = (ImageButton) findViewById(R.id.calendar);
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(Family_Details.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                String dob = (String) date.getText();
                                System.out.println("Dob ::::::::::::: " + dob);
                                String yy[] = dob.split("-");
                                int yyr = Integer.parseInt(yy[2]);
                                int mmr = Integer.parseInt(yy[1]);
                                int ddr = Integer.parseInt(yy[0]);
                                int years = 0;
                                String ag = "";
                                if (cYear != yyr) {
                                    years = cYear - yyr;
                                    ag = years + " years";
                                } else {
                                    if (cMonth != mmr) {
                                        years = cMonth - mmr;
                                        ag = years + " months";
                                    } else {
                                        years = cDay - ddr;
                                        ag = years + " days";
                                    }
                                }
                                final TextView age = (TextView) findViewById(R.id.E_age);
                                age.setText(ag);


                                //final TextView age = (TextView) findViewById(R.id.E_age);
                                String temp = (String) age.getText();
                                if (temp != "") {

                                    problems.setVisibility(View.VISIBLE);
                                    nutrition.setVisibility(View.VISIBLE);
                                    visual.setVisibility(View.VISIBLE);
                                    rntcp.setVisibility(View.VISIBLE);
                                    disability.setVisibility(View.VISIBLE);
                                    mortality.setVisibility(View.VISIBLE);


                                    String[] tmp = temp.split(" ");
                                    int criteria = Integer.parseInt(tmp[0]);

                                    String sex = spinner_gender.getSelectedItem().toString();
                                    System.out.println("GENDER  :::  "+sex);

                                    if (criteria > 30) {
                                        nc.setVisibility(View.VISIBLE);
                                        immunisation.setVisibility(View.GONE);
                                        pregnancy.setVisibility(View.GONE);

                                    }
                                    if (criteria >= 1 && criteria <= 15) {
                                        immunisation.setVisibility(View.VISIBLE);
                                        nc.setVisibility(View.GONE);
                                        pregnancy.setVisibility(View.GONE);
                                    }
                                    if (criteria >= 19 && criteria <= 49 && sex.equalsIgnoreCase("Female")) {
                                        System.out.println("INSIDE.................");
                                        pregnancy.setVisibility(View.VISIBLE);
                                        nc.setVisibility(View.GONE);
                                        immunisation.setVisibility(View.GONE);
                                    }
                                    if(sex.equalsIgnoreCase("Male"))
                                    {
                                        pregnancy.setVisibility(View.GONE);
                                    }
                                }


                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();


            }
        });


        immunisation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Family_Details.this,Form6.class);
                startActivity(intent);

            }
        });

        rntcp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Family_Details.this,Form5.class);
                startActivity(intent);

            }
        });


        Spinner spinner_occupation = (Spinner) findViewById(R.id.occupation_array);
        ArrayAdapter<CharSequence> adapter_occupation = ArrayAdapter.createFromResource(this,
                R.array.occupation_array, android.R.layout.simple_spinner_item);
        adapter_occupation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_occupation.setAdapter(adapter_occupation);
        spinner_occupation.setOnItemSelectedListener(this);

        Spinner spinner_marital = (Spinner) findViewById(R.id.marital_array);
        ArrayAdapter<CharSequence> adapter_marital = ArrayAdapter.createFromResource(this,
                R.array.marital_array, android.R.layout.simple_spinner_item);
        adapter_marital.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_marital.setAdapter(adapter_marital);
        spinner_marital.setOnItemSelectedListener(this);


        final EditText name = (EditText) findViewById(R.id.E_name);
        final EditText sn = (EditText) findViewById(R.id.E_SN);


        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Family_Details.this, Form2.class);
                String nm = String.valueOf(name.getText());
                Bundle bundle = new Bundle();
                bundle.putString("Name", nm);
                String sno = String.valueOf(sn.getText());
                //Integer id = Integer.parseInt(sno);
                //bundle.putInt("id",id);
                intent.putExtras(bundle);

                //intent.putExtra("Name",name.getText());
                startActivity(intent);
            }
        });

        //String sex = spinner_gender.getSelectedItem().toString();


        AdapterView.OnItemSelectedListener mgender = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                final TextView age = (TextView) findViewById(R.id.E_age);
                //final TextView age = (TextView) findViewById(R.id.E_age);
                String temp = (String) age.getText();
                if(temp!="") {

                    String[] tmp = temp.split(" ");
                    int criteria = Integer.parseInt(tmp[0]);

                    String sex = spinner_gender.getSelectedItem().toString();
                    //Toast.makeText(context,sex,Toast.LENGTH_SHORT).show();
                    System.out.println("GENDER  :::  "+sex);

                    if (criteria >= 19 && criteria <= 49 && sex.equalsIgnoreCase("Female")) {
                        pregnancy.setVisibility(View.VISIBLE);
                        nc.setVisibility(View.GONE);
                        immunisation.setVisibility(View.GONE);
                    }
                    if(sex.equalsIgnoreCase("Male"))
                    {
                        pregnancy.setVisibility(View.GONE);
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };

        spinner_gender.setOnItemSelectedListener(mgender);


        /*View.OnTouchListener spinnerOnTouch = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    //Your code

                }
                return false;
            }
        };
        spinner_gender.setOnTouchListener(spinnerOnTouch);*/


        /*final RadioGroup gen = (RadioGroup)findViewById(R.id.gen);
        gen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                int selectedId = gen.getCheckedRadioButtonId();
// find the radiobutton by returned id
                 RadioButton selectedRadioButton = (RadioButton)findViewById(selectedId);
// do what you want with radioButtonText (save it to database in your case)
                String radioButtonText = selectedRadioButton.getText().toString();

                final TextView age = (TextView) findViewById(R.id.E_age);
                //final TextView age = (TextView) findViewById(R.id.E_age);
                String temp = (String) age.getText();
                if(temp!="") {

                    String[] tmp = temp.split(" ");
                    int criteria = Integer.parseInt(tmp[0]);

                    String sex = spinner_gender.getSelectedItem().toString();
                    Toast.makeText(context,sex,Toast.LENGTH_SHORT).show();
                    System.out.println("GENDER  :::  "+radioButtonText);

                    if (criteria >= 20 && criteria <= 35 && radioButtonText == "Female") {
                        pregnancy.setVisibility(View.VISIBLE);
                        nc.setVisibility(View.GONE);
                        immunisation.setVisibility(View.GONE);
                    }
                }


            }
        });*/

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
}
