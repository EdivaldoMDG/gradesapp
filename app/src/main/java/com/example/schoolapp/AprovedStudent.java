package com.example.schoolapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.LinkedList;

public class AprovedStudent extends AppCompatActivity {
    private static final int USER_PASS_REQUEST = 1;
    public  final LinkedList<Student> studentAproved = new LinkedList<>();

    private RecyclerView aprRecyclerView;
    private AprovedAdapter  mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aproved_student);

        aprRecyclerView = findViewById(R.id.recyclerview);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == USER_PASS_REQUEST){
            if(resultCode == RESULT_OK){
                String nome =  data.getStringExtra("nameEt");
                String estado =  data.getStringExtra("estado");
                String grades =  data.getStringExtra("grades");

                Student newStudent = new Student(nome,estado,grades);
                if(estado == "Approve")
                    studentAproved.add(newStudent);

                mAdapter = new AprovedAdapter(studentAproved, this);
                aprRecyclerView.setAdapter(mAdapter);
                aprRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            }
        }
    }
}