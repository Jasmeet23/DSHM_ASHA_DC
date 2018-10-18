package asha.dshm.asha2;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import asha.dshm.asha2.Adapters.PossibleDiseaseAdapter;

public class Family_Details
        extends AppCompatActivity
        implements PossibleDiseaseAdapter.ListItemClickListener, AdapterView.OnItemSelectedListener {

    private int mYear, mMonth, mDay;
    private static final int NUM_FORM_ITEMS = 100;
    private RecyclerView mDiseasesRecyclerView;
    private List<String> diseaseList;
    private PossibleDiseaseAdapter adapter;
    private TextView problems;
    LinearLayoutManager mLayoutManager;
    private Parcelable recyclerViewState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family__details);
        final Spinner spinner_gender = (Spinner) findViewById(R.id.gender_array);
        ArrayAdapter<CharSequence> adapter_gender = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter_gender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_gender.setAdapter(adapter_gender);
        spinner_gender.setOnItemSelectedListener(this);

//        prepareList();
        problems = (TextView) findViewById(R.id.problems);
        problems.setVisibility(View.GONE);
        final Calendar c = Calendar.getInstance();
        final int cYear = c.get(Calendar.YEAR);
        final int cMonth = c.get(Calendar.MONTH) + 1;
        final int cDay = c.get(Calendar.DAY_OF_MONTH);
        final Context context = this;
        final int flag1 = 0, flag2 = 0;
        diseaseList = new ArrayList<>();
        diseaseList.add("rntcp");
        diseaseList.add("Immunisation");
        diseaseList.add("mahika");
        final TextView date = (TextView) findViewById(R.id.E_Date);
        date.setText("");
        final ImageButton calendar = (ImageButton) findViewById(R.id.calendar);
        adapter = new PossibleDiseaseAdapter(diseaseList, this, NUM_FORM_ITEMS, diseaseList);
        mDiseasesRecyclerView = (RecyclerView) findViewById(R.id.recycler_disease);
        mLayoutManager = new LinearLayoutManager(this);
        mDiseasesRecyclerView.setHasFixedSize(true);
        mDiseasesRecyclerView.setLayoutManager(mLayoutManager);
        mDiseasesRecyclerView.setNestedScrollingEnabled(false);
        mDiseasesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mDiseasesRecyclerView.setAdapter(adapter);
        recyclerViewState = mDiseasesRecyclerView.getLayoutManager().onSaveInstanceState();


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
                                Log.d("AGE", ag);
                                age.setText(ag);

                                String temp = (String) age.getText();
                                if (temp != "") {
                                    Log.d("AGE", "entered");
                                    problems.setVisibility(View.VISIBLE);
                                    diseaseList.add("Nutrition");
                                    diseaseList.add("Visual");
                                    diseaseList.add("rntcp");
                                    diseaseList.add("Disability");
                                    diseaseList.add("Mortalility");

//                                    printing(diseaseList);
                                    String[] tmp = temp.split(" ");
                                    int criteria = Integer.parseInt(tmp[0]);

                                    String sex = spinner_gender.getSelectedItem().toString();
                                    System.out.println("GENDER  :::  " + sex);

                                    if (criteria > 30) {
                                        int pos = searchString(diseaseList, "nc");
                                        if (pos == -1) {
                                            diseaseList.add("nc");
                                        }
//                                        adapter.notifyDataSetChanged();
//                                        printing(diseaseList);
                                    }
                                    if (criteria >= 1 && criteria <= 15) {
                                        int pos = searchString(diseaseList, "Immunisation");
                                        if (pos == -1) {
                                            diseaseList.add("Immunisation");
                                        }
//                                        adapter.notifyDataSetChanged();
//                                        printing(diseaseList);
                                        pos = searchString(diseaseList, "nc");
                                        if (pos != -1) {
                                            diseaseList.remove(pos);
//                                            printing(diseaseList);

                                        }
                                    }
                                    if (criteria >= 19 && criteria <= 49 && sex.equalsIgnoreCase("Female")) {
                                        System.out.println("INSIDE.................");
                                        int pos = searchString(diseaseList, "Pregnancy");
                                        if (pos == -1) {
                                            diseaseList.add("Pregnancy");
                                        }
//                                        printing(diseaseList);
                                        pos = searchString(diseaseList, "nc");
                                        if (pos != -1) {
                                            diseaseList.remove(pos);
//                                            adapter.notifyDataSetChanged();

//                                            printing(diseaseList);
                                        }
                                        pos = searchString(diseaseList, "Immunisation");
                                        if (pos != -1) {
                                            diseaseList.remove(pos);
//                                            adapter.notifyDataSetChanged();

//                                            printing(diseaseList);
                                        }
                                    }
                                    if (sex.equalsIgnoreCase("Male")) {
                                        int pos = searchString(diseaseList, "Pregnancy");
                                        if (pos != -1) {
                                            diseaseList.remove(pos);
//                                            adapter.notifyDataSetChanged();

//                                            printing(diseaseList);
                                        }
                                    }
                                }


                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();

            }
        });
