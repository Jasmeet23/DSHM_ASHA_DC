package asha.dshm.asha2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

import asha.dshm.asha2.Login.LoginActivity;

public class ChangeLanguage extends AppCompatActivity implements View.OnClickListener {



    private static final String SELECTED_ITEM_POSITION = "ItemPosition";
    private int mPosition;
    private static Locale l;
    private String lan;
    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);

        System.out.println("lang save    "+Locale.getDefault());
        // Save the state of item position
        outState.putInt(SELECTED_ITEM_POSITION, mPosition);
        // outState.putString(l,lan);
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
        System.out.println("lang restore    "+Locale.getDefault());


    }
    static String language="en";
    Button hin;
    TextView t;
    Button eng;
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        switch (id) {
//            case R.id.action_about:
//            {
//                Intent intent = new Intent(this, A1_MT17003_about.class);
//                int message = R.string.A1_MT17003_about;
//                intent.putExtra("em", message);
//                intent.putExtra("la", language);
//                startActivity(intent);
//                return true;
//            }
//            case R.id.action_admission:
//            {
//                Intent intent = new Intent(this, A1_MT17003_about.class);
//                int message = R.string.adm;
//                intent.putExtra("em", message);
//                startActivity(intent);
//                return true;
//            }
//            case R.id.action_programs:
//            {
//                Intent intent = new Intent(this, A1_MT17003_about.class);
//                startActivity(intent);
//
//                return true;
//            }
//            case R.id.action_change_language:
//            {
//                Intent intent = new Intent(this, A1_MT17003_Language.class);
//                startActivity(intent);
//                return true;
//            }
//
//            //similarly write for other actions
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_language);
        //l=Locale.getDefault();
        System.out.println("lang create    "+ Locale.getDefault());
        hin=(Button) findViewById(R.id.button2);
        eng=(Button) findViewById(R.id.button);
        t=(TextView) findViewById(R.id.txt);
        hin.setOnClickListener(ChangeLanguage.this);
        eng.setOnClickListener(ChangeLanguage.this);
        hin.setText(R.string.hin);
        t.setText(R.string.title);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        String lang = settings.getString("LANG","en");
        Configuration config = getBaseContext().getResources().getConfiguration();
        System.out.println("abx  "+lang);
        if(!Locale.getDefault().toString().equals(lang))
        {

            System.out.println("not changed to  "+lang);
            setLangRecreate(language);

        }

        //String lang = settings.getString("LANG", language);
        if (! "".equals(lang) && ! config.locale.getLanguage().equals(lang)) {
            Locale locale = new Locale(lang);
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button:
            {
                language="en";
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "en").commit();
                setLangRecreate("en");
//                preferences.edit().putString("lang", "en").commit();
                Intent intent = new Intent(this, LoginActivity.class);
//                intent.putExtra("la", language);
                startActivity(intent);
                break;
            }
            case R.id.button2:
            {
                language="hi";
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "hi").commit();
                setLangRecreate("hi");
                Intent intent = new Intent(this, LoginActivity.class);
//                intent.putExtra("la", language);
                startActivity(intent);
                break;
            }
            default:
            {
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "en").commit();
                setLangRecreate("en");
                break;
            }
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
}


