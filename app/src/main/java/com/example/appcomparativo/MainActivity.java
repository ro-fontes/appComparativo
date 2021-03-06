package com.example.appcomparativo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView editPrecoEtanol, textoResultado, editPrecoGasolina;
    private String precoGasolina, precoEtanol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoEtanol = findViewById(R.id.textoEtanol);
        editPrecoGasolina = findViewById(R.id.textoGasolina);
        textoResultado = findViewById(R.id.textoResultado);
    }

    public void calcularPreco(View view) {
        //recuperar valores digitados
        precoEtanol = editPrecoEtanol.getText().toString();
        precoGasolina = editPrecoGasolina.getText().toString();

        Boolean camposValidados = validarCampos(precoGasolina, precoEtanol);
        if (camposValidados){
            //Converter String para numero
            Double valorEtanol = Double.parseDouble(precoEtanol);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            Double resultado = valorEtanol / valorGasolina;
            if(resultado >= 0.7){
                textoResultado.setText("Melhor utilizar a Gasolina");
            }
            else {
                textoResultado.setText("Melhor utilizar o Etanol");
            }
        }
    }

    public Boolean validarCampos(String pEtanol, String pGasolina){
        Boolean camposValidados = true;

        if(pEtanol == null || precoEtanol.equals("")){
            camposValidados = false;
        }
        else if(pGasolina == null || precoGasolina.equals("")){
            camposValidados = false;
        }
        return camposValidados;
    }
}