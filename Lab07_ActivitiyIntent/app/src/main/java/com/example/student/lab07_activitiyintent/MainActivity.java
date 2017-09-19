package com.example.student.lab07_activitiyintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        tv = (TextView) findViewById(R.id.TextViewShow);

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        ColorActivity ca = new ColorActivity();
        if (ca.getName() == null) {
            tv.setText("請選擇顏色!");
        } else {
            tv.setText(ca.getName());
        }
        tv.setBackgroundColor(ca.getColor());

    }

    public void onClickAll(View view) {

        switch (view.getId()) {
            case R.id.ButtonSelectColor:
                if (in == null) {
                    in = new Intent(this, ColorActivity.class);
                }
                startActivity(in);
                break;
            case R.id.ButtonSelectLogo:

                break;
            default:
                break;
        }

    }


}
