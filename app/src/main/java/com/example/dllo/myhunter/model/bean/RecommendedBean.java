package com.example.dllo.myhunter.model.bean;

import java.util.List;

/**
 * 发现页面的实体类
 */
public class RecommendedBean {

    private int status;
    private String message;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private OtherProductsBean other_products;
        private String became_hunter_url;
        private SpotsBean spots;
        private List<HuntersBean> tags;
        private List<ProductModulesBean> product_modules;
        private List<BannersBean> banners;

        public OtherProductsBean getOther_products() {
            return other_products;
        }

        public void setOther_products(OtherProductsBean other_products) {
            this.other_products = other_products;
        }

        public String getBecame_hunter_url() {
            return became_hunter_url;
        }

        public void setBecame_hunter_url(String became_hunter_url) {
            this.became_hunter_url = became_hunter_url;
        }

        public SpotsBean getSpots() {
            return spots;
        }

        public List<HuntersBean> getTags() {
            return tags;
        }

        public void setTags(List<HuntersBean> tags) {
            this.tags = tags;
        }

        public void setSpots(SpotsBean spots) {
            this.spots = spots;
        }

        public List<ProductModulesBean> getProduct_modules() {
            return product_modules;
        }

        public void setProduct_modules(List<ProductModulesBean> product_modules) {
            this.product_modules = product_modules;
        }

        public List<BannersBean> getBanners() {
            return banners;
        }

        public void setBanners(List<BannersBean> banners) {
            this.banners = banners;
        }

        public static class HuntersBean {
            private String title;
            private HunListBean hunter_list;
            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public HunListBean getHunter_list() {
                return hunter_list;
            }

            public void setHunter_list(HunListBean hunter_list) {
                this.hunter_list = hunter_list;
            }

            public static class HunListBean {
                private double goodcomment_rate;
                private String product_image;
                private String name;
                private String avatar_s;
                private String comment_text;
                private String avatar_l;
                private String avatar_m;
                private int product_id;
                private long id;
                private int product_title;

                public String getProduct_image() {
                    return product_image;
                }

                public void setProduct_image(String product_image) {
                    this.product_image = product_image;
                }

                public double getGoodcomment_rate() {
                    return goodcomment_rate;
                }

                public void setGoodcomment_rate(double goodcomment_rate) {
                    this.goodcomment_rate = goodcomment_rate;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getAvatar_s() {
                    return avatar_s;
                }

                public void setAvatar_s(String avatar_s) {
                    this.avatar_s = avatar_s;
                }

                public String getComment_text() {
                    return comment_text;
                }

                public void setComment_text(String comment_text) {
                    this.comment_text = comment_text;
                }

                public String getAvatar_l() {
                    return avatar_l;
                }

                public void setAvatar_l(String avatar_l) {
                    this.avatar_l = avatar_l;
                }

                public String getAvatar_m() {
                    return avatar_m;
                }

                public void setAvatar_m(String avatar_m) {
                    this.avatar_m = avatar_m;
                }

                public int getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(int product_id) {
                    this.product_id = product_id;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public int getProduct_title() {
                    return product_title;
                }

                public void setProduct_title(int product_title) {
                    this.product_title = product_title;
                }
            }
        }

        public static class OtherProductsBean {
            private String title;
            private List<ProdBean> product_list;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<ProdBean> getProduct_list() {
                return product_list;
            }

            public void setProduct_list(List<ProdBean> product_list) {
                this.product_list = product_list;
            }

            public static class ProdBean {
                private String distance;
                private int product_id;
                private boolean is_liked;
                private String title;
                private String title_page;
                private String address;
                private String is_new;
                private String discount_price;
                private int like_count;
                private String status;
                private int address_display_type;
                private boolean can_sell;
                private int sold_count;
                private int stock;
                private String date_str;
                private String price;
                private List<String> tab_list;
                private UserProdd userProdds;

                public UserProdd getUserProdds() {
                    return userProdds;
                }

                public void setUserProdds(UserProdd userProdds) {
                    this.userProdds = userProdds;
                }

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

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getIs_new() {
                    return is_new;
                }

