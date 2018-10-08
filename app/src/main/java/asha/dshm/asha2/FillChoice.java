package asha.dshm.asha2;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FillChoice extends AppCompatActivity implements View.OnClickListener {

    Button regNew, update, reSurvey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_choice);

        regNew= (Button)findViewById(R.id.regNew);
        update= (Button)findViewById(R.id.updateOld);
        reSurvey= (Button)findViewById(R.id.reSurvey);
        regNew.setOnClickListener(this);
        update.setOnClickListener(this);
        reSurvey.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.regNew:
            {
                Intent newReg= new Intent(this, Form3.class);
                startActivity(newReg);
            }

        }

    }
}
