package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvPantalla;
    private double primerNumero = 0;
    private String operacion = "";
    private boolean nuevoNumero = true;

    private final int[] idsBotones = {
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnPunto, R.id.btnSumar, R.id.btnRestar,
            R.id.btnMultiplicar, R.id.btnDividir, R.id.btnIgual, R.id.btnC
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPantalla = findViewById(R.id.tvPantalla);

        for (int id : idsBotones) {
            findViewById(id).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        String texto = ((Button) v).getText().toString();

        if (id == R.id.btnC) {
            limpiar();
        } else if (id == R.id.btnSumar || id == R.id.btnRestar
                || id == R.id.btnMultiplicar || id == R.id.btnDividir) {
            primerNumero = Double.parseDouble(tvPantalla.getText().toString());
            operacion = texto;
            nuevoNumero = true;
        } else if (id == R.id.btnIgual) {
            calcular();
        } else if (id == R.id.btnPunto) {
            if (nuevoNumero) {
                tvPantalla.setText("0.");
                nuevoNumero = false;
            } else if (!tvPantalla.getText().toString().contains(".")) {
                tvPantalla.append(".");
            }
        } else {
            if (nuevoNumero) {
                tvPantalla.setText(texto);
                nuevoNumero = false;
            } else {
                tvPantalla.append(texto);
            }
        }
    }

    private void calcular() {
        if (operacion.isEmpty()) {
            return;
        }

        double segundoNumero = Double.parseDouble(tvPantalla.getText().toString());
        double resultado = 0;

        switch (operacion) {
            case "+":
                resultado = primerNumero + segundoNumero;
                break;
            case "-":
                resultado = primerNumero - segundoNumero;
                break;
}