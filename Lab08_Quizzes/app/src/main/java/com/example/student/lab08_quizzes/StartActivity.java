package com.example.student.lab08_quizzes;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {


    private TextView tvnum;
    private TextView tvque;
    private RadioButton rbcha;
    private RadioButton rbchb;
    private RadioButton rbchc;
    private RadioButton rbchd;
    private Button btnext;

//    ArrayList<String[]> QuesBank = new ArrayList<>();

    private boolean choice[] = new boolean[4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    @Override
    protected void onStart() {
        super.onStart();




        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.FragmentStart);
        View v = f.getView();


        QueFragment  qf =  fm.setQuestion();

        tvnum = v.findViewById(R.id.TextViewNumber);
        tvque = v.findViewById(R.id.TextViewQuestion);
        rbcha = v.findViewById(R.id.RadioButtonChoiceA);
        rbchb = v.findViewById(R.id.RadioButtonChoiceB);
        rbchc = v.findViewById(R.id.RadioButtonChoiceC);
        rbchd = v.findViewById(R.id.RadioButtonChoiceD);
        btnext = v.findViewById(R.id.ButtonNext);

//        Resources res = getResources();
/*
        for (int i = 0; i < Integer.getInteger(res.getString(R.string.BankSize)); i++) {
            String s = "R.array.Q1";
            int arrid = res.getIdentifier("R.array.Q1","array",this.getPackageName());
            QuesBank.add(res.getStringArray(arrid));
        }
*/
/*
        QuesBank.add(res.getStringArray(R.array.Q1));
        QuesBank.add(res.getStringArray(R.array.Q2));
        QuesBank.add(res.getStringArray(R.array.Q3));


        String[] ques = QuesBank.get(0);
        tvnum.setText("1");
        tvque.setText(ques[0]);
        rbcha.setText(ques[1]);
        rbchb.setText(ques[2]);
        rbchc.setText(ques[3]);
        rbchd.setText(ques[4]);
*/
    }

    public void OnClickFragAll(View view) {

        switch (view.getId()) {
            case R.id.RadioButtonChoiceA:
            case R.id.RadioButtonChoiceB:
            case R.id.RadioButtonChoiceC:
            case R.id.RadioButtonChoiceD:
                choice[0] = rbcha.isChecked();
                choice[1] = rbchb.isChecked();
                choice[2] = rbchc.isChecked();
                choice[3] = rbchd.isChecked();
                break;
            case R.id.ButtonNext:
                finish();
                break;
        }


    }
}
