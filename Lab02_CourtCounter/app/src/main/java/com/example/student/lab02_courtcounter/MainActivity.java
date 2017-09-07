package com.example.student.lab02_courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    int number = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.TextViewNumber);

        findViewById(R.id.ButtonB3).setOnClickListener(vo);
        findViewById(R.id.ButtonB2).setOnClickListener(vo);
        findViewById(R.id.ButtonBr).setOnClickListener(vo);
        findViewById(R.id.ButtonRst).setOnClickListener(vo);


    }

    private View.OnClickListener vo = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.ButtonB3:
                    number += 3;
                    break;
                case R.id.ButtonB2:
                    number += 2;
                    break;
                case R.id.ButtonBr:
                    number += 1;
                    break;
                case R.id.ButtonRst:
                    number = 0;
                    break;
                default:
                    break;
            }
            display();


        }
    };


    private void display() {
        tv.setText(Integer.toString(number));
    }

/*
    public void onClickB3(View view) {
        number += 3;
        display();
    }


    public void onClickB2(View view) {
        number += 2;
        display();
    }


    public void onClickBr(View view) {
        number += 1;
        display();
    }


    public void onClickRst(View view) {
        number = 0;
        display();
    }
*/

}
