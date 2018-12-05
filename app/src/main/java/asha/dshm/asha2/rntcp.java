package asha.dshm.asha2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import asha.dshm.asha2.Adapters.FamilyRecordAdapter;
import asha.dshm.asha2.Java.FamilyRecord;

public class rntcp extends AppCompatActivity {
    ArrayList<Rnctp_object> records;
    RecyclerView mFamilyRecords;
    rntcpAdapter madapter;
    LinearLayoutManager mLayoutManager;
    private static final int NUM_FORM_ITEMS = 100;
    SearchView searchView;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);
        records = new ArrayList<>();
        mFamilyRecords = (RecyclerView) findViewById(R.id.recycler_family);
        mLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mFamilyRecords.getContext(),
                mLayoutManager.getOrientation());
        mFamilyRecords.addItemDecoration(dividerItemDecoration);

        searchView = (SearchView) findViewById(R.id.search_v);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();


        String resp = "";
        madapter = new rntcpAdapter(this, records, NUM_FORM_ITEMS);
        mLayoutManager = new LinearLayoutManager(this);
        mFamilyRecords.setHasFixedSize(true);
        mFamilyRecords.setLayoutManager(mLayoutManager);
        mFamilyRecords.setItemAnimator(new DefaultItemAnimator());
        mFamilyRecords.setAdapter(madapter);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String resp1 = new RequestTask().sendPost("http://192.168.2.214:9555/rntcp/");
                    JSONArray array = new JSONArray(resp1);


                    for (int i = 0; i < array.length(); i++) {

                        JSONObject object = array.getJSONObject(i);
                        records.add(new Rnctp_object(object.getString("family_member_id"), object.getString("cough"), object.getString("fever"), object.getString("loss_of_appetite"), object.getString("blood_in_sputum"), object.getString("chest_pain"), object.getString("past_history"), object.getString("treatment_status")));

                    }

                    madapter.setFamilyRecordList(records);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            madapter.notifyDataSetChanged();
                            if (dialog.isShowing()) {
                                dialog.dismiss();
                            }

                        }
                    });
                } catch (Exception e) {
                    System.out.println("e = " + e);
                }


            }
        }).start();


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


}
