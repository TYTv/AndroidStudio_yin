package com.example.student.lab08_quizzes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {


    private static int Qnum;

    private TextView tvnum;
    private TextView tvque;
    private RadioButton rbcha;
    private RadioButton rbchb;
    private RadioButton rbchc;
    private RadioButton rbchd;
    private Button btnext;

//    ArrayList<String[]> QuesBank = new ArrayList<>();

    private boolean check[] = new boolean[4];
    private CharSequence choice;
    private ArrayList<String[]> QB = null;

    // Create Fragment
    QueFragment qf = null;
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        // Init question Fragment
//        InitQuestion(Qnum);


    }

    @Override
    protected void onStart() {
        super.onStart();

        // Get question number
        Intent in = getIntent();
        Qnum = in.getIntExtra(PRM.DATA_START_NUM, 0);

        Fragment f = fm.findFragmentById(R.id.FragmentStart);
        qf = (QueFragment) f;
        qf.setQuestion(Qnum);
        View v = qf.getView();


//        QueFragment  qf =  fm.setQuestion();

        tvnum = v.findViewById(R.id.TextViewNumber);
        tvque = v.findViewById(R.id.TextViewQuestion);
        rbcha = v.findViewById(R.id.RadioButtonChoiceA);
        rbchb = v.findViewById(R.id.RadioButtonChoiceB);
        rbchc = v.findViewById(R.id.RadioButtonChoiceC);
        rbchd = v.findViewById(R.id.RadioButtonChoiceD);
        btnext = v.findViewById(R.id.ButtonNext);

    }


    public void OnClickFragAll(View view) {

        switch (view.getId()) {

            case R.id.RadioButtonChoiceA:
            case R.id.RadioButtonChoiceB:
            case R.id.RadioButtonChoiceC:
            case R.id.RadioButtonChoiceD:

                choice = view.getTag().toString();

                String solution = qf.getQuestion(Qnum)[PRM.Q_SOLUTION];
                check[Qnum] = solution.equals(choice);
                break;

            case R.id.ButtonNext:

                Qnum++;
                if ((Qnum >= 0) && (Qnum < PRM.BANK_SIZE)) {

                    qf.setQuestion(Qnum);

                } else {     // Exit this activity and return choice

                    // Data ready
                    Bundle bd = new Bundle();
                    bd.putBooleanArray(PRM.KEY, check);


                    // Result data return
                    Intent inback = new Intent();
                    //      Intent inback = getIntent();
                    inback.putExtras(bd);

                    setResult(PRM.CODE, inback);
                    //finishActivity(PRM.CODE);
                    finish();
                }


                break;
        }


    }
}
