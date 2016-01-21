package com.example.amit.reflexreactor;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Questions extends AppCompatActivity {

    CountDownTimer cTimer;
    ArrayList<String> My_question;
    int p=1;
    Button optnA,optnB,optnC,optnD;
    TextView que_no,ques,timer;

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

        que_no = (TextView) findViewById(R.id.quesNo);
        ques = (TextView) findViewById(R.id.ques);
        optnA = (Button) findViewById(R.id.optionA);
        optnB = (Button) findViewById(R.id.optionB);
        optnC = (Button) findViewById(R.id.optionC);
        optnD = (Button) findViewById(R.id.optionD);
        timer = (TextView) findViewById(R.id.timer);

        cTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText("Seconds remaining: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                dont_store_next_question_without_view();
            }
        }.start();

        dbasehelper = new MyDatabaseAdapter(this);
        helper = new MyDatabaseAdapter.MyHelper(this);
        try {
            helper.createDataBase();
        } catch (IOException e) {
            throw new Error("Unable to create database");
        }
        try {
            helper.openDataBase();
        } catch (SQLException e) {
        }

        My_question = dbasehelper.getSubjectData(p);
        que_no.setText("Question NO " + p + "");
        ques.setText("Question \n" + My_question.get(1));
        optnA.setText("A) " + My_question.get(2));
        optnB.setText("B) " + My_question.get(3));
        optnC.setText("C) " + My_question.get(4));
        optnD.setText("D) " + My_question.get(5));

        p++;

    }

//        tview = (TextView)findViewById(R.id.myTextView);

//        int idx;
//        Intent intent = getIntent();
//        intent.getExtras();
//        idx = intent.getIntExtra("idx", 0);
//        String selected_list[] = intent.getStringArrayExtra("selected_categories");
//        String level = intent.getIntExtra("mylevel",0) +"";


//        for(int i=0;i<idx;i++)
//        {
//            tview.append(selected_list[i]);
//        }
//
//        tview.append(level);

        //tview.append(dbasehelper.getSubjectData());


    public void dont_store_next_question(View view) {

        dont_store_next_question_without_view();
    }

    public void reset_priority(View view) {
    }

    public void store_next_question(View view) {

        if(p==7)
        {
            Intent intent = new Intent(this,Score_board.class);
            startActivity(intent);
        }
        else {
            que_no.setText("Question NO " + p + "");
            My_question = dbasehelper.getSubjectData(p);
            ques.setText("Question \n" + My_question.get(1));
            optnA.setText("A) " +My_question.get(2));
            optnB.setText("B) " +My_question.get(3));
            optnC.setText("C) " +My_question.get(4));
            optnD.setText("D) " +My_question.get(5));
            p++;
        }
        cTimer.cancel();
        cTimer.start();
    }

    private void dont_store_next_question_without_view() {

        if(p==7)
        {
            Intent intent = new Intent(this,Score_board.class);
            startActivity(intent);
        }
        else {
            que_no.setText("Question NO " + p + "");
            My_question = dbasehelper.getSubjectData(p);
            ques.setText("Question \n" + My_question.get(1));
            optnA.setText("A) " +My_question.get(2));
            optnB.setText("B) " +My_question.get(3));
            optnC.setText("C) " +My_question.get(4));
            optnD.setText("D) " +My_question.get(5));
            p++;
        }

        cTimer.cancel();
        cTimer.start();
    }



}

