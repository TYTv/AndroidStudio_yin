package com.example.student.lab07_activitiyintent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

public class ColorActivity extends AppCompatActivity {

    private static int color;
    private static CharSequence name;

    private RadioButton rbr;
    private RadioButton rbo;
    private RadioButton rbg;
    private RadioButton rbb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        rbr = (RadioButton) findViewById(R.id.RadioButtonRead);
        rbo = (RadioButton) findViewById(R.id.RadioButtonOrange);
        rbg = (RadioButton) findViewById(R.id.RadioButtonGreen);
        rbb = (RadioButton) findViewById(R.id.RadioButtonBlue);

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (color == rbr.getCurrentTextColor()) {
            rbr.setChecked(true);
        } else if (color == rbo.getCurrentTextColor()) {
            rbo.setChecked(true);
        } else if (color == rbg.getCurrentTextColor()) {
            rbg.setChecked(true);
        } else if (color == rbb.getCurrentTextColor()) {
            rbb.setChecked(true);
        } else {
            ;
        }

    }

    public int getColor() {
        return color;
    }

    public static CharSequence getName() {
        return name;
    }

    public void onClickAll(View view) {

        switch (view.getId()) {
            case R.id.ButtonOk:
                if (rbr.isChecked() == true) {
                    ;
                } else if (rbo.isChecked() == true) {
                    ;
                } else if (rbg.isChecked() == true) {
                    ;
                } else if (rbb.isChecked() == true) {
                    ;
                } else {
                    break;
                }
                finish();
                break;
            case R.id.ButtonCancel:
                color = 0;
                name = null;
                finish();
                break;
            case R.id.RadioButtonRead:
                color = rbr.getCurrentTextColor();
                name = rbr.getText();
                break;
            case R.id.RadioButtonOrange:
                color = rbo.getCurrentTextColor();
                name = rbo.getText();
                break;
            case R.id.RadioButtonGreen:
                color = rbg.getCurrentTextColor();
                name = rbg.getText();
                break;
            case R.id.RadioButtonBlue:
                color = rbb.getCurrentTextColor();
                name = rbb.getText();
                break;

            default:
                break;
        }

    }

}
