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

        if(savedInstanceState != null){
            String pseudo = savedInstanceState.getString("cle");
            String mdp = savedInstanceState.getString("cle2");
            EditText txt = (EditText) findViewById(R.id.editTxtValeur);
            txt.setText(pseudo);
            EditText tx = (EditText) findViewById(R.id.editTxtValeur2);
            tx.setText(mdp);
        }
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


    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        popUp("SAVEINSTANCE");
        EditText edit = (EditText) findViewById(R.id.editTxtValeur);
        popUp(edit.getText().toString());
        savedInstanceState.putString("cle", edit.getText().toString());

        EditText edit2 = (EditText) findViewById(R.id.editTxtValeur2);
        popUp(edit2.getText().toString());
        savedInstanceState.putString("cle2", edit.getText().toString());
    }
}
