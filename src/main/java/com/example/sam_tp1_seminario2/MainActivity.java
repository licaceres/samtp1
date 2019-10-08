package com.example.sam_tp1_seminario2;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String[] tablero = {"[ 3 x 3 ]","[ 4 x 4 ]","[ 5 x 5 ]",
            "[ 6 x 6 ]","[ 7 x 7 ]","[ 8 x 8 ]","[ 9 x 9 ]"};
    private EditText et;
    private Spinner spTablero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.nJugador);
        spTablero = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, tablero);
        spTablero.setAdapter(adapter);
    }

    public void Iniciar(View v) {
        if(et.getText().toString().isEmpty()) {
            Toast.makeText(this, "Falta nombre jugador.", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            intent.putExtra("nombre", et.getText().toString());
            intent.putExtra("tamTablero", spTablero.getSelectedItem().toString());
            startActivity(intent);
            finish();
        }
    }
}
