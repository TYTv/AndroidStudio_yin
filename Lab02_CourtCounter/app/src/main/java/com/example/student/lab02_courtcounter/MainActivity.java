package com.example.student.lab02_courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    FragmentTeam ft1;
    FragmentTeam ft2;

    Button brst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ft1 = (FragmentTeam) getSupportFragmentManager().findFragmentById(R.id.FragmentTeam1);
        //        ((TextView) ft1.getView().findViewById(R.id.TextViewTeam)).setText("TEAM 1");
        // tv1 = (TextView) ft1.getView().findViewById(R.id.TextViewNumber);
        ft1.setName(getString(R.string.TeamName1));
        ft1.setLogo(R.drawable.hornets);


        ft2 = (FragmentTeam) getSupportFragmentManager().findFragmentById(R.id.FragmentTeam2);
        //       ((TextView) ft2.getView().findViewById(R.id.TextViewTeam)).setText("TEAM 2");
        // tv2 = (TextView) ft2.getView().findViewById(R.id.TextViewNumber);
        ft2.setName(getString(R.string.TeamName2));
        ft2.setLogo(R.drawable.rockets);

        brst = (Button) findViewById(R.id.ButtonRst);

    }

    public void onClickRst(View view) {
        ft1.setReset();
        ft2.setReset();
    }

    /*
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
    */








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
