package com.example.listeplanetes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listview;
    PlaneteAdapter adapter;

    Button envoyer = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        popUp("init");
        listview = (ListView) findViewById(R.id.listView);
        adapter = new PlaneteAdapter((LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE), MainActivity.this);
        listview.setAdapter(adapter);

        envoyer = (Button)findViewById(R.id.Validation);
        envoyer.setOnClickListener(checkedListener);
    }

    private View.OnClickListener checkedListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if(adapter.Verification()) {
                popUp("Ok");
            }
            else {
                popUp("Pas ok");
            }
        }
    };

    public void popUp(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
