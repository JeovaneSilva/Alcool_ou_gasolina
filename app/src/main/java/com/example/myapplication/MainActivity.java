package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editAlcool, editGasolina;
    Button btnCalcular, btnLimpar;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcool = findViewById(R.id.editAlcool);
        editGasolina = findViewById(R.id.editGasolina);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editAlcool.getText().toString().isEmpty() ||
                        editGasolina.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double precoAlcool = Double.parseDouble(editAlcool.getText().toString());
                    double precoGasolina = Double.parseDouble(editGasolina.getText().toString());

                    if (precoGasolina == 0) {
                        Toast.makeText(MainActivity.this, "O preço da gasolina não pode ser zero!", Toast.LENGTH_LONG).show();
                        return;
                    }

                    double resultado = precoAlcool / precoGasolina;

                    if (resultado <= 0.7) {
                        txtResultado.setText("Abasteça com ÁLCOOL");
                    } else {
                        txtResultado.setText("Abasteça com GASOLINA");
                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Digite valores numéricos válidos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editAlcool.setText("");
                editGasolina.setText("");
                txtResultado.setText("Resultado aparecerá aqui");
                editAlcool.requestFocus();
            }
        });
    }
}