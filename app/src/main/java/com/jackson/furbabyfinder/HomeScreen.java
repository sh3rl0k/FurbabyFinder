package com.jackson.furbabyfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {

    TextView tname;
    Button lostbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);


        lostbutton = findViewById(R.id.lostbutton);


        tname = findViewById(R.id.name);
        String name = getIntent().getStringExtra("name");
        tname.setText(name);


        lostbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, AlertActivity.class);
                startActivity(intent);
            }
        });
    }

    //Inflator for menuhome
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuhome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    //handle the item selection
        switch (item.getItemId()) {
            case R.id.account:
                String name = getIntent().getStringExtra("name");
                startActivity(new Intent(HomeScreen.this, UserAccountActivity.class)
                        .putExtra("name", name));
                break;
            case R.id.map:
                startActivity(new Intent(HomeScreen.this, SMSMessage.class));
                Toast.makeText(this, "This will take you to the map", Toast.LENGTH_LONG).show();
                break;
            case R.id.logout:
                startActivity(new Intent(HomeScreen.this, MainActivity.class));
                break;
            case R.id.deleteAccount:
                String name2 = getIntent().getStringExtra("name");
                startActivity(new Intent(HomeScreen.this, DeleteAccountActivity.class)
                        .putExtra("name", name2));
        }


        return super.onOptionsItemSelected(item);
    }
}