                public void setIs_new(String is_new) {
                    this.is_new = is_new;
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

                public int getAddress_display_type() {
                    return address_display_type;
                }

                public void setAddress_display_type(int address_display_type) {
                    this.address_display_type = address_display_type;
                }

                public boolean isCan_sell() {
                    return can_sell;
                }

                public void setCan_sell(boolean can_sell) {
                    this.can_sell = can_sell;
                }

                public int getSold_count() {
                    return sold_count;
                }

                public void setSold_count(int sold_count) {
                    this.sold_count = sold_count;
                }

                public int getStock() {
                    return stock;
                }

                public void setStock(int stock) {
                    this.stock = stock;
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

                public List<String> getTab_list() {
                    return tab_list;
                }

                public void setTab_list(List<String> tab_list) {
                    this.tab_list = tab_list;
                }

                public static class UserProdd {
                    private int id;
                    private String avatar_l;
                    private String name;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
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

        public static class SpotsBean {
            private String more_url;
            private String title;
            private List<SpotListBean> spot_list;

            public String getMore_url() {
                return more_url;
            }

            public void setMore_url(String more_url) {
                this.more_url = more_url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<SpotListBean> getSpot_list() {
                return spot_list;
            }

            public void setSpot_list(List<SpotListBean> spot_list) {
                this.spot_list = spot_list;
            }

            public static class SpotListBean {
                private TargetBean target;
                private String text;
                private HunUserBean user;
                private long spot_id;
                private String cover_image;
                private long trip_id;

                public TargetBean getTarget() {
                    return target;
                }

                public void setTarget(TargetBean target) {
                    this.target = target;
                }

                public HunUserBean getUser() {
                    return user;
                }

                public void setUser(HunUserBean user) {
                    this.user = user;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public long getSpot_id() {
                    return spot_id;
                }

                public void setSpot_id(long spot_id) {
                    this.spot_id = spot_id;
                }

                public String getCover_image() {
                    return cover_image;
                }

                public void setCover_image(String cover_image) {
                    this.cover_image = cover_image;
                }

                public long getTrip_id() {
                    return trip_id;
                }

                public void setTrip_id(long trip_id) {
                    this.trip_id = trip_id;
                }

                public static class HunUserBean {
                    private long id;
                    private String avatar_s;
                    private String name;
                    private String avatar_l;
                    private String avatar_m;

                    public long getId() {
                        return id;
                    }

                    public void setId(long id) {
                        this.id = id;
                    }

                    public String getAvatar_s() {
                        return avatar_s;
                    }

                    public void setAvatar_s(String avatar_s) {
                        this.avatar_s = avatar_s;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getAvatar_l() {
                        return avatar_l;
                    }

                    public void setAvatar_l(String avatar_l) {
                        this.avatar_l = avatar_l;
                    }

                    public String getAvatar_m() {
                        return avatar_m;
                    }

                    public void setAvatar_m(String avatar_m) {
                        this.avatar_m = avatar_m;
                    }
                }

                public static class TargetBean {
                    private int market_price;
                    private int min_price;
                    private int type;
                    private String title;
                    private String url;
                    private String title_prefix;
                    private String depart_place;
                    private String icon_type;
                    private String cover;
                    private int id;

                    public int getMarket_price() {
                        return market_price;
                    }

                    public void setMarket_price(int market_price) {
                        this.market_price = market_price;
                    }

                    public int getMin_price() {
                        return min_price;
                    }

                    public void setMin_price(int min_price) {
                        this.min_price = min_price;
                    }

                    public int getType() {
                        return type;
                    }

                    public void setType(int type) {
                        this.type = type;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getTitle_prefix() {
                        return title_prefix;
                    }

                    public void setTitle_prefix(String title_prefix) {
                        this.title_prefix = title_prefix;
                    }

                    public String getDepart_place() {
                        return depart_place;
                    }

                    public void setDepart_place(String depart_place) {
                        this.depart_place = depart_place;
                    }

                    public String getIcon_type() {
                        return icon_type;
                    }

                    public void setIcon_type(String icon_type) {
                        this.icon_type = icon_type;
                    }

                    public String getCover() {
                        return cover;
                    }

                    public void setCover(String cover) {
                        this.cover = cover;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }
                }
            }
        }

        public static class ProductModulesBean {
            private String more_url;
            private String title;
            private List<Product> product_list;

            public String getMore_url() {
                return more_url;
            }

            public void setMore_url(String more_url) {
                this.more_url = more_url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<Product> getProduct_list() {
                return product_list;
            }

            public void setProduct_list(List<Product> product_list) {
                this.product_list = product_list;
            }

            public static class Product {
                private UserProdasg prodasgs;
                private int product_id;
                private String title;
                private String title_page;
                private int like_count;
                private String address;
                private String price;
                private String status;
                private int address_display_type;
                private int sold_count;
                private int stock;

                public int getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(int product_id) {
                    this.product_id = product_id;
                }

                public int getAddress_display_type() {
                    return address_display_type;
                }

                public void setAddress_display_type(int address_display_type) {
                    this.address_display_type = address_display_type;
                }

                public int getSold_count() {
                    return sold_count;
                }

                public void setSold_count(int sold_count) {
                    this.sold_count = sold_count;
                }

                public int getStock() {
                    return stock;
                }

                public void setStock(int stock) {
                    this.stock = stock;
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

                public int getLike_count() {
                    return like_count;
                }

                public void setLike_count(int like_count) {
                    this.like_count = like_count;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }



                public UserProdasg getProdasgs() {
                    return prodasgs;
                }

                public void setProdasgs(UserProdasg prodasgs) {
                    this.prodasgs = prodasgs;
                }

                public static class UserProdasg {
                    private int id;
                    private String avatar_l;
                    private String name;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
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

        public static class BannersBean {
            private String url;
            private String img_url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }
        }
    }
}

