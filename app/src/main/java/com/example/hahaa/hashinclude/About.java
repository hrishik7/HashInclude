package com.example.hahaa.hashinclude;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.hahaa.hashinclude.R;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void onBackPressed()
    {

        super.onBackPressed();
        startActivity(new Intent(About.this, home.class));
        finish();
    }
    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        return true;
    }
}
