package com.example.student.lab17_spinner;

import java.io.Serializable;

/**
 * Created by student on 2017/10/2.
 */

public class Coffee implements Serializable {       // 需要存成檔案，必須要 implement Serializable

    private String title;
    private int price;
    private int img_res_id;

    public Coffee(String title, int price, int img_res_id) {
        this.title = title;
        this.price = price;
        this.img_res_id = img_res_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImg_res_id() {
        return img_res_id;
    }

    public void setImg_res_id(int img_res_id) {
        this.img_res_id = img_res_id;
    }

    @Override
    public String toString() {
//        return super.toString();
        return "品項:" + title +",金額:" + price + ",資源ID:" + img_res_id;
    }
}
