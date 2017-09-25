package com.example.student.lab08_quizzes;


import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
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


    @SuppressLint("ValidFragment")
    public QueFragment(/*int question*/) {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_que, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


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


        String[] ques = QuesBank.get(Question);
        tvnum.setText(String.valueOf(Question));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tvque.setText(Html.fromHtml(ques[0], Html.FROM_HTML_MODE_LEGACY));
            rbcha.setText(Html.fromHtml(ques[1], Html.FROM_HTML_MODE_LEGACY));
            rbchb.setText(Html.fromHtml(ques[2], Html.FROM_HTML_MODE_LEGACY));
            rbchc.setText(Html.fromHtml(ques[3], Html.FROM_HTML_MODE_LEGACY));
            rbchd.setText(Html.fromHtml(ques[4], Html.FROM_HTML_MODE_LEGACY));
        } else {
            tvque.setText(Html.fromHtml(ques[0]));
            rbcha.setText(Html.fromHtml(ques[1]));
            rbchb.setText(Html.fromHtml(ques[2]));
            rbchc.setText(Html.fromHtml(ques[3]));
            rbchd.setText(Html.fromHtml(ques[4]));
        }


    }

    public void setQuestion(int question) {
        Question = question;
        onStart();
    }
}
