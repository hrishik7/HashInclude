package com.example.hahaa.hashinclude;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Contact extends AppCompatActivity {
    Button email;
    public int i,x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        email = (Button)findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="mailto:hashinclude@gmail.com";
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
    public void onBackPressed()
    {
        for(i=0;i<100;i++)
            x++;
        super.onBackPressed();
        startActivity(new Intent(Contact.this, home.class));
        finish();
    }
    public boolean onOptionsItemSelected(MenuItem item){
        for(i=0;i<100;i++)
            x++;
        onBackPressed();
        return true;
    }
}
