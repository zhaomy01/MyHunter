package com.example.dllo.myhunter.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/8/23.
 */
public class OverSeaJumpBean {


    private String publish_date;
    private int next_start;
    private String became_hunter_url;


    private List<ProductListBean> product_list;

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public int getNext_start() {
        return next_start;
    }

    public void setNext_start(int next_start) {
        this.next_start = next_start;
    }

    public String getBecame_hunter_url() {
        return became_hunter_url;
    }

    public void setBecame_hunter_url(String became_hunter_url) {
        this.became_hunter_url = became_hunter_url;
    }

    public List<ProductListBean> getProduct_list() {
        return product_list;
    }

    public void setProduct_list(List<ProductListBean> product_list) {
        this.product_list = product_list;
    }

    public static class ProductListBean {
        private String distance;
        private int product_id;
        private boolean is_liked;
        private String title;
        private String title_page;
        private String is_new;
        private boolean can_sell;
        private String discount_price;
        private int like_count;
        private String status;
        /**
         * id : 2384097342
         * avatar_l : http://photos.breadtrip.com/avatar_8c_3f_20ea84f4c3576de1e933bb72f1f8c9e7c751ba80.jpg-avatar.l
         * name : 小楠nan
         */

        private UserBean user;
        private int address_display_type;
        private String address;
        private int sold_count;
        private String date_str;
        private String price;
        private int stock;
        private List<String> tab_list;

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }

        public boolean isIs_liked() {
            return is_liked;
        }

        public void setIs_liked(boolean is_liked) {
            this.is_liked = is_liked;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle_page() {
            return title_page;
        }

        public void setTitle_page(String title_page) {
            this.title_page = title_page;
        }

        public String getIs_new() {
            return is_new;
        }

        public void setIs_new(String is_new) {
            this.is_new = is_new;
        }

        public boolean isCan_sell() {
            return can_sell;
        }

        public void setCan_sell(boolean can_sell) {
            this.can_sell = can_sell;
        }

        public String getDiscount_price() {
            return discount_price;
        }

        public void setDiscount_price(String discount_price) {
            this.discount_price = discount_price;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public int getAddress_display_type() {
            return address_display_type;
        }

        public void setAddress_display_type(int address_display_type) {
            this.address_display_type = address_display_type;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getSold_count() {
            return sold_count;
        }

        public void setSold_count(int sold_count) {
            this.sold_count = sold_count;
        }

        public String getDate_str() {
            return date_str;
        }

        public void setDate_str(String date_str) {
            this.date_str = date_str;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public List<String> getTab_list() {
            return tab_list;
        }

        public void setTab_list(List<String> tab_list) {
            this.tab_list = tab_list;
        }

        public static class UserBean {
            private long id;
            private String avatar_l;
            private String name;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getAvatar_l() {
                return avatar_l;
            }

            public void setAvatar_l(String avatar_l) {
                this.avatar_l = avatar_l;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
