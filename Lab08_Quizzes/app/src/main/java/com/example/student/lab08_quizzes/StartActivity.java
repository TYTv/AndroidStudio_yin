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
import android.widget.RadioGroup;
import android.widget.TextView;

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

    private boolean choice[] = new boolean[4];
    private String choiceString;

    // Create Fragment
    QueFragment qf = null;
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();

    private void InitQuestion(int Qnum) {

        if (qf == null) {   // Init
            qf = new QueFragment();
            ft.add(R.id.FragmentStart, qf);
            ft.commit();
        } else {
            //           QueFragment qfnew = new QueFragment();
            //           ft.replace(R.id.FragmentSheet,qfnew);
//            ft.remove(qf);
//            ft.commit();

//            qf = null;
            //           qf = new QueFragment();
//            ft.add(R.id.FragmentStart, qfnew);
//            ft.commit();

        }


    }


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
        Qnum = in.getIntExtra("QueNum", 0);

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


//        Resources res = getResources();
/*
        for (int i = 0; i < Integer.getInteger(res.getString(R.string.BankSize)); i++) {
            String s = "R.array.Q1";
            int arrid = res.getIdentifier("R.array.Q1", "array", this.getPackageName());
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

                //  choiceChar = (char) view.getTag();
                choiceString = view.getTag().toString();

                choice[0] = rbcha.isChecked();
                choice[1] = rbchb.isChecked();
                choice[2] = rbchc.isChecked();
                choice[3] = rbchd.isChecked();

                break;

            case R.id.ButtonNext:

                int banksize = Integer.parseInt(getResources().getString(R.string.BankSize));
                Qnum++;
                if ((Qnum > 0) && (Qnum <= banksize)) {
                    qf.setQuestion(Qnum);
//                    InitQuestion(Qnum);

                } else {     // Exit this activity and return choice

                    // Data ready
                    Bundle bd = new Bundle();
                    bd.putBooleanArray("SUBMIT", choice);
                    bd.putString("SUBMITstring", choiceString);

                    // Result data return
                    Intent inback = new Intent();
                    inback.putExtras(bd);
                    setResult(RESULT_OK, inback);

                    //finishActivity(100);
                    finish();
                }


                break;
        }


    }
}
