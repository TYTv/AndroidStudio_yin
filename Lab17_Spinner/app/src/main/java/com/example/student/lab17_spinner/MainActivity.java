package com.example.student.lab17_spinner;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements MyDialogFragment.FragOkCancel
        , AdapterView.OnItemSelectedListener
        , AdapterView.OnItemClickListener {

    private DialogFragment df;

    private FloatingActionButton fab;
    private static final String TAG = "MainActivity";
    //    private StringBuilder OrderList = new StringBuilder();
    private ListView lv;
    private List<Coffee> OrderList = new ArrayList<>();

    public List<Coffee> getOrderList() {
        return OrderList;
    }

    //==========AdapterView.OnItemClickListener==========
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Snackbar.make(fab, "點選了第 " + i + "項", Snackbar.LENGTH_LONG).setAction("Action", null).show();

//        ((MyDialogFragment)df).setModify(true);
//        ((MyDialogFragment)df).setModify_pos(i);

//        df.show(getSupportFragmentManager(), "MY DIALOG");

        df = new MyDialogFragment(i, OrderList.get(i));
        df.show(getSupportFragmentManager(), "MY MODIFY DIALOG");


    }

    //==========AdapterView.OnItemSelectedListener==========
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d(TAG, "項目選擇 : 位置是 : " + i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(TAG, "項目選擇 : 什麼都沒有選!!");
    }


    //==========MyDialogFragment.FragOkCancel==========
    @Override
    public void doFragOk(Coffee coff) {
        Snackbar.make(fab, "收到的訂單" + coff, Snackbar.LENGTH_LONG).setAction("Action", null).show();
        Log.d(TAG, "收到的訂單 = " + coff);

//        OrderList.append(coff + "\n");
//        TextView tv = (TextView) findViewById(R.id.TextViewOrderList);
//        tv.setText("目前收到的訂單 : \n" + OrderList);

        OrderList.add(coff);        // 新增一筆 Order
        ((MyListAdapter) lv.getAdapter()).notifyDataSetChanged();


    }

    @Override
    public void doFragCancel() {
        Snackbar.make(fab, "按下了取消", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    @Override
    public void doFragDelete(int item) {
        Snackbar.make(fab, "按下了刪除", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        OrderList.remove(item);       // 刪除一筆 Order
        ((MyListAdapter) lv.getAdapter()).notifyDataSetChanged();
    }

    @Override
    public void doFragModify(int item, Coffee coff) {
        Snackbar.make(fab, "按下了修改", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        OrderList.set(item, coff);       // 修改一筆 Order
        ((MyListAdapter) lv.getAdapter()).notifyDataSetChanged();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Snackbar.make(view, "Hello world !", Snackbar.LENGTH_SHORT).setAction("Action", null).show();

//                ((MyDialogFragment)df).setModify(false);
                df = new MyDialogFragment();
                df.show(getSupportFragmentManager(), "MY DIALOG");

            }
        });

        // Init ListView
        lv = (ListView) findViewById(R.id.ListViewMain);
        lv.setEmptyView(findViewById(R.id.TextViewListId));
        lv.setAdapter(new MyListAdapter(this));
        lv.setOnItemClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private static final String FILENAME = "order.ser";         // 檔名

    private void SAVE() {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            try {
                fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);       // 開檔
                oos = new ObjectOutputStream(fos);                                 // 檔案交給輸出資料流
                oos.writeObject(OrderList);                                         // 寫入物件
                Log.d(TAG, "存檔成功");
            } finally {
                if (oos != null) {
                    oos.close();                                                    // 關檔
                }
            }
        } catch (FileNotFoundException e) {
            Log.d(TAG, e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            Log.d(TAG, e.toString());
            e.printStackTrace();
        }


    }


    private void RESTORE() {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            try {
                fis = openFileInput(FILENAME);
                ois = new ObjectInputStream(fis);
                OrderList = (List) ois.readObject();
                Log.d(TAG, "讀檔成功");
            } finally {
                if (fis != null) {
                    fis.close();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    @Override
    protected void onStart() {
        super.onStart();

        RESTORE();
        ((MyListAdapter) lv.getAdapter()).notifyDataSetChanged();       // 通知已經更新 ListView

    }

    @Override
    protected void onStop() {
        super.onStop();

        SAVE();

    }
}
