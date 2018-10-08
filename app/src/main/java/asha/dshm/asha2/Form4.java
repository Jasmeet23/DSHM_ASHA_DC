package asha.dshm.asha2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Form4 extends AppCompatActivity implements View.OnClickListener {

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form4);

        next= (Button) findViewById(R.id .save);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.save:
            {
                Intent nextIntent= new Intent(this, Form2.class);
                startActivity(nextIntent);
            }
        }
    }
}
