package com.example.amit.reflexreactor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class Category extends AppCompatActivity {

    CheckBox box;
    TextView get_level ;
    String alist[]  = new String[10];
    int idx=0;
    int mylevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent intent = getIntent();
        intent.getExtras();
        mylevel = intent.getIntExtra("MyLevel",0);
        String str = mylevel+"";
        get_level = (TextView)findViewById(R.id.getlevel_text);
        get_level.setText(str);

    }

    public void start_single(View view) {
        int ids[] = new int[6];
        ids[0]=R.id.science;
        ids[1]=R.id.history;
        ids[2]=R.id.culture;
        ids[3]=R.id.physics;
        ids[4]=R.id.maths;
        ids[5]=R.id.geology;
        int sz = 6;
        for(int i=0;i<sz;i++)
        {
            box = (CheckBox)findViewById(ids[i]);
            if(box.isChecked())
            {
                alist[idx]=box.getText().toString();
                idx++;
            }
        }
        Intent intent = new Intent(this,Questions.class);
        intent.putExtra("selected_categories",alist);
        intent.putExtra("idx",idx);
        intent.putExtra("mylevel",mylevel);
        startActivity(intent);
    }
}
