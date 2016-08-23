package com.example.dllo.myhunter.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dllo on 16/8/20.
 */
public class RecommendedStarHunterJumpBean {

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

        private UserInfoBean user_info;


        private ProductsBean products;

        private TripsBean trips;


        private UrlsBean urls;


        private ClientCommentsBean client_comments;

        public UserInfoBean getUser_info() {
            return user_info;
        }

        public void setUser_info(UserInfoBean user_info) {
            this.user_info = user_info;
        }

        public ProductsBean getProducts() {
            return products;
        }

        public void setProducts(ProductsBean products) {
            this.products = products;
        }

        public TripsBean getTrips() {
            return trips;
        }

        public void setTrips(TripsBean trips) {
            this.trips = trips;
        }

        public UrlsBean getUrls() {
            return urls;
        }

        public void setUrls(UrlsBean urls) {
            this.urls = urls;
        }

        public ClientCommentsBean getClient_comments() {
            return client_comments;
        }

        public void setClient_comments(ClientCommentsBean client_comments) {
            this.client_comments = client_comments;
        }

        public static class UserInfoBean {
            private String resident_city_id;
            private int relationship;
            private String avatar_m;
            private String profession;
            private String custom_url;
            private String birthday;
            private int followings_count;
            private String avatar_s;
            private Object country_code;
            private long id;
            private String user_desc;
            private int goodcomment_rate;
            private String location_name;
            private String name;
            /**
             * verified : false
             * name :
             */

            private TitleBean title;
            private String mobile;
            private int gender;
            private String cover;
            /**
             * value : 388
             * level_info : {"name":"","value":2}
             */

            private ExperienceBean experience;
            private int receive_rate;
            private int followers_count;
            private int points;
            private Object country_num;
            private String avatar_l;
            private boolean email_verified;
            private boolean is_hunter;
            private boolean cdc2;
            private int reply_rate;
            private String email;

            public String getResident_city_id() {
                return resident_city_id;
            }

            public void setResident_city_id(String resident_city_id) {
                this.resident_city_id = resident_city_id;
            }

            public int getRelationship() {
                return relationship;
            }

            public void setRelationship(int relationship) {
                this.relationship = relationship;
            }

            public String getAvatar_m() {
                return avatar_m;
            }

            public void setAvatar_m(String avatar_m) {
                this.avatar_m = avatar_m;
            }

            public String getProfession() {
                return profession;
            }

            public void setProfession(String profession) {
                this.profession = profession;
            }

            public String getCustom_url() {
                return custom_url;
            }

