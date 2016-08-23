package com.example.dllo.myhunter.model.net;

/**
 * Created by dllo on 16/8/15.
 * 网址常量类
 */
public class NetUrl {
    /**
     * 发现
     */
    public static final String FOUND_URL = "http://api.breadtrip.com/hunter/feeds/?lat=0.0&lng=0.0";
    /**
     * 发现Webview
     */
    public static final String FOUND_WEBVIEW_START = "http://web.breadtrip.com/hunter/product/";
    public static final String FOUND_WEBVIEW_END = "/?bts=app_discover_share";
    /**
     * 推荐页面整页接口
     */
    public static final String RECOMMENDED_URL = "http://api.breadtrip.com/hunter/products/newstyle/?city_name=%E5%85%A8%E9%83%A8%E5%9F%8E%E5%B8%82&lat=0.0&lng=0.0";
    /**
     * 推荐页面明星猎人跳转接口(拼接)
     */
    public static final String SH_HEAD_URL = "http://api.breadtrip.com/v3/user/";
    public static final String SH_TAIL_URL = "/";
    /**
     * 全部城市中国内数据的接口
     */
    public static final String DOMESTIC_URL = "http://api.breadtrip.com/hunter/products/v2/metadata/?with_citydata&with_sortdata&city_name=%E5%85%A8%E9%83%A8%E5%9F%8E%E5%B8%82";
    /**
     * 全部城市中海外数据的接口
     */
    public static final String OVERSEA_URL = "http://api.breadtrip.com/hunter/products/v2/metadata/?with_citydata&with_sortdata&city_name=%E5%85%A8%E9%83%A8%E5%9F%8E%E5%B8%82 ";
    /**
     * 全部城市跳转到Fragment中接口(拼接)
     */
    public static final String CITY_HEAD_URL = "http://api.breadtrip.com/hunter/products/newstyle/?city_name=";
    public static final String CITY_TAIL_URL = "&lat=0.0&lng=0.0";
    /**
     * 推荐页面明星猎人请求头内容
     */
    public static final String COOKIE_URL = "bt_devid=a_7609e79906d5f8b7685635c2efcdc4118315069380bba5daf6fe972abceffb98; sessionid=c2fca75a76e4b91069be74bc76d5c622; refer_android_source=43";
    public static final String HOST_URL = "api.breadtrip.com";
    public static final String USERAGENT_URL = "BreadTrip/android/7.0.1/zh (android OS5.1) vbox86p Map/AutoNavi/v1.4.2 (Google Nexus 5 - 5.1.0 - API 22 - 1080x1920,generic) Paros/3.2.13";
    /**
     * 毛玻璃效果图片网址
     */
    public static final String IMAGE_URL= "http://images.17173.com/2012/web/2012/07/16/q0716ar01s.jpg";


}
