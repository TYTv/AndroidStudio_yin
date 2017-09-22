package com.example.student.lab08_quizzes;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class QueFragment extends Fragment {


    private int Question;
    private TextView tvnum;
    private TextView tvque;
    private RadioButton rbcha;
    private RadioButton rbchb;
    private RadioButton rbchc;
    private RadioButton rbchd;
    private Button btnext;

    private ArrayList<String[]> QuesBank = new ArrayList<>();


    public QueFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_que, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        tvnum = getView().findViewById(R.id.TextViewNumber);
        tvque = getView().findViewById(R.id.TextViewQuestion);
        rbcha = getView().findViewById(R.id.RadioButtonChoiceA);
        rbchb = getView().findViewById(R.id.RadioButtonChoiceB);
        rbchc = getView().findViewById(R.id.RadioButtonChoiceC);
        rbchd = getView().findViewById(R.id.RadioButtonChoiceD);
        btnext = getView().findViewById(R.id.ButtonNext);

        Resources res = getResources();
/*
        for (int i = 0; i < Integer.getInteger(res.getString(R.string.BankSize)); i++) {
            String s = "R.array.Q1";
            int arrid = res.getIdentifier("R.array.Q1","array",this.getPackageName());
            QuesBank.add(res.getStringArray(arrid));
        }
*/
        QuesBank.add(res.getStringArray(R.array.Q1));
        QuesBank.add(res.getStringArray(R.array.Q2));
        QuesBank.add(res.getStringArray(R.array.Q3));


        String[] ques = QuesBank.get(0);
        tvnum.setText(String.valueOf(Question));
        tvque.setText(ques[0]);
        rbcha.setText(ques[1]);
        rbchb.setText(ques[2]);
        rbchc.setText(ques[3]);
        rbchd.setText(ques[4]);

    }

    public void setQuestion(int question) {
        Question = question;
    }
}
