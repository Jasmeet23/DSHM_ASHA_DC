package asha.dshm.asha2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.widget.TextView;

import java.util.Locale;

public class FillChoice extends AppCompatActivity implements View.OnClickListener {

    TextView regNew, update, reSurvey, rntcp;
    static String lan = "en_US";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_choice);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        regNew = (TextView) findViewById(R.id.regNew);
        update = (TextView) findViewById(R.id.updateOld);
        reSurvey = (TextView) findViewById(R.id.reSurvey);
        rntcp = (TextView) findViewById(R.id.rntcpShow);
        regNew.setOnClickListener(this);
        update.setOnClickListener(this);
        reSurvey.setOnClickListener(this);
        rntcp.setOnClickListener(this);
        Intent intent = getIntent();
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        String lan = settings.getString("LANG", "en");
        Configuration config = getBaseContext().getResources().getConfiguration();
        if (!Locale.getDefault().toString().equals(lan)) {

            System.out.println("not changed to  " + lan);
            setLangRecreate(lan);

        }

        String lang = settings.getString("LANG", lan);
        if (!"".equals(lang) && !config.locale.getLanguage().equals(lang)) {
            Locale locale = new Locale(lang);
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }
    }

    private void setLangRecreate(String langval) {
        Configuration config = getBaseContext().getResources().getConfiguration();
        Locale locale = new Locale(langval);
        Locale.setDefault(locale);
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
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
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.regNew: {
                Intent intent = new Intent(this, Form3.class);
                startActivity(intent);
                //get family ID from server, store in global variable
                break;
            }
            case R.id.reSurvey: {
                Intent intent = new Intent(this, Resurvey.class);
                startActivity(intent);
                break;
            }
            case R.id.rntcpShow: {
                Intent intent = new Intent(this, rntcp.class);
                startActivity(intent);
                break;
            }

        }

    }
}
