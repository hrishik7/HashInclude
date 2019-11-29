package com.example.hahaa.hashinclude;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.data;

public class Login extends AppCompatActivity {

    public int i,x=0;
    ImageView imageView;
    EditText e1, e2;
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        imageView = (ImageView) findViewById(R.id.code);
        imageView.setImageResource(R.drawable.code);

        SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(this);
        String isLogged = preferences1.getString("Logged", "");
        if (!isLogged.equalsIgnoreCase("")) {
            if (isLogged.equals("true")) {
                Intent i = new Intent(Login.this, home.class);
                startActivity(i);
                finish();
            }
        }

        e1 = (EditText) findViewById(R.id.username);
        e2 = (EditText) findViewById(R.id.password);
        for(i=0;i<100;i++)
            x++;
        b2 = (Button) findViewById(R.id.login);
        b1 = (Button) findViewById(R.id.signup);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase data = openOrCreateDatabase("hashinclude", MODE_PRIVATE, null); //nobody other can access
                //it is stored in our phone only
                data.execSQL("create table if not exists hint (name varchar, password varchar,confirm_password varchar,email varchar,codeforces varchar,phone varchar);");
                //
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s = "select * from hint where name='" + s1 + "' and password='" + s2 + "'";
                if (s1.equals("")) {
                    Toast.makeText(Login.this, "Please Enter username.", Toast.LENGTH_LONG).show();
                    for(i=0;i<100;i++)
                        x++;

                } else if (s2.equals("")) {
                    Toast.makeText(Login.this, "Please Enter password.", Toast.LENGTH_LONG).show();
                } else {
                    Cursor cursor = data.rawQuery(s, null);
                    if (cursor.getCount() > 0) {
                        SharedPreferences settings2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor editor2 = settings2.edit();
                        editor2.putString("username", s1).apply();
                        for(i=0;i<100;i++)
                            x++;
                        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("Logged", "true");
                        editor.apply();
                        Intent i = new Intent(Login.this, home.class);
                        startActivity(i);
                        finish();
                        //Toast.makeText(Login.this, "sjkhfdkjhafl", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Login.this, "Not a registered User , Kindly signup first", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();

                for(i=0;i<100;i++)
                    x++;
                //database in android
                SQLiteDatabase data = openOrCreateDatabase("hashinclude", MODE_PRIVATE, null); //nobody other can access
                //it is stored in our phone only
                data.execSQL("create table if not exists hint (name varchar, password varchar,confirm_password varchar,email varchar,codeforces varchar,phone varchar);");
                //   data.execSQL("create table if not exists sushant (name varchar, password varchar);");
                String s = "select * from hint where name='" + s1 + "' and password='" + s2 + "'";
                Cursor cursor = data.rawQuery(s, null); // whatever query i run i can store something in cursor it is a class
                for(i=0;i<100;i++)
                    x++;
                if (cursor.getCount() > 0) {
                    Toast.makeText(Login.this, "User Already Exist", Toast.LENGTH_LONG).show();
                } else {
                    //data.execSQL("insert into sushant values ('" + s1 + "','" + s2 + "');");
                    //Toast.makeText(Login.this, "database updated", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Login.this, Signup.class);
                    startActivity(i);
                    finish();
                }

            }
        });


    }
}