package com.example.amit.reflexreactor;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Category extends AppCompatActivity {

    Button btn;
    String alist[] = new String[15];
    int idx = 0;
    int mylevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        intent.getExtras();
        mylevel = intent.getIntExtra("MyLevel", 0);
    }

    public void start_single(View view) {

        if (idx == 0)
            Message.message(this, "please select atleast one option");
        else {
            Intent intent = new Intent(this, Questions.class);
            intent.putExtra("selected_categories", alist);
            intent.putExtra("idx", idx);
            intent.putExtra("mylevel", mylevel);
            startActivity(intent);
        }
    }

    public void select_geography(View view) {
        btn = (Button) findViewById(R.id.geography);
        btn.setBackgroundColor(Color.CYAN);
        alist[idx] = btn.getText().toString();
        idx++;
    }

    public void select_aeroscience(View view) {
        btn = (Button) findViewById(R.id.aeroscience);
        btn.setBackgroundColor(Color.CYAN);
        alist[idx] = btn.getText().toString();
        idx++;
    }

    public void select_travel(View view) {
        btn = (Button) findViewById(R.id.travel);
        btn.setBackgroundColor(Color.CYAN);
        alist[idx] = btn.getText().toString();
        idx++;
    }

    public void select_cricket(View view) {
        btn = (Button) findViewById(R.id.cricket);
        btn.setBackgroundColor(Color.CYAN);
        alist[idx] = btn.getText().toString();
        idx++;
    }

    public void select_politics(View view) {
        btn = (Button) findViewById(R.id.politics);
        btn.setBackgroundColor(Color.CYAN);
        alist[idx] = btn.getText().toString();
        idx++;
    }

    public void select_history(View view) {
        btn = (Button) findViewById(R.id.history);
        btn.setBackgroundColor(Color.CYAN);
        alist[idx] = btn.getText().toString();
        idx++;
    }

    public void select_science(View view) {
        btn = (Button) findViewById(R.id.science);
        btn.setBackgroundColor(Color.CYAN);
        alist[idx] = btn.getText().toString();
        idx++;
    }

    public void select_culture(View view) {
        btn = (Button) findViewById(R.id.culture);
        btn.setBackgroundColor(Color.CYAN);
        alist[idx] = btn.getText().toString();
        idx++;
    }

    public void select_food(View view) {
        btn = (Button) findViewById(R.id.food);
        btn.setBackgroundColor(Color.CYAN);
        alist[idx] = btn.getText().toString();
        idx++;
    }

    public void select_music(View view) {
        btn = (Button) findViewById(R.id.music);
        btn.setBackgroundColor(Color.CYAN);
        alist[idx] = btn.getText().toString();
        idx++;
    }
}
