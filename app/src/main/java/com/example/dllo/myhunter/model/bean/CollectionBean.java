package com.example.dllo.myhunter.model.bean;

/**
 * Created by dllo on 16/8/24.
 * 存入数据库的实体类
 */
public class CollectionBean {
    private int _id;
    private String url;
    private String content;
    private String price;
    private String address;

    public CollectionBean(String url, String content, String price, String address) {
        this.url = url;
        this.content = content;
        this.price = price;
        this.address = address;
    }

    public CollectionBean() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
