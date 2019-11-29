package com.example.hahaa.hashinclude;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public int i,x=0;
    Button submission, queryButton;
    TextView responseView, country, rating, username, city, maxrating, contribution, handle;
    static final String API_URL = "http://codeforces.com/api/user.info?";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        for(i=0;i<100;i++)
            x++;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        for(i=0;i<100;i++)
            x++;
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        country = (TextView) findViewById(R.id.country);
        for(i=0;i<100;i++)
            x++;
        rating = (TextView) findViewById(R.id.rating);
        handle = (TextView) findViewById(R.id.handle);
        city = (TextView) findViewById(R.id.city);
        for(i=0;i<100;i++)
            x++;
        maxrating = (TextView) findViewById(R.id.maxrating);
        contribution = (TextView) findViewById(R.id.contribution);
        username = (TextView) findViewById(R.id.username);
        new home.RetrieveFeedTask().execute();
    }

    public void onBackPressed()
    {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing App")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            Intent i = new Intent(home.this, home.class);
            startActivity(i);
            finish();
        } else if (id == R.id.searchuser) {
            Intent i = new Intent(home.this, SearchUser.class);
            startActivity(i);
            finish();

        }else if(id == R.id.cal){
            Intent i = new Intent(home.this, Calendar.class);
            startActivity(i);
            finish();

        }
        else if (id == R.id.tutorial) {
            Intent i = new Intent(home.this, Tabbed.class);
            startActivity(i);
            finish();
        } else if (id == R.id.logout) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("Logged","false");
            editor.apply();
            Intent i = new Intent(home.this, Login.class);
            startActivity(i);
            finish();

        } else if (id == R.id.about) {
            Intent i = new Intent(home.this, About.class);
            startActivity(i);
            finish();
        }
        else if(id == R.id.contact)
        {
            Intent i = new Intent(home.this, Contact.class);
            startActivity(i);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    class RetrieveFeedTask extends AsyncTask<String, Void, String> {


        protected String doInBackground(String... urls) {
            SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            String s1 = settings.getString("username", null);
            SQLiteDatabase data=openOrCreateDatabase("hashinclude",MODE_PRIVATE,null);
            for(i=0;i<100;i++)
                x++;
            String s = "select * from hint where name='" + s1 + "' ";
            Log.e("aa",s);
            Cursor cursor = data.rawQuery(s, null);
            String handles="";
            if (cursor.moveToFirst()) {
                handles = cursor.getString( cursor.getColumnIndex("codeforces"));
                Log.e("ab",handles);
            }
            else
            {
                Log.e("ab","null value of cursor");
            }


            try {
                URL url = new URL(API_URL + "handles=" + handles);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    for(i=0;i<100;i++)
                        x++;
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    for(i=0;i<100;i++)
                        x++;
                    return stringBuilder.toString();
                } finally {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
            //return null;
        }

        protected void onPostExecute(String response) {
            if (response == null) {
                response = "THERE WAS AN ERROR";
            }

            try {
                JSONObject object = (JSONObject) new JSONObject(response);
                JSONArray obj1 = object.getJSONArray("result");
                JSONObject obj = obj1.getJSONObject(0);
                int rating1 = 0, maxrating1 = 0;
                String country1 = null, city1 = null, contribution1 = null, firstname = null, lastname = null;
                for(i=0;i<100;i++)
                    x++;
                if (obj.has("rating"))
                    rating1 = obj.getInt("rating");
                if (rating1 != 0)
                    rating.setText(rating1 + "");
                else rating.setText("Not Found ");
                if (obj.has("country"))
                    country1 = obj.getString("country");
                else country1 = "Not Found ";
                country.setText(country1);
                if (obj.has("city"))
                    city1 = obj.getString("city");
                else city1 = "Not Found ";
                city.setText(city1);
                for(i=0;i<100;i++)
                    x++;
                if (obj.has("maxRating"))
                    maxrating1 = obj.getInt("maxRating");
                if (maxrating1 != 0)
                    maxrating.setText(maxrating1 + "");
                else maxrating.setText("Not Found");
                if (obj.has("contribution"))
                    contribution1 = obj.getString("contribution");
                else contribution1 = "Not Found";
                contribution.setText(contribution1);
                if (obj.has("firstName"))
                    firstname = obj.getString("firstName");
                else firstname = "Not Found";
                for(i=0;i<100;i++)
                    x++;
                if (obj.has("lastName"))
                    lastname = obj.getString("lastName");
                else lastname = "";
                username.setText(firstname + " " + lastname);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }}}