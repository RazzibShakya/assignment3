package com.softwarica.assignment3;

public class Items {
    String item_name;
    String item_price;
    String item_des;
    int item_img;

    public Items(String item_name, String item_price, String item_des, int item_img) {
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_des = item_des;
        this.item_img = item_img;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public String getItem_des() {
        return item_des;
    }

    public void setItem_des(String item_des) {
        this.item_des = item_des;
    }

    public int getItem_img() {
        return item_img;
    }

    public void setItem_img(int item_img) {
        this.item_img = item_img;
    }
}
