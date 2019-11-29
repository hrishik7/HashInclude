package com.example.hahaa.hashinclude;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;


public class SearchUser extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new CodeForcesFrag())
                .commit();
    }
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(SearchUser.this, home.class));
        finish();

    }

    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();

        return true;
    }
}
