package com.example.student.lab08_animationdrawable;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvmsg;
    private ImageView ivshow;
    private AnimationDrawable ani;
    private Handler han = new Handler();

    private View vlogo;
    private TextView tvlogo;
    private TextView tvgo;

    private int logoindex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        tvmsg = (TextView) findViewById(R.id.TextViewMessage);
        ivshow = (ImageView) findViewById(R.id.ImageViewShow);
//        findViewById(R.id.ButtonStart);
//        findViewById(R.id.ButtonStop);
//        findViewById(R.id.Button5sec);
        vlogo = findViewById(R.id.ViewLogo);
        tvlogo = (TextView) findViewById(R.id.TextViewLogo);
        tvgo = (TextView) findViewById(R.id.TextViewGo);

        //                Animation ani = iv.getAnimation();
//                ani.setAnimationListener(R.drawable.frame_animation);
        ivshow.setBackgroundResource(R.drawable.frame_animation);
        ani = (AnimationDrawable) ivshow.getBackground();
    }

    public void onClickAll(View view) {

        switch (view.getId()) {
            case R.id.ButtonStart:
                ani.start();
                break;
            case R.id.ButtonStop:
                ani.stop();
                break;
            case R.id.Button5sec:
                Runnable tm5s = new TIMEUP();
                if (han.postDelayed(tm5s, 5000) == true) {
                    tvmsg.setText("交付成功");
                    ani.start();
                } else {
                    tvmsg.setText("交付失敗");
                }
                break;
            case R.id.ButtonGo:
                Resources r = getResources();
                String[] slogoname = r.getStringArray(R.array.NBA_logoname);
                tvlogo.setText(slogoname[logoindex]);

                String[] slogos = r.getStringArray(R.array.NBA_logos);
                Drawable d = Drawable.createFromPath(slogos[logoindex]);


                //vlogo.setBackground(getDrawable(R.drawable.nba_logo_clippers));
                vlogo.setBackground( r.getDrawable(R.drawable.nba_logo_clippers)  );

                logoindex++;
                if (logoindex >= slogoname.length) {
                    logoindex = 0;
                }
                break;
            default:
                break;
        }

    }

    private class TIMEUP implements Runnable {
        @Override
        public void run() {
            ani.stop();
            tvmsg.setText("時間到");
        }
    }


}
