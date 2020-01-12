package com.example.combustivel;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_verificar;
    private EditText input_gasolina;
    private EditText input_alcool;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.btn_verificar = findViewById(R.id.id_btn_verificar);
        this.input_alcool = findViewById(R.id.id_alcool);
        this.input_gasolina = findViewById(R.id.id_gasolina);
        this.resultado = findViewById(R.id.resultado);

        this.btn_verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String alcool = input_alcool.getText().toString();
                    String gasolina = input_gasolina.getText().toString();
                    double valor_g = Double.parseDouble(gasolina);
                    double valor_a = Double.parseDouble(alcool);
                    if ((valor_a / valor_g) > 0.7)
                        resultado.setText("Melhor usar gasolina!");
                    else
                        resultado.setText("Melhor usar álcool!");
                } catch (NumberFormatException error) {
                    System.out.println();
                    System.out.println(error);
                    System.out.println();
                    resultado.setText("Não deixe de digitar os valores!");
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
