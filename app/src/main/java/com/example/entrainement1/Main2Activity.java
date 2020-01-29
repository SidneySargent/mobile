package com.example.entrainement1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //popUp("onDestroy()");
    }

    @Override
    public void finish() {
        super.finish();
        //popUp("Finish()");
    }


    @Override
    public void onStart() {
        super.onStart();
        // popUp("onStart()");
        SharedPreferences settings = getSharedPreferences("cycle_vie_prefs", Context.MODE_PRIVATE);
        TextView textZone = (TextView) findViewById(R.id.textView1);
        textZone.setText(settings.getString("valeur",""));
        TextView textZone2 = (TextView) findViewById(R.id.textView2);
        textZone2.setText(settings.getString("valeur2",""));
    }

    @Override
    public void onResume(){
        super.onResume();
        //popUp("onResume()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        //popUp("onRestart()");
    }

    public void popUp(String text) {
        Toast.makeText(this,text+" from activity 2",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //popUp("onPause()");

    }
}
