package com.example.student.lab09_dialog;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class DialogFragment extends android.support.v4.app.DialogFragment {

    private EditText etusername;
    private EditText etpassword;

    public DialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        return super.onCreateDialog(savedInstanceState);

        LayoutInflater lif = getActivity().getLayoutInflater();

        View v = lif.inflate(R.layout.fragment_dialog, null);
        etusername = v.findViewById(R.id.EditTextUsername);
        etpassword = v.findViewById(R.id.EditTextPassword);

        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        adb.setView(v)
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Username : " + String.valueOf(etusername.getText()) + "\n");
                        sb.append("Password : " + String.valueOf(etpassword.getText()) + "\n");

                        TextView tv = getActivity().findViewById(R.id.TextViewMessage);
                        tv.setText(sb);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TextView tv = getActivity().findViewById(R.id.TextViewMessage);
                        tv.setText("unknow");
                    }
                });

        return (adb.create());

    }


}
