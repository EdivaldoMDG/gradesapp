package com.example.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btregistar, aprovar, cancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       btregistar = findViewById(R.id.registar);

            btregistar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RegisterStudent();
                }
            });

            aprovar = findViewById(R.id.btAproved);

            aprovar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent aproved = new Intent(getApplicationContext(), AprovedStudent.class);
                    startActivity(aproved);
                }
            });

            cancelar = findViewById(R.id.btCancelar);

            cancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent exam = new Intent(getApplicationContext(), Exam.class);
                    startActivity(exam);
                }
            });


    }

    public void RegisterStudent(){
        Intent studentIntend = new Intent(this, Register.class);
        startActivity(studentIntend);
    }
}