package com.example.autotexto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private AutoCompleteTextView autoTexto;
    private Spinner spinner;
    public static final String[] nomes = {"Nathalia", "Caroline", "Daniela", "Ligia", "Ivone", "Nanci", "Luiz", "Cleyton", "Anderson", "Isadora"};

    // FINAL funciona como uma constante, não podendo ser alterada durante a aplicação

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoTexto = findViewById(R.id.autoTexto);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapterNomes = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nomes);
        autoTexto.setAdapter(adapterNomes);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, nomes);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView texto = (TextView) view;
        Toast.makeText(this, "Posição: "+position+"\nTexto: "+texto.getText().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}