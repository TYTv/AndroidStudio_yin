package com.example.student.lab17_spinner;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by student on 2017/9/26.
 */

public class MySpinnerAdapter extends BaseAdapter {

    private Activity act;

    public MySpinnerAdapter(Activity act) {
        this.act = act;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        return null;

        View v = act.getLayoutInflater().inflate(R.layout.layout_spinner, null);

        TextView tv = v.findViewById(R.id.TextViewTitle);
        String[] sarr = act.getResources().getStringArray(R.array.CoffieName);
        tv.setText(sarr[i]);

        ImageView iv = v.findViewById(R.id.ImageViewIcon);
        switch (i) {
            case 0:
                iv.setBackgroundResource(R.drawable.coffee_cappuccino);
                break;
            case 1:
                iv.setBackgroundResource(R.drawable.coffee_latte);
                break;
            case 2:
                iv.setBackgroundResource(R.drawable.coffee_macchiato);
                break;
            case 3:
                iv.setBackgroundResource(R.drawable.coffee_mocha);
                break;
        }

        return v;

    }


}
