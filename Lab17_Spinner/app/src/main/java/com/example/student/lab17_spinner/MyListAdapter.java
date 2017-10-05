package com.example.student.lab17_spinner;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by student on 2017/10/2.
 */

public class MyListAdapter extends BaseAdapter {

    private MainActivity act;

    public MyListAdapter(MainActivity act) {
        this.act = act;
    }

    @Override
    public int getCount() {
        return act.getOrderList().size();
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

        View v = act.getLayoutInflater().inflate(R.layout.layout_listview, null);

        TextView tvid = v.findViewById(R.id.TextViewListId);
        ImageView tvimage = v.findViewById(R.id.ImageViewListImage);
        TextView tvtitle = v.findViewById(R.id.TextViewListTitle);
        TextView tvprice = v.findViewById(R.id.TextViewListPrice);

        Coffee coff = (Coffee) act.getOrderList().get(i);
        tvid.setText("id");
        tvprice.setText(String.valueOf(coff.getPrice()));       // 價格
        tvtitle.setText(coff.getTitle());                   // 咖啡名
        tvimage.setImageResource(coff.getImg_res_id());     // 圖片

        return v;

    }


}
