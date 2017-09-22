package com.example.student.lab08_quizzes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickAll(View view) {
        Intent it = new Intent();
        it.setClass(this, StartActivity.class);
        startActivity(it);
    }
}
