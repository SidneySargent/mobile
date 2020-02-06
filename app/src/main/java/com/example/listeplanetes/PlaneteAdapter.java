package com.example.listeplanetes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaneteAdapter extends BaseAdapter{

    private ArrayList<String> planetes;
    private LayoutInflater MainActivity;
    private Context context;
    private Data data;

    private int nbreCheck;


        public PlaneteAdapter(LayoutInflater MainActivity, Context context) {
            this.MainActivity = MainActivity;
            this.context = context;
            data = new Data();
            planetes = data.planetes;

        }

        @Override
        public int getCount() {
            return planetes.size();
        }

        @Override
        public Object getItem(int arg0) {
            return planetes.get(arg0);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) MainActivity;
                itemView = inflater.inflate(R.layout.listitem, null);
            }

            TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
            final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
            final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);

            nomPlanete.setText(planetes.get(position));

            //  installer l'adaptateur pour la liste déroulante (spinner)

            final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(this.context, android.R.layout.simple_spinner_item, data.taillePlanetes);
            spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(spinadapter);

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    CheckBox checkBox = (CheckBox) compoundButton.findViewById(R.id.checkbox);
                    spinner.setEnabled(!checkBox.isChecked());
                    spinadapter.notifyDataSetChanged();
                    if(checkBox.isChecked()) {
                        nbreCheck++;
                    }
                    else if(!checkBox.isChecked()) {
                        nbreCheck--;
                    }
                }
            });

            return itemView;
        }

        public boolean Verification() {
            if(nbreCheck==9) {
                return true;
            }else{
                return false;
            }
        }
}
