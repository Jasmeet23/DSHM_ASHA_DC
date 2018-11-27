package asha.dshm.asha2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class FillChoice extends AppCompatActivity implements View.OnClickListener {

    Button regNew, update, reSurvey;
    static String lan = "en_US";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_choice);

        regNew = (Button) findViewById(R.id.regNew);
        update = (Button) findViewById(R.id.updateOld);
        reSurvey = (Button) findViewById(R.id.reSurvey);
        regNew.setOnClickListener(this);
        update.setOnClickListener(this);
        reSurvey.setOnClickListener(this);
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
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
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
                Intent intent = new Intent(this, UpdateRecord.class);
                startActivity(intent);
                break;
            }

        }

    }
}
