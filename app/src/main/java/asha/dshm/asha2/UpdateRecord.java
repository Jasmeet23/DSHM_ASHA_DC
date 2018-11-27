package asha.dshm.asha2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;

import asha.dshm.asha2.Adapters.FamilyRecordAdapter;
import asha.dshm.asha2.Java.FamilyMember;
import asha.dshm.asha2.Java.FamilyRecord;

public class UpdateRecord extends AppCompatActivity {
    ArrayList<FamilyRecord> records;
    RecyclerView mFamilyRecords;
    FamilyRecordAdapter madapter;
    LinearLayoutManager mLayoutManager;
    private static final int NUM_FORM_ITEMS = 100;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);
        records = new ArrayList<>();
        mFamilyRecords = (RecyclerView)findViewById(R.id.recycler_family);
        searchView=(SearchView)findViewById(R.id.search_v);
        records.add(new FamilyRecord("ashaname1",
                "anmname1",
                "110002",
                new FamilyMember("Subhash Sharma"),
                "addressxyz, New delhi",
                "12"));
        records.add(new FamilyRecord("ashaname2",
                "anmname2",
                "110004",
                new FamilyMember("Om Gupta"),
                "addressxyz, New delhi",
                "11"));

        madapter = new FamilyRecordAdapter(this, records, NUM_FORM_ITEMS);
        mLayoutManager = new LinearLayoutManager(this);
        mFamilyRecords.setHasFixedSize(true);
        mFamilyRecords.setLayoutManager(mLayoutManager);
        mFamilyRecords.setItemAnimator(new DefaultItemAnimator());
        mFamilyRecords.setAdapter(madapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE
                madapter.getFilter().filter(query);
                return false;
            }
        });


    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
