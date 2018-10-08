package asha.dshm.asha2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Form5 extends AppCompatActivity {

    RadioGroup treatmentStatusRadioGroup;
    RadioButton selectedRadioButton;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form5);

        treatmentStatusRadioGroup = (RadioGroup) findViewById(R.id.tb_Treatment_status);
        saveButton = (Button) findViewById(R.id.save_tb);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedID = treatmentStatusRadioGroup.getCheckedRadioButtonId();
                selectedRadioButton = (RadioButton) findViewById(selectedID);
                switch (selectedID) {
                    case R.id.tb_treat_complete: {

                        break;
                    }
                    case R.id.tb_treat_incomplete: {
                        inputReasons();
                        break;
                    }
                    case R.id.tb_treat_notstarted: {
                        inputReasons();
                        break;
                    }
                    case R.id.tb_treat_on: {
                        Intent intent = new Intent(Form5.this,treatment_details_form5.class);
                        startActivity(intent);

                        break;
                    }
                }
            }
        });

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

}
