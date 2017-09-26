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


    private ArrayList<String[]> QuesBank = null;

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


        QuesBank = getQuestionBank();       // Get resources


    }

    public void setQuestion(int num) {
        Question = num;
        QuesBank = getQuestionBank();       // Get resources
        show(Question);
    }

    public ArrayList<String[]> getQuestionBank() {

        Resources res = getResources();

/*
        StringBuilder sb = new StringBuilder("Q0");
        sb.replace(1, 1, String.valueOf(1));
        res.getIdentifier(R.array.Q1,,);
        res.geti
        int resId = res.getIdentifier("Q1", "array", getActivity().getPackageName());
*/


        int rSrtingId[] = new int[Integer.parseInt(res.getString(R.string.ItemSize))];
        StringBuilder sb = new StringBuilder("Q0");
        ArrayList<String[]> als = new ArrayList<>();

        sb.deleteCharAt(1);     // Qx delete

//        for (int i = 0; i < PRM.BANK_SIZE; i++) {


            sb.append(String.valueOf(Question + 1));    // Qn
            int arrId = res.getIdentifier(sb.toString(), "array", getActivity().getPackageName());

            als.add(res.getStringArray(arrId));
            //   als.add(res.getStringArray(R.array.Q1));

//        }
        return (als);

    }


    public String[] getQuestion(int num) {
        return (QuesBank.get(num));
    }

    private void show(int num) {

        rbcha.setChecked(false);
        rbchb.setChecked(false);
        rbchc.setChecked(false);
        rbchd.setChecked(false);

        String[] Ques = getQuestion(num);

        tvnum.setText(String.valueOf(num + 1));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tvque.setText(Html.fromHtml(Ques[PRM.Q_TOPIC], Html.FROM_HTML_MODE_LEGACY));
            rbcha.setText(Html.fromHtml(Ques[PRM.Q_SEL_A], Html.FROM_HTML_MODE_LEGACY));
            rbchb.setText(Html.fromHtml(Ques[PRM.Q_SEL_B], Html.FROM_HTML_MODE_LEGACY));
            rbchc.setText(Html.fromHtml(Ques[PRM.Q_SEL_C], Html.FROM_HTML_MODE_LEGACY));
            rbchd.setText(Html.fromHtml(Ques[PRM.Q_SEL_D], Html.FROM_HTML_MODE_LEGACY));
        } else {
            tvque.setText(Html.fromHtml(Ques[PRM.Q_TOPIC]));
            rbcha.setText(Html.fromHtml(Ques[PRM.Q_SEL_A]));
            rbchb.setText(Html.fromHtml(Ques[PRM.Q_SEL_B]));
            rbchc.setText(Html.fromHtml(Ques[PRM.Q_SEL_C]));
            rbchd.setText(Html.fromHtml(Ques[PRM.Q_SEL_D]));
        }
    }


}
