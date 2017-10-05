package com.example.student.lab17_spinner;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialogFragment extends android.support.v4.app.DialogFragment {

    private int modify_item = -1;
    Coffee modify_coff = null;

    private Activity act;
    private View v;

    private Spinner spi;
    private SpinnerAdapter spiadp;

    private AlertDialog ad;
    private AlertDialog.Builder adb;

    private FragOkCancel foc;

    public interface FragOkCancel {
        void doFragOk(Coffee coff);

        void doFragCancel();

        void doFragDelete(int item);

        void doFragModify(int item, Coffee coff);
    }

    public MyDialogFragment() {
        // Required empty public constructor
    }

    public MyDialogFragment(int modify_item, Coffee modify_coff) {
        // Required empty public constructor
        this.modify_item = modify_item;
        this.modify_coff = modify_coff;
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

        act = getActivity();

        LayoutInflater lif = act.getLayoutInflater();
        v = lif.inflate(R.layout.fragment_dialog, null);

        initSpinner();

        return initDialog();

    }


    void initSpinner() {

        try {
            spi = v.findViewById(R.id.SpinnerCoffee);
            spiadp = new MySpinnerAdapter(act);
            spi.setAdapter(spiadp);
            spi.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) act);

            int pos = 0;
            if (modify_item >= 0) {             // 修改，顯示前回值
                // 找出原本選擇的項目
                for (; pos < ((MySpinnerAdapter) spiadp).getCount(); pos++) {
                    if (modify_coff.getTitle().equals(((MySpinnerAdapter) spiadp).getTitles().getString(pos)) == true) {
                        break;
                    }
                }
                EditText et = v.findViewById(R.id.EditTextPrice);
                et.setText(String.valueOf(modify_coff.getPrice()));
            }
            spi.setSelection(pos);

            foc = (FragOkCancel) getActivity();
        } catch (ClassCastException cause) {
            throw new MyDialogFragmentException("Activeiy 無法處理確定與取消", cause);
        }

    }


    AlertDialog initDialog() {

        adb = new AlertDialog.Builder(act);
        adb
                .setTitle("新增商品")
                .setIcon(R.mipmap.ic_launcher)
                .setView(v);

        if (modify_item < 0) {     // 初始化
            adb
                    .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            int pos = spi.getSelectedItemPosition();

                            String tit = ((MySpinnerAdapter) spiadp).getTitles().getString(pos);

                            EditText et = v.findViewById(R.id.EditTextPrice);
                            int pri;
                            try {
                                pri = Integer.parseInt(et.getText().toString());
                            } catch (RuntimeException e) {
                                pri = 0;
                            }

                            int rid = ((MySpinnerAdapter) spiadp).getImg_res_ids()[pos];

                            foc.doFragOk(new Coffee(tit, pri, rid));

                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            foc.doFragCancel();

                        }
                    });
        } else {                // 修改

            adb
                    .setPositiveButton("修改", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            int pos = spi.getSelectedItemPosition();

                            String tit = ((MySpinnerAdapter) spiadp).getTitles().getString(pos);

                            EditText et = v.findViewById(R.id.EditTextPrice);
                            int pri;
                            try {
                                pri = Integer.parseInt(et.getText().toString());
                            } catch (RuntimeException e) {
                                pri = 0;
                            }

                            int rid = ((MySpinnerAdapter) spiadp).getImg_res_ids()[pos];

                            foc.doFragModify(modify_item, new Coffee(tit, pri, rid));

                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            foc.doFragCancel();

                        }
                    })
                    .setNeutralButton("刪除", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    foc.doFragDelete(modify_item);
                                }
                            }
                    );
        }


        ad = adb.create();

        return ad;

    }


}
