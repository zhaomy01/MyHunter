package com.example.dllo.myhunter.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 故事详情页面
 */
public class StoryDetailsBean {
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
        private SpotBean spot;
        private TripBean trip;

        public SpotBean getSpot() {
            return spot;
        }

        public void setSpot(SpotBean spot) {
            this.spot = spot;
        }

        public TripBean getTrip() {
            return trip;
        }

        public void setTrip(TripBean trip) {
            this.trip = trip;
        }

        public static class SpotBean {
            private boolean is_hiding_location;
            private String text;
            private boolean is_liked;
            private String poi;
            private long spot_id;
            private int recommendations_count;
            private boolean is_author;
            private long trip_id;
            private String cover_image_w640;
            private CenterPointBean center_point;
            private int view_count;
            private String location_alias;
            private TargetBean target;
            private String cover_image_1600;
            private int cover_image_height;
            private RegionBean region;
            private String cover_image_s;
            private String share_url;
            private String timezone;
            private int comments_count;
            private String cover_image;
            private String date_tour;
            private int cover_image_width;
            private List<RecommendationsBean> recommendations;
            private List<?> comments;
            private List<DetailListBean> detail_list;

            public boolean isIs_hiding_location() {
                return is_hiding_location;
            }

            public void setIs_hiding_location(boolean is_hiding_location) {
                this.is_hiding_location = is_hiding_location;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public boolean isIs_liked() {
                return is_liked;
            }

            public void setIs_liked(boolean is_liked) {
                this.is_liked = is_liked;
            }

            public String getPoi() {
                return poi;
            }

            public void setPoi(String poi) {
                this.poi = poi;
            }

            public long getSpot_id() {
                return spot_id;
            }

            public void setSpot_id(long spot_id) {
                this.spot_id = spot_id;
            }

            public int getRecommendations_count() {
                return recommendations_count;
            }

            public void setRecommendations_count(int recommendations_count) {
                this.recommendations_count = recommendations_count;
            }

            public boolean isIs_author() {
                return is_author;
            }

            public void setIs_author(boolean is_author) {
                this.is_author = is_author;
            }

            public long getTrip_id() {
                return trip_id;
            }

            public void setTrip_id(long trip_id) {
                this.trip_id = trip_id;
            }

            public String getCover_image_w640() {
                return cover_image_w640;
            }

            public void setCover_image_w640(String cover_image_w640) {
                this.cover_image_w640 = cover_image_w640;
            }

            public CenterPointBean getCenter_point() {
                return center_point;
            }

            public void setCenter_point(CenterPointBean center_point) {
                this.center_point = center_point;
            }

            public int getView_count() {
                return view_count;
            }

            public void setView_count(int view_count) {
                this.view_count = view_count;
            }

            public String getLocation_alias() {
                return location_alias;
            }

            public void setLocation_alias(String location_alias) {
                this.location_alias = location_alias;
            }

            public TargetBean getTarget() {
                return target;
            }

            public void setTarget(TargetBean target) {
                this.target = target;
            }

            public String getCover_image_1600() {
                return cover_image_1600;
            }

            public void setCover_image_1600(String cover_image_1600) {
                this.cover_image_1600 = cover_image_1600;
            }

            public int getCover_image_height() {
                return cover_image_height;
            }

            public void setCover_image_height(int cover_image_height) {
                this.cover_image_height = cover_image_height;
            }

            public RegionBean getRegion() {
                return region;
            }

            public void setRegion(RegionBean region) {
                this.region = region;
            }

            public String getCover_image_s() {
                return cover_image_s;
            }

            public void setCover_image_s(String cover_image_s) {
                this.cover_image_s = cover_image_s;
            }

            public String getShare_url() {
                return share_url;
            }

            public void setShare_url(String share_url) {
                this.share_url = share_url;
            }

            public String getTimezone() {
                return timezone;
            }

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }

            public int getComments_count() {
                return comments_count;
            }

            public void setComments_count(int comments_count) {
                this.comments_count = comments_count;
            }

            public String getCover_image() {
                return cover_image;
            }

            public void setCover_image(String cover_image) {
                this.cover_image = cover_image;
            }

            public String getDate_tour() {
                return date_tour;
            }

