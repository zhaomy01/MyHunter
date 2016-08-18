package com.example.dllo.myhunter.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/8/15.
 */
public class FoundBean {

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
        private int next_start;

        private List<FeedsBean> feeds;
        private List<VideosBean> videos;

        public int getNext_start() {
            return next_start;
        }

        public void setNext_start(int next_start) {
            this.next_start = next_start;
        }

        public List<FeedsBean> getFeeds() {
            return feeds;
        }

        public void setFeeds(List<FeedsBean> feeds) {
            this.feeds = feeds;
        }

        public List<VideosBean> getVideos() {
            return videos;
        }

        public void setVideos(List<VideosBean> videos) {
            this.videos = videos;
        }

        public static class FeedsBean {
            private String category;
            private ProductBean product;
            private int product_id;
            private int comment_count;
            private int liked_count;

            private UserBean user;
            private Object spot_id;
            private String date_added;
            private String product_title;


            private List<LikedUsersBean> liked_users;

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public ProductBean getProduct() {
                return product;
            }

            public void setProduct(ProductBean product) {
                this.product = product;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public int getComment_count() {
                return comment_count;
            }

            public void setComment_count(int comment_count) {
                this.comment_count = comment_count;
            }

            public int getLiked_count() {
                return liked_count;
            }

            public void setLiked_count(int liked_count) {
                this.liked_count = liked_count;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public Object getSpot_id() {
                return spot_id;
            }

            public void setSpot_id(Object spot_id) {
                this.spot_id = spot_id;
            }

            public String getDate_added() {
                return date_added;
            }

            public void setDate_added(String date_added) {
                this.date_added = date_added;
            }

            public String getProduct_title() {
                return product_title;
            }

            public void setProduct_title(String product_title) {
                this.product_title = product_title;
            }

            public List<LikedUsersBean> getLiked_users() {
                return liked_users;
            }

            public void setLiked_users(List<LikedUsersBean> liked_users) {
                this.liked_users = liked_users;
            }

            public static class ProductBean {
                private Object distance;
                private String title;
                private String text;
                private String price;
                private String cover;
                private String address;
                private int id;

                public Object getDistance() {
                    return distance;
                }

                public void setDistance(Object distance) {
                    this.distance = distance;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }
            }

            public static class UserBean {
                private String username;
                private String avatar_s;
                private long id;

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getAvatar_s() {
                    return avatar_s;
                }

                public void setAvatar_s(String avatar_s) {
                    this.avatar_s = avatar_s;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }
            }

            public static class LikedUsersBean {
                private String username;
                private String avatar_s;
                private long id;

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getAvatar_s() {
                    return avatar_s;
                }

                public void setAvatar_s(String avatar_s) {
                    this.avatar_s = avatar_s;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }
            }
        }

        public static class VideosBean {
            private String show_url;
            private int product_id;
            private int views;
            private String price;
            private String cover;
            private Object distance;
            private int liked_count;
            private String address;
            private String product_title;

            public String getShow_url() {
                return show_url;
            }

            public void setShow_url(String show_url) {
                this.show_url = show_url;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public int getViews() {
                return views;
            }

            public void setViews(int views) {
                this.views = views;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public Object getDistance() {
                return distance;
            }

            public void setDistance(Object distance) {
                this.distance = distance;
            }

            public int getLiked_count() {
                return liked_count;
            }

            public void setLiked_count(int liked_count) {
                this.liked_count = liked_count;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getProduct_title() {
                return product_title;
            }

            public void setProduct_title(String product_title) {
                this.product_title = product_title;
            }
        }
    }
}
