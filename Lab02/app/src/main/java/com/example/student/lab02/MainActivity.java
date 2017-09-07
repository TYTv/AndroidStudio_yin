package com.example.student.lab02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    TextView tvntd;
    private int mQuty = 0;
    private int mSiPri = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.TextViewNumber);
        tvntd = (TextView) findViewById(R.id.TextViewNTD);

    }

    public void onClickOrder(View view) {
        tvntd.setText(CalOrder().toString());
    }

    public void onClickP(View view) {
        int i = getTextQuty() + 1;
        tvntd.setText("");
        if (i <= 10) {
            setTextQuty(i);
        }
    }

    public void onClickM(View view) {
        int i = getTextQuty() - 1;
        tvntd.setText("");
        if (i >= 0) {
            setTextQuty(i);
        }
    }

    private int getTextQuty() {
        mQuty = Integer.valueOf(tv.getText().toString());
        return (mQuty);
    }

    private void setTextQuty(int i) {
        mQuty = i;
        tv.setText(Integer.toString(mQuty));
    }

    private String CalOrder() {
        return add$(getTextQuty() * mSiPri);
    }

    private String add$(int i) {
        String stmp = NumberFormat.getCurrencyInstance().format(i);
        if (i > 0) {
            stmp = stmp + "\nThanks !";
        } else {
            stmp = stmp + "\nFree !";
        }
        return stmp;
    }


}
