package com.example.amit.reflexreactor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Single_player extends AppCompatActivity {

    int LEVEL=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void start_category()
    {
        Intent intent = new Intent(this,Category.class);
        intent.putExtra("MyLevel",LEVEL);
        startActivity(intent);
    }

    public void level1_function(View view) {
        LEVEL = 1;
        start_category();
    }
    public void level2_function(View view) {
        LEVEL = 2;
        start_category();
    }
    public void level3_function(View view) {
        LEVEL = 3;
        start_category();
    }
    public void level4_function(View view) {
        LEVEL = 4;
        start_category();
    }

}
