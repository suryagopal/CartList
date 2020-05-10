package com.example.recyclerViewSample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recyclerViewSample.ListExample.ListActivity;
import com.example.recyclerViewSample.mvvm.ListActivity2;


public class LauncherActivity extends AppCompatActivity {

    Button sample, mvvmSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        sample = findViewById(R.id.simple);
        mvvmSample = findViewById(R.id.mvvmButton);

        sample.setOnClickListener(v -> {
            startActivity(new Intent(LauncherActivity.this, ListActivity.class));
        });

        mvvmSample.setOnClickListener(v -> {
            startActivity(new Intent(LauncherActivity.this, ListActivity2.class));

        });
    }
}
