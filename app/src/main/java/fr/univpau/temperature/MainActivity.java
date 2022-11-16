package fr.univpau.temperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText valeur_source;
    private EditText valeur_cible;
    private Spinner mSpinner_source;
    private Spinner mSpinner_cible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valeur_source = findViewById(R.id.valeur_source);
        valeur_cible = findViewById(R.id.valeur_cible);
        mSpinner_source = findViewById(R.id.spinner_source);
        mSpinner_cible = findViewById(R.id.spinner_cible);
        Button convertbtn = findViewById(R.id.convertir);

        convertbtn.setEnabled(false);
        convertbtn.setOnClickListener(this);

        valeur_source.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // This is where we'll check the user input
                convertbtn.setEnabled(!s.toString().isEmpty());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG", "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG", "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "onDestroy()");
    }

    @Override
    public void onClick(View view) {
        if (!Temperature.isFloat(valeur_source.getText().toString())) {
            Toast.makeText(getApplicationContext(),
                    "Le champ doit contenir des entiers",
                    Toast.LENGTH_SHORT).show();
        } else {
            Temperature temperature = new Temperature(Float.parseFloat(valeur_source.getText().toString()),
                    mSpinner_source.getSelectedItem().toString(),
                    mSpinner_cible.getSelectedItem().toString());

            valeur_cible.setText(String.valueOf(temperature.getValeurCible()));
        }
    }
}