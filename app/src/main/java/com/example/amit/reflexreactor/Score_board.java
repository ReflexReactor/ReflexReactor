package com.example.amit.reflexreactor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;

public class Score_board extends AppCompatActivity {

    TextView score;
    String user_id;
    int level;
    String selected_list[];
    int[] question_indexes;
    MyDatabaseAdapter dbasehelper;
    int catagories_id[];
    int idx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_score_board);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        score = (TextView)findViewById(R.id.My_scoreboard);
        question_indexes = new int[6];
        Intent intent = getIntent();
        intent.getExtras();
        idx = intent.getIntExtra("idx",0);
        user_id = intent.getStringExtra("user_id");
        level = intent.getIntExtra("level", 0);
        catagories_id = intent.getIntArrayExtra("catagories_id");
        selected_list = intent.getStringArrayExtra("catagories");
        question_indexes = intent.getIntArrayExtra("question_indexes");

        score.append(user_id+"\n"+level+"\n");
        for(int i=0;i<6;i++)
        {
            score.append(catagories_id[i]+" "+question_indexes[i]);
            score.append("\n");
        }
        for(int i=0;i<idx;i++)
        {
            score.append(selected_list[i].toString());
            score.append("\n");
        }



    }
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