            public void setDate_tour(String date_tour) {
                this.date_tour = date_tour;
            }

            public int getCover_image_width() {
                return cover_image_width;
            }

            public void setCover_image_width(int cover_image_width) {
                this.cover_image_width = cover_image_width;
            }

            public List<RecommendationsBean> getRecommendations() {
                return recommendations;
            }

            public void setRecommendations(List<RecommendationsBean> recommendations) {
                this.recommendations = recommendations;
            }

            public List<?> getComments() {
                return comments;
            }

            public void setComments(List<?> comments) {
                this.comments = comments;
            }

            public List<DetailListBean> getDetail_list() {
                return detail_list;
            }

            public void setDetail_list(List<DetailListBean> detail_list) {
                this.detail_list = detail_list;
            }

            public static class CenterPointBean {
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

            public static class RegionBean {
                private String primary;
                private String secondary;

                public String getPrimary() {
                    return primary;
                }

                public void setPrimary(String primary) {
                    this.primary = primary;
                }

                public String getSecondary() {
                    return secondary;
                }

                public void setSecondary(String secondary) {
                    this.secondary = secondary;
                }
            }

            public static class RecommendationsBean {
                private String bio;
                private int gender;
                private boolean email_verified;
                private String location_name;
                private String name;
                private String resident_city_id;
                private String mobile;
                private String avatar_s;
                private String cover;
                private String custom_url;
                private String email;
                private String birthday;
                private String country_num;
                private String avatar_l;
                private String avatar_m;
                private boolean is_hunter;
                private String country_code;
                private long id;
                private String user_desc;

                public String getBio() {
                    return bio;
                }

                public void setBio(String bio) {
                    this.bio = bio;
                }

                public int getGender() {
                    return gender;
                }

                public void setGender(int gender) {
                    this.gender = gender;
                }

                public boolean isEmail_verified() {
                    return email_verified;
                }

