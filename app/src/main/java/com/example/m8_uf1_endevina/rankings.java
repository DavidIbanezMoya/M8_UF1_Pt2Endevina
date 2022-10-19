package com.example.m8_uf1_endevina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class rankings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankings);
        ArrayList<user> userList = (ArrayList<user>) getIntent().getSerializableExtra("Users");



    }
}