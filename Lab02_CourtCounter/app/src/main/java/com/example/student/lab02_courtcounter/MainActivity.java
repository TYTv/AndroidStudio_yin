package com.example.student.lab02_courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvH;
    TextView tvF;
    int numberH = 0;
    int numberF = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvH = (TextView) findViewById(R.id.TextViewNumberH);
        tvF = (TextView) findViewById(R.id.TextViewNumberF);

        findViewById(R.id.ButtonB3H).setOnClickListener(vo);
        findViewById(R.id.ButtonB2H).setOnClickListener(vo);
        findViewById(R.id.ButtonBrH).setOnClickListener(vo);

        findViewById(R.id.ButtonB3F).setOnClickListener(vo);
        findViewById(R.id.ButtonB2F).setOnClickListener(vo);
        findViewById(R.id.ButtonBrF).setOnClickListener(vo);

        findViewById(R.id.ButtonRst).setOnClickListener(vo);

    }

    private View.OnClickListener vo = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.ButtonB3H:
                    numberH += 3;
                    break;
                case R.id.ButtonB2H:
                    numberH += 2;
                    break;
                case R.id.ButtonBrH:
                    numberH += 1;
                    break;

                case R.id.ButtonB3F:
                    numberF += 3;
                    break;
                case R.id.ButtonB2F:
                    numberF += 2;
                    break;
                case R.id.ButtonBrF:
                    numberF += 1;
                    break;

                case R.id.ButtonRst:
                    numberH = 0;
                    numberF = 0;
                    break;
                default:
                    break;
            }
            display();


        }
    };


    private void display() {
        tvH.setText(Integer.toString(numberH));
        tvF.setText(Integer.toString(numberF));
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
