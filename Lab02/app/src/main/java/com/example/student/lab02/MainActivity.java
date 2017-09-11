package com.example.student.lab02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    TextView tvntd;
    CheckBox cb;
    private int mQuty = 0;
    private final int mSiPri = 5;
    private final int mKor = 10;

    private StringBuilder sb = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.TextViewNumber);
        tvntd = (TextView) findViewById(R.id.TextViewNTD);
        cb = (CheckBox) findViewById(R.id.CheckBoxKorea);

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

        int $ = getTextQuty();
        if (cb.isChecked() == true) {
            $ *= mSiPri + mKor;
        } else {
            $ *= mSiPri;
        }


        sb.delete(0, sb.length());
        sb
                .append("客戶:孫悟空\n")
                .append("商品:臭豆腐\n")
                .append("加泡菜?" + cb.isChecked() + "\n");


        if (mQuty > 0) {
            sb
                    .append("數量:" + mQuty + "\n")
                    .append("單價:" + mSiPri + "(" + mKor + ")\n")
                    .append("=================\n")
                    .append("總金額:" + NumberFormat.getCurrencyInstance().format($) + "\n");

            sb.append("Thanks !\n");
        } else {
            sb
                    .append("免費試吃!\n")
                    .append("Free !\n");
        }

        return sb.toString();
    }


    public void onClickAll(View view) {
        tvntd.setText("選好請下單 !");
        int i;
        switch (view.getId()) {
            case R.id.CheckBoxKorea:
                break;
            case R.id.ButtonP:
                i = getTextQuty() + 1;
                if (i <= 10) {
                    setTextQuty(i);
                }
                break;
            case R.id.ButtonM:
                i = getTextQuty() - 1;
                if (i >= 0) {
                    setTextQuty(i);
                }
                break;
            case R.id.ButtonOrder:
                tvntd.setText(CalOrder().toString());
                break;
            default:
                break;
        }

    }


}