                public void setEmail_verified(boolean email_verified) {
                    this.email_verified = email_verified;
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

                public String getResident_city_id() {
                    return resident_city_id;
                }

                public void setResident_city_id(String resident_city_id) {
                    this.resident_city_id = resident_city_id;
                }

                public String getMobile() {
                    return mobile;
                }

                public void setMobile(String mobile) {
                    this.mobile = mobile;
                }

                public String getAvatar_s() {
                    return avatar_s;
                }

                public void setAvatar_s(String avatar_s) {
                    this.avatar_s = avatar_s;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getCustom_url() {
                    return custom_url;
                }

                public void setCustom_url(String custom_url) {
                    this.custom_url = custom_url;
                }

                public String getEmail() {
                    return email;
                }

                public void setEmail(String email) {
                    this.email = email;
                }

                public String getBirthday() {
                    return birthday;
                }

                public void setBirthday(String birthday) {
                    this.birthday = birthday;
                }

                public String getCountry_num() {
                    return country_num;
                }

                public void setCountry_num(String country_num) {
                    this.country_num = country_num;
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

                public boolean isIs_hunter() {
                    return is_hunter;
                }

                public void setIs_hunter(boolean is_hunter) {
                    this.is_hunter = is_hunter;
                }

                public String getCountry_code() {
                    return country_code;
                }

                public void setCountry_code(String country_code) {
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
            }

            public static class DetailListBean {
                private int photo_width;
                private String photo_date_created;
                private String photo_s;
                private String text;
                private String photo_1600;
                private String timezone;
                private String photo_w640;
                private long detail_id;
                /**
                 * lat : 31.2097270439
                 * lng : 121.470900285
                 */

                private LocationBean location;
                private String photo;
                private int type;
                private int photo_height;

                public int getPhoto_width() {
                    return photo_width;
                }

                public void setPhoto_width(int photo_width) {
                    this.photo_width = photo_width;
                }

                public String getPhoto_date_created() {
                    return photo_date_created;
                }

                public void setPhoto_date_created(String photo_date_created) {
                    this.photo_date_created = photo_date_created;
                }

                public String getPhoto_s() {
                    return photo_s;
                }

                public void setPhoto_s(String photo_s) {
                    this.photo_s = photo_s;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getPhoto_1600() {
                    return photo_1600;
                }

                public void setPhoto_1600(String photo_1600) {
                    this.photo_1600 = photo_1600;
                }

                public String getTimezone() {
                    return timezone;
                }

                public void setTimezone(String timezone) {
                    this.timezone = timezone;
                }

                public String getPhoto_w640() {
                    return photo_w640;
                }

                public void setPhoto_w640(String photo_w640) {
                    this.photo_w640 = photo_w640;
                }

                public long getDetail_id() {
                    return detail_id;
                }

                public void setDetail_id(long detail_id) {
                    this.detail_id = detail_id;
                }

                public LocationBean getLocation() {
                    return location;
                }

                public void setLocation(LocationBean location) {
                    this.location = location;
                }

                public String getPhoto() {
                    return photo;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public int getPhoto_height() {
                    return photo_height;
                }

                public void setPhoto_height(int photo_height) {
                    this.photo_height = photo_height;
                }

                public static class LocationBean {
                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }
            }
        }

        public static class TripBean {
            private int day_count;
            private String name;
            private int privacy;
            @SerializedName("default")
            private boolean defaultX;
            private String cover_image_1600;
            private String cover_image_s;
            private boolean wifi_sync;
            private String cover_image_w640;
            private int version;
            private String share_url;
            private String date_added;
            private String cover_image;
            private String timezone;
            private boolean is_author;
            private String start_point;
            private long id;
            private RecommendationsBean user;

            public int getDay_count() {
                return day_count;
            }

            public void setDay_count(int day_count) {
                this.day_count = day_count;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPrivacy() {
                return privacy;
            }

            public void setPrivacy(int privacy) {
                this.privacy = privacy;
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

            public String getCover_image_s() {
                return cover_image_s;
            }

            public void setCover_image_s(String cover_image_s) {
                this.cover_image_s = cover_image_s;
            }

            public boolean isWifi_sync() {
                return wifi_sync;
            }

            public void setWifi_sync(boolean wifi_sync) {
                this.wifi_sync = wifi_sync;
            }

            public String getCover_image_w640() {
                return cover_image_w640;
            }

            public void setCover_image_w640(String cover_image_w640) {
                this.cover_image_w640 = cover_image_w640;
            }

            public int getVersion() {
                return version;
            }

            public void setVersion(int version) {
                this.version = version;
            }

            public String getShare_url() {
                return share_url;
            }

            public void setShare_url(String share_url) {
                this.share_url = share_url;
            }

            public String getDate_added() {
                return date_added;
            }

            public void setDate_added(String date_added) {
                this.date_added = date_added;
            }

            public String getCover_image() {
                return cover_image;
            }

            public void setCover_image(String cover_image) {
                this.cover_image = cover_image;
            }

            public String getTimezone() {
                return timezone;
            }

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }

            public boolean isIs_author() {
                return is_author;
            }

            public void setIs_author(boolean is_author) {
                this.is_author = is_author;
            }

            public String getStart_point() {
                return start_point;
            }

            public void setStart_point(String start_point) {
                this.start_point = start_point;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public RecommendationsBean getUser() {
                return user;
            }

            public void setUser(RecommendationsBean user) {
                this.user = user;
            }
            public static class RecommendationsBean{
                private String gender;
                private boolean email_verified;
                private String location_name;
                private String resident_city_id;
                private String mobile;
                private String name;
                private String avatar_s;
                private String cover;
                private String avatar_l;
                private String avatar_m;
                private long id;
                private String user_desc;

                public String getGender() {
                    return gender;
                }

                public void setGender(String gender) {
                    this.gender = gender;
                }

                public boolean isEmail_verified() {
                    return email_verified;
                }

                public void setEmail_verified(boolean email_verified) {
                    this.email_verified = email_verified;
                }

                public String getLocation_name() {
                    return location_name;
                }

                public void setLocation_name(String location_name) {
                    this.location_name = location_name;
                }

                public String getResident_city_id() {
                    return resident_city_id;
                }

                public void setResident_city_id(String resident_city_id) {
                    this.resident_city_id = resident_city_id;
                }

                public String getMobile() {
                    return mobile;
                }

                public void setMobile(String mobile) {
                    this.mobile = mobile;
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

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
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
            }
        }
    }
}
