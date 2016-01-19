package com.example.amit.reflexreactor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.io.IOException;
import java.sql.SQLException;

public class Questions extends AppCompatActivity {

    TextView tview;
    MyDatabaseAdapter dbasehelper;
    MyDatabaseAdapter.MyHelper helper;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbasehelper =new MyDatabaseAdapter(this);
        helper =new MyDatabaseAdapter.MyHelper(this);
        try {
            helper.createDataBase();
        } catch (IOException e) {
            throw new Error("Unable to create database");
        }
        try {
            helper.openDataBase();
        } catch (SQLException e) {
            //
        }

        tview = (TextView)findViewById(R.id.myTextView);

        int idx;
        Intent intent = getIntent();
        intent.getExtras();
        idx = intent.getIntExtra("idx", 0);
        String selected_list[] = intent.getStringArrayExtra("selected_categories");
        String level = intent.getIntExtra("mylevel",0) +"";


        for(int i=0;i<idx;i++)
        {
            tview.append(selected_list[i]);
        }

        tview.append(level);

        //tview.append(dbasehelper.getSubjectData());
    }



}
