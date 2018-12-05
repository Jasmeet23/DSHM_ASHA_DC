package asha.dshm.asha2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Form5 extends AppCompatActivity {

    RadioGroup treatmentStatusRadioGroup;
    RadioButton selectedRadioButton;
    Button saveButton;

    RadioGroup c, f, l, b, chest, p; //Signifies all radio diseases
    RadioButton c_b, f_b, l_b, b_b, chest_b, p_b; //Signifies all radio diseases

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form5);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        c = (RadioGroup) findViewById(R.id.cough);
        f = (RadioGroup) findViewById(R.id.fever);
        l = (RadioGroup) findViewById(R.id.appetite);
        b = (RadioGroup) findViewById(R.id.sputum);
        chest = (RadioGroup) findViewById(R.id.chestpain);
        p = (RadioGroup) findViewById(R.id.tb_history);

        treatmentStatusRadioGroup = (RadioGroup) findViewById(R.id.tb_Treatment_status);
        saveButton = (Button) findViewById(R.id.save_tb);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int treatment_status =1;

                int selectedID = treatmentStatusRadioGroup.getCheckedRadioButtonId();
                selectedRadioButton = (RadioButton) findViewById(selectedID);

                int selected_c = c.getCheckedRadioButtonId();
                int selected_f = f.getCheckedRadioButtonId();
                int selected_l = l.getCheckedRadioButtonId();
                int selected_b = b.getCheckedRadioButtonId();
                int selected_chest = chest.getCheckedRadioButtonId();
                int selected_p = p.getCheckedRadioButtonId();

                c_b = (RadioButton) findViewById(selected_c);
                f_b = (RadioButton) findViewById(selected_f);
                l_b = (RadioButton) findViewById(selected_l);
                b_b = (RadioButton) findViewById(selected_b);
                chest_b = (RadioButton) findViewById(selected_chest);
                p_b = (RadioButton) findViewById(selected_p);


                switch (selectedID) {
                    case R.id.tb_treat_complete: {
                        treatment_status = 1;
                        break;
                    }
                    case R.id.tb_treat_incomplete: {
                        treatment_status = 1;

                        inputReasons();
                        treatment_status = 2;

                        break;
                    }
                    case R.id.tb_treat_notstarted: {
                        treatment_status = 3;

                        inputReasons();

                        break;
                    }
                    case R.id.tb_treat_on: {
                        treatment_status = 4;

                        Intent intent = new Intent(Form5.this, treatment_details_form5.class);
                        startActivity(intent);

                        break;
                    }
                }

                final int finalTreatment_status = treatment_status;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            URL url = new URL("http://192.168.2.214:9555/rntcp/");
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setRequestMethod("POST");
                            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                            conn.setRequestProperty("Accept", "application/json");
                            conn.setDoOutput(true);
                            conn.setDoInput(true);

                            JSONObject jsonParam = new JSONObject();
                            jsonParam.put("family_member_id", "50");
                            jsonParam.put("cough", getIntchoice(String.valueOf(c_b.getText())));
                            jsonParam.put("fever", getIntchoice(String.valueOf(c_b.getText())));
                            jsonParam.put("loss_of_appetite", getIntchoice(String.valueOf(c_b.getText())));
                            jsonParam.put("blood_in_sputum", getIntchoice(String.valueOf(c_b.getText())));
                            jsonParam.put("chest_pain", getIntchoice(String.valueOf(c_b.getText())));
                            jsonParam.put("past_history", getIntchoice(String.valueOf(c_b.getText())));
                            jsonParam.put("treatment_status", finalTreatment_status);

                            Log.i("JSON", jsonParam.toString());
                            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                            os.writeBytes(jsonParam.toString());

                            os.flush();
                            os.close();
                            System.out.println(conn.getResponseMessage() + "   " + conn.getResponseCode());


                            conn.disconnect();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                }).start();

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

    public void inputReasons() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.reason_form5, null);
        dialogBuilder.setView(dialogView);

        final EditText edt = (EditText) dialogView.findViewById(R.id.edit1);
        dialogBuilder.setTitle("Reasons");
        dialogBuilder.setMessage("Enter reasons below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public int getIntchoice(String choice) {
        if (choice.equals("Yes")) {
            return 1;
        } else {
            return 2;
        }
    }

}
