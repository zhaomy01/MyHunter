package com.example.dllo.myhunter.ui.fragment;


import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.RecommendedBean;
import com.example.dllo.myhunter.model.bean.RecommendedStarHunterBean;
import com.example.dllo.myhunter.tools.network.DlaHttp;
import com.example.dllo.myhunter.tools.network.OnHttpCallback;
import com.example.dllo.myhunter.ui.adapter.RecommendedAdapter;
import com.example.dllo.myhunter.ui.adapter.RecommendedEditorAdapter;
import com.example.dllo.myhunter.ui.adapter.RecommendedHorizontalAdapter;
import com.example.dllo.myhunter.ui.adapter.RecommendedStarHunterAdapter;
import com.example.dllo.myhunter.view.HorizontalListView;
import com.example.dllo.myhunter.view.VerticalListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 推荐页面
 */
public class RecommendedFragment extends AbsBaseFragment {
    private ViewPager viewPager;
    private RecommendedAdapter recommendedAdapter;
    private RecommendedHorizontalAdapter blockbusterAdapter, lineAdapter, firstAdapter, featuresAdapter;
    private LinearLayout pointContainer, recommend_linearLayout;//小圆点容器
    private Handler handle;
    private Runnable rotateRunbale;
    private List<String> imgUrl;
    private HorizontalListView recommended_hlv_blockbuster, recommended_hlv_line, recommended_hlv_first, recommended_hlv_features, recommmended_starHunter_hlv,recommended_story_hlv;
    private VerticalListView recommended_vlv_editor;
    private RecommendedStarHunterAdapter starHunterAdapter,storyAdapter;
    private RecommendedEditorAdapter editorAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_recommended;
    }

    @Override
    protected void initViews() {
        viewPager = byView(R.id.recommended_vp_lbt);
        recommend_linearLayout = byView(R.id.recommend_linearLayout);
        pointContainer = byView(R.id.recommended_linea_yd);
        recommended_hlv_blockbuster = byView(R.id.recommended_hlv_blockbuster);
        recommended_hlv_line = byView(R.id.recommended_hlv_line);
        recommended_hlv_first = byView(R.id.recommended_hlv_first);
        recommended_hlv_features = byView(R.id.recommended_hlv_features);
        recommmended_starHunter_hlv = byView(R.id.star_hunter_hlv);
        recommended_story_hlv = byView(R.id.story_hunter_hlv);
        recommended_vlv_editor = byView(R.id.editor_vlv);

    }

    @Override
    protected void initDatas() {
        imgUrl = new ArrayList<>();
        blockbusterAdapter = new RecommendedHorizontalAdapter(context, 0);
        lineAdapter = new RecommendedHorizontalAdapter(context, 1);
        firstAdapter = new RecommendedHorizontalAdapter(context, 2);
        featuresAdapter = new RecommendedHorizontalAdapter(context, 3);
        recommendedAdapter = new RecommendedAdapter(context);
        starHunterAdapter = new RecommendedStarHunterAdapter(context,0);
        storyAdapter = new RecommendedStarHunterAdapter(context,1);
        editorAdapter  = new RecommendedEditorAdapter(context);

        final String url = "http://api.breadtrip.com/hunter/products/newstyle/?city_name=%E5%85%A8%E9%83%A8%E5%9F%8E%E5%B8%82&lat=0.0&lng=0.0";
        HashMap hashMap = new HashMap();
        hashMap.put("Cookie", "bt_devid=a_7609e79906d5f8b7685635c2efcdc4118315069380bba5daf6fe972abceffb98; sessionid=c2fca75a76e4b91069be74bc76d5c622; refer_android_source=43");
        hashMap.put("Host", "api.breadtrip.com");
        hashMap.put("User-Agent", "BreadTrip/android/7.0.1/zh (android OS5.1) vbox86p Map/AutoNavi/v1.4.2 (Google Nexus 5 - 5.1.0 - API 22 - 1080x1920,generic) Paros/3.2.13");
        /**
         * 推荐页面明星猎人的数据解析
         */
        DlaHttp.getInstance().startRequest(url, hashMap, RecommendedStarHunterBean.class, new OnHttpCallback<RecommendedStarHunterBean>() {

            @Override
            public void onSuccess(RecommendedStarHunterBean response) {
                starHunterAdapter.setData(response);
                recommmended_starHunter_hlv.setAdapter(starHunterAdapter);
                storyAdapter.setData(response);
                recommended_story_hlv.setAdapter(storyAdapter);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });

        /**
         * 推荐页面中在线活动,抢鲜体验,特色玩法的网络解析, 编辑精选的网路解析
         */
        DlaHttp.getInstance().startRequest(url, RecommendedBean.class, new OnHttpCallback<RecommendedBean>() {
            @Override
            public void onSuccess(RecommendedBean response) {
                for (int i = 0; i < response.getData().getBanners().size(); i++) {
                    String imurl = response.getData().getBanners().get(i).getImg_url();
                    imgUrl.add(imurl);
                }
                addPonints();
                changePoints();
                blockbusterAdapter.setData(response);
                lineAdapter.setData(response);
                firstAdapter.setData(response);
                featuresAdapter.setData(response);
                recommendedAdapter.setData(imgUrl);
                viewPager.setAdapter(recommendedAdapter);
                recommended_hlv_first.setAdapter(firstAdapter);
                recommended_hlv_features.setAdapter(featuresAdapter);
                recommended_hlv_line.setAdapter(lineAdapter);
                recommended_hlv_blockbuster.setAdapter(blockbusterAdapter);
                editorAdapter.setData(response);
                recommended_vlv_editor.setAdapter(editorAdapter);

            }

            @Override
            public void onError(Throwable ex) {

            }
        });


        viewPager.setCurrentItem(300);
        handle = new Handler();
        startRotate();


    }

    /**
     * 让小点随着ViewPager切换
     */
    private void changePoints() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < imgUrl.size(); i++) {
                    ImageView pointIv = (ImageView) pointContainer.getChildAt(i);
                    pointIv.setImageResource(R.mipmap.btn_msg_pin_pressed);
                }
                ImageView iv = (ImageView) pointContainer.getChildAt(position % imgUrl.size());
                iv.setImageResource(R.mipmap.btn_msg_pin_normal);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 添加小点
     */
    private void addPonints() {
        //有多少轮播图加多少个小点
        for (int i = 0; i < imgUrl.size(); i++) {
            ImageView pointIv = new ImageView(getActivity());
            //设置小点的padding
            pointIv.setPadding(10, 10, 10, 10);
            //设置小点的宽和高
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(40, 40);
            pointIv.setLayoutParams(p);
            //降低一个小点设置为黑色,其他为白色
            if (i == 0) {
                pointIv.setImageResource(R.mipmap.btn_msg_pin_normal);
            } else {
                pointIv.setImageResource(R.mipmap.btn_msg_pin_pressed);
            }
            //将小点加入小点容器
            pointContainer.addView(pointIv);
        }
    }

    /**
     * 开始自动轮播
     */
    private void startRotate() {
        rotateRunbale = new Runnable() {
            @Override
            public void run() {
                //获取ViewPager当前页
                int current = viewPager.getCurrentItem();
                //设置ViewPager当前页+1
                viewPager.setCurrentItem(++current);
                //发布延时任务
                handle.postDelayed(rotateRunbale, 3000);
            }
        };
        //Handler发布延时任务
        //第一次将该任务发布出去,之后任务内部还会发布该任务,死循环
        handle.postDelayed(rotateRunbale, 3000);
    }

}
