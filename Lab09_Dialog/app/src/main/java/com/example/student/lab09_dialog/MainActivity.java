package com.example.student.lab09_dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    private TextView tvm;
    private int mChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvm = (TextView) findViewById(R.id.TextViewMessage);

    }


    public void OnClickAll(View view) {

        final String[] rsp = getResources().getStringArray(R.array.Response);
        final boolean[] sel = new boolean[rsp.length];

        switch (view.getId()) {
            case R.id.ButtonOK:
                new AlertDialog.Builder(this)
                        .setMessage(" 你好帥哦")
                        .setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                tvm.setText("我知道了");
                            }
                        })
                        .show();
                break;
            case R.id.ButtonYN:
                new AlertDialog.Builder(this)
                        .setMessage(" 你好帥窩")
                        .setPositiveButton("謝謝", this)
                        .setNegativeButton("朕知道了", this)
                        .show();
                break;
            case R.id.ButtonYNC:
                onClickLisDialog ocld = new onClickLisDialog();
                new AlertDialog.Builder(this)
                        .setMessage("你好帥鵝")
                        .setPositiveButton("感謝", ocld)
                        .setNeutralButton("了解", ocld)
                        .setNegativeButton("不客氣", ocld)
                        .show();
                break;
            case R.id.ButtonItems:
                new AlertDialog.Builder(this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar)
                        .setTitle("你好帥")
                        .setItems(rsp, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                tvm.setText(rsp[i]);
                            }
                        })
                        .show();
                break;
            case R.id.ButtonMulitSelect:
                new AlertDialog.Builder(this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar)
                        .setTitle("你好帥")
                        .setMultiChoiceItems(rsp, sel, new DialogInterface.OnMultiChoiceClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                ;
                            }

                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                StringBuilder sb = new StringBuilder();

                                for (int f = 0; f < sel.length; f++) {
                                    if (sel[f] == true) {
                                        sb.append(rsp[f]);
                                        sb.append("\n");
                                    }
                                }
                                tvm.setText(sb);
                            }

                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ;
                            }

                        })
                        .show();
                break;
            case R.id.ButtonSingleSelect:
                mChoice = 0;
                new AlertDialog.Builder(this)
                        .setTitle("你好帥")
                        .setSingleChoiceItems(rsp, mChoice, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                mChoice = i;
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                tvm.setText(rsp[mChoice]);
                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                tvm.setText("無語");
                            }
                        })
                        .show();
                break;
            case R.id.ButtonFragment:
                DialogFragment df = new DialogFragment();
                df.show(getSupportFragmentManager(), "DialogFragment");
                break;
            default:
                break;
        }

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

        switch (i) {
            case DialogInterface.BUTTON_POSITIVE:
                tvm.setText("感謝");
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                tvm.setText("朕知道了");
                break;
            default:
                break;
        }

    }


    class onClickLisDialog implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

            switch (i) {
                case DialogInterface.BUTTON_POSITIVE:
                    tvm.setText("謝謝");
                    break;
                case DialogInterface.BUTTON_NEUTRAL:
                    tvm.setText("了解");
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    tvm.setText("不客氣");
                    break;
                default:
                    break;
            }

        }

    }


}
