package com.example.entrainement1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * Exécuté chaque fois que l'utilisateur clique sur l'icône de l'application pour une première fois.
     *
     * La fonction onCreate() est suivie d'un onStart().
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnvoyer = (Button) findViewById(R.id.btnEnvoyer);
        btnEnvoyer.setOnClickListener(btnEnvoyerOnClickListener);

        Button btnActiverAct = (Button) findViewById(R.id.btnAct2);
        btnActiverAct.setOnClickListener(btnRedirectOnClickListener);

        Button btnQuitter = (Button) findViewById(R.id.btnQuitter);
        btnQuitter.setOnClickListener(btnQuitterOnClickListener);
        popUp("onCreate()");
    }
    /** =============================================================
     * Exécuté que l'activité arrêtée via un "stop" redémarre.
     *
     * La fonction onRestart() est suivie de la fonction onStart().
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        popUp("onRestart()");
    }
    /** ==============================================================
     * Exécuté lorsque l'activité devient visible à l'utilisateur.
     *
     * La fonction onStart() est suivie de la fonction onResume().
     */
    @Override
    protected void onStart() {
        super.onStart();
        popUp("onStart()");
        SharedPreferences settings = getSharedPreferences("cycle_vie_prefs", Context.MODE_PRIVATE);
        setTxTValeur(settings.getString("valeur", ""),settings.getString("valeur2", ""));
    }
    /** ==============================================================
     * Exécutée à chaque passage en premier plan de l'activité.
     * Ou bien, si l'activité passe à nouveau en premier
     * (si une autre activité était passée en premier plan entre temps).
     *
     * La fonction onResume() est suivie de l'exécution de l'activité.
     */
    @Override
    protected void onResume() {
        super.onResume();
        popUp("onResume()");
        SharedPreferences settings = getSharedPreferences("cycle_vie_prefs", Context.MODE_PRIVATE);
        setTxTValeur(settings.getString("valeur", ""),settings.getString("valeur2", ""));
    }
    /** =============================================================
     * La fonction onPause() est suivie :
     * - d'un onResume() si l'activité passe à nouveau en premier plan
     * - d'un onStop() si elle devient invisible à l'utilisateur
     *
     * L'exécution de la fonction onPause() doit être rapide,
     * car la prochaine activité ne démarrera pas tant que l'exécution
     * de la fonction onPause() n'est pas terminée.
     */
    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            popUp("onPause, l'utilisateur à demandé la fermeture via un finish()");
        } else {
            popUp("onPause, l'utilisateur n'a pas demandé la fermeture via un finish()");
        }
        SharedPreferences settings = getSharedPreferences("cycle_vie_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("valeur", getTxtValeur());
        editor.commit();
    }
    /** ==============================================================
     * La fonction onStop() est exécutée :
     * - lorsque l'activité n'est plus en premier plan
     * - ou bien lorsque l'activité va être détruite
     *
     * Cette fonction est suivie :
     * - de la fonction onRestart() si l'activité passe à nouveau en premier plan
     * - de la fonction onDestroy() lorsque l'activité se termine
     *    ou bien lorsque le système décide de l'arrêter
     */
    @Override
    protected void onStop() {
        super.onStop();
        popUp("onStop()");
    }

    View.OnClickListener btnEnvoyerOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUp("valeur saisie = " + getTxtValeur());
        }
    };

    View.OnClickListener btnRedirectOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), Main2Activity.class);
            startActivity(intent);
        }
    };

    public String getTxtValeur() {
        EditText zoneValeur = (EditText) findViewById(R.id.editTxtValeur);
        return zoneValeur.getText().toString();
    }

    /** =============================================================
     * Cette fonction est exécutée lorsque l'activité se termine ou bien lorsque
     * le système décide de l'arrêter.
     *
     * La fonction onCreate() devra à nouveau être exécutée pour obtenir à nouveau l'activité.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        popUp("onDestroy()");
    }
    //=================================================================
    View.OnClickListener btnQuitterOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
    public void popUp(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


    public void setTxTValeur(String valeur, String valeur2) {
        EditText zoneValeur = (EditText) findViewById(R.id.editTxtValeur);
        zoneValeur.setText(valeur);
        EditText zoneValeur2 = (EditText) findViewById(R.id.editTxtValeur2);
        zoneValeur2.setText(valeur2);
    }

}
