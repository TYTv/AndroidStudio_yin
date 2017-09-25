package com.example.student.lab08_quizzes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent it = new Intent();
    boolean[] choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickAll(View view) {

        it.setClass(this, StartActivity.class);
        it.putExtra("QueNum", 1);
        startActivityForResult(it, 100);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 100) {

            // Result back
            Bundle bd = data.getExtras();
            choice = bd.getBooleanArray("SUBMIT");


            StringBuilder sb = new StringBuilder();
            sb.append(choice[0]);
            sb.append(choice[1]);
            sb.append(choice[2]);
            sb.append(choice[3]);

            ((TextView)findViewById(R.id.TextViewResult)).setText(sb);

        }


    }


}
