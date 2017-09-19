package com.example.student.lab02_courtcounter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTeam extends Fragment implements OnClickListener {

    private int number = 0;

//    private FrameLayout fl;

    private ImageView ivlogo;
    private TextView tvname;
    private TextView tvnumber;

    /*
        private Button b3;
        private Button b2;
        private Button br;
    */
    public FragmentTeam() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        ivlogo = getView().findViewById(R.id.logo);
        tvname = getView().findViewById(R.id.TextViewName);
        tvnumber = getView().findViewById(R.id.TextViewNumber);
/*
        b3 = getView().findViewById(R.id.ButtonB3);
        b2 = getView().findViewById(R.id.ButtonB2);
        br = getView().findViewById(R.id.ButtonBr);
        b3.setOnClickListener(this);
        b2.setOnClickListener(this);
        br.setOnClickListener(this);
*/
        getView().findViewById(R.id.ButtonB3).setOnClickListener(this);
        getView().findViewById(R.id.ButtonB2).setOnClickListener(this);
        getView().findViewById(R.id.ButtonBr).setOnClickListener(this);
    }

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
            default:
                break;
        }
        display();

    }

    private void display() {
        tvnumber.setText(Integer.toString(number));
    }

    public void setReset() {
        number = 0;
        display();
    }

    public void setName(CharSequence name) {
        tvname.setText(name);
    }

    public void setLogo(int r) {
        if (ivlogo != null) {
            ivlogo.setImageResource(r);
        }
    }

}
