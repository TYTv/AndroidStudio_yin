package com.example.student.lab08_quizzes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Intent it = new Intent();
    private boolean[] Scoring;
    private int Score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PRM.BANK_SIZE = Integer.parseInt(getResources().getString(R.string.BankSize));

    }

    public void OnClickAll(View view) {

        it.setClass(this, StartActivity.class);
        it.putExtra(PRM.DATA_START_NUM, 0);
        startActivityForResult(it, PRM.CODE);
        overridePendingTransition(R.anim.new_activity, R.anim.now_activity);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == PRM.CODE) {

            // Result back
            Bundle bd = data.getExtras();
            Scoring = bd.getBooleanArray(PRM.KEY);

            Score = 0;
            for (int i = 0; i < PRM.BANK_SIZE; i++) {
                if (Scoring[i] == true) {
                    Score += 30;
                }
            }

            ((TextView) findViewById(R.id.TextViewResult)).setText("得分 : " + String.valueOf(Score));

        }


    }


}
