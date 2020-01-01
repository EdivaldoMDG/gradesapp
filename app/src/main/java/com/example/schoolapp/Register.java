package com.example.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText name , teste1, teste2;
    Button add, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        name = findViewById(R.id.et_nomeC);
        teste1 = findViewById(R.id.et_teste1);
        teste2 =findViewById(R.id.et_teste2);

        add = findViewById(R.id.btAdicionar);
        cancelar = findViewById(R.id.btCancelar);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameEt = name.getText().toString().trim();
                String teste1Et = teste1.getText().toString().trim();
                String teste2Et = teste2.getText().toString().trim();
                // a check to avoid null exception in parse Int in main activity and crash app
                if(TextUtils.isEmpty(nameEt)) { name.setError("Este campo não pode estar vazio");
                    return;
                }
                // add a check to name just because is a good way to to things
                if(TextUtils.isEmpty(teste1Et)) { teste1.setError("Este campo não pode estar vazio");
                    return;
                }
                if(TextUtils.isEmpty(teste2Et)) { teste2.setError("Este campo não pode estar vazio");
                    return;
                }

                String estado;

                float nota = (Float.parseFloat(teste1Et)+Float.parseFloat(teste2Et))/2;

                if(nota < 12)
                    estado="Exam";
                else
                    estado="Aprovado";


                String grades = Float.toString(nota);

                Intent returnIntend = new Intent();
                returnIntend.putExtra("nameEt", nameEt);
                returnIntend.putExtra("grades", grades);
                returnIntend.putExtra("estado", estado );
                setResult(RESULT_OK,returnIntend);
                finish();


            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}