//        adapter=new PossibleDiseaseAdapter(diseaseList, this, NUM_FORM_ITEMS, diseaseList);
        Log.d("new list", "heere");
        printing(diseaseList);
        adapter.update(diseaseList);
        mDiseasesRecyclerView.getLayoutManager().onRestoreInstanceState(recyclerViewState);

//        mDiseasesRecyclerView.setAdapter(adapter);
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
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        AdapterView.OnItemSelectedListener mgender = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                final TextView age = (TextView) findViewById(R.id.E_age);
                String temp = (String) age.getText();
                if (temp != "") {

                    String[] tmp = temp.split(" ");
                    int criteria = Integer.parseInt(tmp[0]);

                    String sex = spinner_gender.getSelectedItem().toString();
                    System.out.println("GENDER  :::  " + sex);

                    if (criteria >= 19 && criteria <= 49 && sex.equalsIgnoreCase("Female")) {
                        diseaseList.add("Pregnancy");
                        int pos = searchString(diseaseList, "nc");
                        if (pos != -1) {
                            diseaseList.remove(pos);
                            printing(diseaseList);
                        }
                        pos = searchString(diseaseList, "Immunisation");
                        if (pos != -1) {
                            diseaseList.remove(pos);
                            printing(diseaseList);
                        }
                    }
                    if (sex.equalsIgnoreCase("Male")) {
                        int pos = searchString(diseaseList, "Pregnancy");
                        if (pos != -1) {
                            diseaseList.remove(pos);
                            printing(diseaseList);
                        }
                    }
                }
                adapter.update(diseaseList);
                mDiseasesRecyclerView.getLayoutManager().onRestoreInstanceState(recyclerViewState);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };

        spinner_gender.setOnItemSelectedListener(mgender);

    }

    private void printing(List<String> diseaseList) {

        for (int k = 0; k < diseaseList.size(); k++) {
            Log.d("D", diseaseList.get(k));
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onListItemClick(View v, int clickedListItem) {
        Intent intent;
        String disease = diseaseList.get(clickedListItem);
        switch (disease) {
            case "Immunisation": {
                intent = new Intent(Family_Details.this, Form6.class);
                startActivity(intent);
                break;
            }
            case "rntcp": {
                intent = new Intent(Family_Details.this, Form6.class);
                startActivity(intent);
                break;
            }

        }


    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private int searchString(List<String> l, String a) {
        for (int m = 0; m < l.size(); m++) {
            if (a.equals(l.get(m))) {
                return m;
            }
        }
        return -1;
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
//    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
//
//        private int spanCount;
//        private int spacing;
//        private boolean includeEdge;
//
//        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
//            this.spanCount = spanCount;
//            this.spacing = spacing;
//            this.includeEdge = includeEdge;
//        }
//
//        @Override
//        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//            int position = parent.getChildAdapterPosition(view); // item position
//            int column = position % spanCount; // item column
//
//            if (includeEdge) {
//                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
//                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)
//
//                if (position < spanCount) { // top edge
//                    outRect.top = spacing;
//                }
//                outRect.bottom = spacing; // item bottom
//            } else {
//                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
//                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
//                if (position >= spanCount) {
//                    outRect.top = spacing; // item top
//                }
//            }
//        }
//    }


}
