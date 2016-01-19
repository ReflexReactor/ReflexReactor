package com.example.amit.reflexreactor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Multi_player extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void online_start(View view)
    {
        Intent intent = new Intent(this,Online.class);
        startActivity(intent);
    }
    public void offline_start(View view)
    {
        Intent intent = new Intent(this,Offline.class);
        startActivity(intent);
    }



}
