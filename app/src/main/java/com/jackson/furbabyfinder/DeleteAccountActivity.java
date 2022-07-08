package com.jackson.furbabyfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DeleteAccountActivity extends AppCompatActivity {

    TextView tname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account);


        tname = findViewById(R.id.name);
        String name = getIntent().getStringExtra("name");
        tname.setText(name);
    }
}