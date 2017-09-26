package com.example.student.lab17_spinner;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialog extends android.support.v4.app.DialogFragment {


    public MyDialog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);

        Activity act = getActivity();

        LayoutInflater lif = act.getLayoutInflater();
        View v = lif.inflate(R.layout.fragment_dialog, null);


        Spinner spi = v.findViewById(R.id.SpinnerCoffee);
        SpinnerAdapter spiadp = new MySpinnerAdapter(act);
        spi.setAdapter(spiadp);


        AlertDialog.Builder adb = new AlertDialog.Builder(act);
        adb
                .setTitle("新增商品")
                .setIcon(R.mipmap.ic_launcher)
                .setView(v)
                .setPositiveButton("確定", null)
                .setNegativeButton("取消", null);

        return adb.create();

    }
}