            public void setCustom_url(String custom_url) {
                this.custom_url = custom_url;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public int getFollowings_count() {
                return followings_count;
            }

            public void setFollowings_count(int followings_count) {
                this.followings_count = followings_count;
            }

            public String getAvatar_s() {
                return avatar_s;
            }

            public void setAvatar_s(String avatar_s) {
                this.avatar_s = avatar_s;
            }

            public Object getCountry_code() {
                return country_code;
            }

            public void setCountry_code(Object country_code) {
                this.country_code = country_code;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getUser_desc() {
                return user_desc;
            }

            public void setUser_desc(String user_desc) {
                this.user_desc = user_desc;
            }

            public int getGoodcomment_rate() {
                return goodcomment_rate;
            }

            public void setGoodcomment_rate(int goodcomment_rate) {
                this.goodcomment_rate = goodcomment_rate;
            }

            public String getLocation_name() {
                return location_name;
            }

            public void setLocation_name(String location_name) {
                this.location_name = location_name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public TitleBean getTitle() {
                return title;
            }

            public void setTitle(TitleBean title) {
                this.title = title;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public ExperienceBean getExperience() {
                return experience;
            }

            public void setExperience(ExperienceBean experience) {
                this.experience = experience;
            }

            public int getReceive_rate() {
                return receive_rate;
            }

            public void setReceive_rate(int receive_rate) {
                this.receive_rate = receive_rate;
            }

            public int getFollowers_count() {
                return followers_count;
            }

            public void setFollowers_count(int followers_count) {
                this.followers_count = followers_count;
            }

            public int getPoints() {
                return points;
            }

            public void setPoints(int points) {
                this.points = points;
            }

            public Object getCountry_num() {
                return country_num;
            }

            public void setCountry_num(Object country_num) {
                this.country_num = country_num;
            }

            public String getAvatar_l() {
                return avatar_l;
            }

            public void setAvatar_l(String avatar_l) {
                this.avatar_l = avatar_l;
            }

            public boolean isEmail_verified() {
                return email_verified;
            }

            public void setEmail_verified(boolean email_verified) {
                this.email_verified = email_verified;
            }

            public boolean isIs_hunter() {
                return is_hunter;
            }

            public void setIs_hunter(boolean is_hunter) {
                this.is_hunter = is_hunter;
            }

            public boolean isCdc2() {
                return cdc2;
            }

            public void setCdc2(boolean cdc2) {
                this.cdc2 = cdc2;
            }

            public int getReply_rate() {
                return reply_rate;
            }

            public void setReply_rate(int reply_rate) {
                this.reply_rate = reply_rate;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public static class TitleBean {
                private boolean verified;
                private String name;

                public boolean isVerified() {
                    return verified;
                }

                public void setVerified(boolean verified) {
                    this.verified = verified;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }

            public static class ExperienceBean {
                private int value;
                /**
                 * name :
                 * value : 2
                 */

                private LevelInfoBean level_info;

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }

                public LevelInfoBean getLevel_info() {
                    return level_info;
                }

                public void setLevel_info(LevelInfoBean level_info) {
                    this.level_info = level_info;
                }

                public static class LevelInfoBean {
                    private String name;
                    private int value;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getValue() {
                        return value;
                    }

                    public void setValue(int value) {
                        this.value = value;
                    }
                }
            }
        }

        public static class ProductsBean {
            private int total_count;
            private boolean more;
            /**
             * tab_list : ["美食","城市探索"]
             * distance :
             * product_id : 10986
             * is_liked : false
             * title : 牙尖吃货带你挖出成都隐市美食！
             * title_page : http://photos.breadtrip.com/hunter/product/cover/16465795_o_1a7mq366iiin1gig1ea015b2tc12a.jpg?imageView2/5/w/788/h/426/format/jpg/interlace/1/
             * is_new :
             * can_sell : true
             * discount_price :
             * like_count : 110
             * status : prebook
             * user : {"id":2384120377,"avatar_l":"http://photos.breadtrip.com/avatar_4b_5b_2c706ef8fc6a36f42363434ca34e3513b1a47413.jpg-avatar.l","name":"irises_12"}
             * address_display_type : 1
             * address : 东环广场
             * sold_count : 76
             * date_str : 08.27-12.31
             * price : 20
             * stock : 74
             */

            private List<DataBeanOne> data;

            public int getTotal_count() {
                return total_count;
            }

            public void setTotal_count(int total_count) {
                this.total_count = total_count;
            }

            public boolean isMore() {
                return more;
            }

            public void setMore(boolean more) {
                this.more = more;
            }

            public List<DataBeanOne> getData() {
                return data;
            }

            public void setData(List<DataBeanOne> data) {
                this.data = data;
            }

            public static class DataBeanOne {
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

        public static class TripsBean {
            private int total_count;
            private boolean more;


            private List<DataBeanTwo> data;

            public int getTotal_count() {
                return total_count;
            }

            public void setTotal_count(int total_count) {
                this.total_count = total_count;
            }

            public boolean isMore() {
                return more;
            }

            public void setMore(boolean more) {
                this.more = more;
            }

            public List<DataBeanTwo> getData() {
                return data;
            }

            public void setData(List<DataBeanTwo> data) {
                this.data = data;
            }

            public static class DataBeanTwo {
                private int waypoints;
                private boolean wifi_sync;
                private int total_comments_count;
                private long id;
                private int view_count;
                private int privacy;
                private int day_count;
                private int version;
                private int liked_count;
                private int spot_count;
                private double mileage;
                private String description;
                private double last_modified;
                private boolean is_featured_trip;
                private String cover_image_default;
                private double date_complete;
                private int device;
                private double date_added;
                private String cover_image_w640;
                private String name;
                @SerializedName("default")
                private boolean defaultX;
                private String cover_image_1600;
                private boolean is_hot_trip;
                private int recommendations;
                private String cover_image;

                public int getWaypoints() {
                    return waypoints;
                }

                public void setWaypoints(int waypoints) {
                    this.waypoints = waypoints;
                }

                public boolean isWifi_sync() {
                    return wifi_sync;
                }

                public void setWifi_sync(boolean wifi_sync) {
                    this.wifi_sync = wifi_sync;
                }

                public int getTotal_comments_count() {
                    return total_comments_count;
                }

                public void setTotal_comments_count(int total_comments_count) {
                    this.total_comments_count = total_comments_count;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public int getView_count() {
                    return view_count;
                }

                public void setView_count(int view_count) {
                    this.view_count = view_count;
                }

                public int getPrivacy() {
                    return privacy;
                }

                public void setPrivacy(int privacy) {
                    this.privacy = privacy;
                }

                public int getDay_count() {
                    return day_count;
                }

                public void setDay_count(int day_count) {
                    this.day_count = day_count;
                }

                public int getVersion() {
                    return version;
                }

                public void setVersion(int version) {
                    this.version = version;
                }

                public int getLiked_count() {
                    return liked_count;
                }

                public void setLiked_count(int liked_count) {
                    this.liked_count = liked_count;
                }

                public int getSpot_count() {
                    return spot_count;
                }

                public void setSpot_count(int spot_count) {
                    this.spot_count = spot_count;
                }

                public double getMileage() {
                    return mileage;
                }

                public void setMileage(double mileage) {
                    this.mileage = mileage;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public double getLast_modified() {
                    return last_modified;
                }

                public void setLast_modified(double last_modified) {
                    this.last_modified = last_modified;
                }

                public boolean isIs_featured_trip() {
                    return is_featured_trip;
                }

                public void setIs_featured_trip(boolean is_featured_trip) {
                    this.is_featured_trip = is_featured_trip;
                }

                public String getCover_image_default() {
                    return cover_image_default;
                }

                public void setCover_image_default(String cover_image_default) {
                    this.cover_image_default = cover_image_default;
                }

                public double getDate_complete() {
                    return date_complete;
                }

                public void setDate_complete(double date_complete) {
                    this.date_complete = date_complete;
                }

                public int getDevice() {
                    return device;
                }

                public void setDevice(int device) {
                    this.device = device;
                }

                public double getDate_added() {
                    return date_added;
                }

                public void setDate_added(double date_added) {
                    this.date_added = date_added;
                }

                public String getCover_image_w640() {
                    return cover_image_w640;
                }

                public void setCover_image_w640(String cover_image_w640) {
                    this.cover_image_w640 = cover_image_w640;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public boolean isDefaultX() {
                    return defaultX;
                }

                public void setDefaultX(boolean defaultX) {
                    this.defaultX = defaultX;
                }

                public String getCover_image_1600() {
                    return cover_image_1600;
                }

                public void setCover_image_1600(String cover_image_1600) {
                    this.cover_image_1600 = cover_image_1600;
                }

                public boolean isIs_hot_trip() {
                    return is_hot_trip;
                }

                public void setIs_hot_trip(boolean is_hot_trip) {
                    this.is_hot_trip = is_hot_trip;
                }

                public int getRecommendations() {
                    return recommendations;
                }

                public void setRecommendations(int recommendations) {
                    this.recommendations = recommendations;
                }

                public String getCover_image() {
                    return cover_image;
                }

                public void setCover_image(String cover_image) {
                    this.cover_image = cover_image;
                }
            }
        }

        public static class UrlsBean {
            private String order_center;
            private String became_hunter;
            private String my_wallet;

            public String getOrder_center() {
                return order_center;
            }

            public void setOrder_center(String order_center) {
                this.order_center = order_center;
            }

            public String getBecame_hunter() {
                return became_hunter;
            }

            public void setBecame_hunter(String became_hunter) {
                this.became_hunter = became_hunter;
            }

            public String getMy_wallet() {
                return my_wallet;
            }

            public void setMy_wallet(String my_wallet) {
                this.my_wallet = my_wallet;
            }
        }

        public static class ClientCommentsBean {
            private int total_count;
            private boolean more;

            private List<DataBeanThree> data;

            public int getTotal_count() {
                return total_count;
            }

            public void setTotal_count(int total_count) {
                this.total_count = total_count;
            }

            public boolean isMore() {
                return more;
            }

            public void setMore(boolean more) {
                this.more = more;
            }

            public List<DataBeanThree> getData() {
                return data;
            }

            public void setData(List<DataBeanThree> data) {
                this.data = data;
            }

            public static class DataBeanThree {
                private String comment_private;
                private String client_url;
                private String hunter_avatar;
                private double star;
                private String hunter_url;
                private int order_id;
                private String client_name;
                private String product_title;
                private int datetime;
                private String product_url;
                private long hunter_id;
                private long client_id;
                private String hunter_name;
                private String datetime_formatted;
                private String comment_public;
                private String client_avatar;
                private int product_id;

                public String getComment_private() {
                    return comment_private;
                }

                public void setComment_private(String comment_private) {
                    this.comment_private = comment_private;
                }

                public String getClient_url() {
                    return client_url;
                }

                public void setClient_url(String client_url) {
                    this.client_url = client_url;
                }

                public String getHunter_avatar() {
                    return hunter_avatar;
                }

                public void setHunter_avatar(String hunter_avatar) {
                    this.hunter_avatar = hunter_avatar;
                }

                public double getStar() {
                    return star;
                }

                public void setStar(double star) {
                    this.star = star;
                }

                public String getHunter_url() {
                    return hunter_url;
                }

                public void setHunter_url(String hunter_url) {
                    this.hunter_url = hunter_url;
                }

                public int getOrder_id() {
                    return order_id;
                }

                public void setOrder_id(int order_id) {
                    this.order_id = order_id;
                }

                public String getClient_name() {
                    return client_name;
                }

                public void setClient_name(String client_name) {
                    this.client_name = client_name;
                }

                public String getProduct_title() {
                    return product_title;
                }

                public void setProduct_title(String product_title) {
                    this.product_title = product_title;
                }

                public int getDatetime() {
                    return datetime;
                }

                public void setDatetime(int datetime) {
                    this.datetime = datetime;
                }

                public String getProduct_url() {
                    return product_url;
                }

                public void setProduct_url(String product_url) {
                    this.product_url = product_url;
                }

                public long getHunter_id() {
                    return hunter_id;
                }

                public void setHunter_id(long hunter_id) {
                    this.hunter_id = hunter_id;
                }

                public long getClient_id() {
                    return client_id;
                }

                public void setClient_id(long client_id) {
                    this.client_id = client_id;
                }

                public String getHunter_name() {
                    return hunter_name;
                }

                public void setHunter_name(String hunter_name) {
                    this.hunter_name = hunter_name;
                }

                public String getDatetime_formatted() {
                    return datetime_formatted;
                }

                public void setDatetime_formatted(String datetime_formatted) {
                    this.datetime_formatted = datetime_formatted;
                }

                public String getComment_public() {
                    return comment_public;
                }

                public void setComment_public(String comment_public) {
                    this.comment_public = comment_public;
                }

                public String getClient_avatar() {
                    return client_avatar;
                }

                public void setClient_avatar(String client_avatar) {
                    this.client_avatar = client_avatar;
                }

                public int getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(int product_id) {
                    this.product_id = product_id;
                }
            }
        }
    }
}
