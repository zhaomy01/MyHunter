package com.example.dllo.myhunter.ui.fragment;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.RecommendedBean;
import com.example.dllo.myhunter.model.bean.RecommendedStarHunterBean;
import com.example.dllo.myhunter.tools.AnimationTextView;
import com.example.dllo.myhunter.tools.network.DlaHttp;
import com.example.dllo.myhunter.tools.network.OnHttpCallback;
import com.example.dllo.myhunter.ui.activity.AllCityActivity;
import com.example.dllo.myhunter.ui.activity.DialogActivity;
import com.example.dllo.myhunter.ui.adapter.RecommendedAdapter;
import com.example.dllo.myhunter.ui.adapter.RecommendedEditorAdapter;
import com.example.dllo.myhunter.ui.adapter.RecommendedRcAdapter;
import com.example.dllo.myhunter.ui.adapter.RecommendedStarHunteAdapter;
import com.example.dllo.myhunter.ui.adapter.RecommendedStoryAdapter;
import com.example.dllo.myhunter.view.VerticalListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * 推荐页面
 */
public class RecommendedFragment extends AbsBaseFragment implements View.OnClickListener {
    private ViewPager viewPager;
    private RecommendedAdapter recommendedAdapter;
    private VerticalListView recommended_vlv_editor;
    private RecommendedStarHunteAdapter starHunterAdapter;
    private RecommendedStoryAdapter storyAdapter;
    private RecommendedEditorAdapter editorAdapter;
    private ImageView recommend_iv_mbl, itme_title_theme;
    private RecommendedRcAdapter blockbusterAdapter, lineAdapter, firstAdapter, featuresAdapter;
    private LinearLayout pointContainer;//小圆点容器
    private Handler handle;
    private Runnable rotateRunbale;
    private List<String> imgUrl;
    private TextView recommend_tv_one, recommend_tv_two, recommend_tv_three,
            recommend_tv_four, recommend_tv_five, recommend_tv_six, recommended_tv_allcity;
    private View contentView;//获取根布局里的view
    private AnimatorSet set;
    private RecyclerView recommended_hlv_blockbuster, recommended_hlv_line, recommended_hlv_first,
            recommended_hlv_features, recommmended_starHunter_hlv, recommended_story_hlv;

    @Override
    protected int setLayout() {
        return R.layout.fragment_recommended;
    }

    @Override
    protected void initViews() {
        viewPager = byView(R.id.recommended_vp_lbt);
        recommend_iv_mbl = byView(R.id.recommend_iv_mbl);
        itme_title_theme = byView(R.id.itme_title_theme);
        pointContainer = byView(R.id.recommended_linea_yd);
        recommend_tv_one = byView(R.id.recommend_tv_one);
        recommend_tv_two = byView(R.id.recommend_tv_two);
        recommend_tv_three = byView(R.id.recommend_tv_three);
        recommend_tv_four = byView(R.id.recommend_tv_four);
        recommend_tv_five = byView(R.id.recommend_tv_five);
        recommend_tv_six = byView(R.id.recommend_tv_six);
        recommended_hlv_blockbuster = byView(R.id.recommended_hlv_blockbuster);
        recommended_hlv_line = byView(R.id.recommended_hlv_line);
        recommended_hlv_first = byView(R.id.recommended_hlv_first);
        recommended_hlv_features = byView(R.id.recommended_hlv_features);
        recommmended_starHunter_hlv = byView(R.id.star_hunter_hlv);
        recommended_story_hlv = byView(R.id.story_hunter_hlv);
        recommended_vlv_editor = byView(R.id.editor_vlv);
        recommended_tv_allcity = byView(R.id.itme_title_tv);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void initDatas() {
        set = new AnimatorSet();
        contentView = getActivity().findViewById(android.R.id.content);//获取根布局里的view

        itme_title_theme.setOnClickListener(this);
        recommended_tv_allcity.setOnClickListener(this);
        imgUrl = new ArrayList<>();
        blockbusterAdapter = new RecommendedRcAdapter(context, 0);
        lineAdapter = new RecommendedRcAdapter(context, 1);
        firstAdapter = new RecommendedRcAdapter(context, 2);
        featuresAdapter = new RecommendedRcAdapter(context, 3);
        recommendedAdapter = new RecommendedAdapter(context);

        starHunterAdapter = new RecommendedStarHunteAdapter(context);
        storyAdapter = new RecommendedStoryAdapter(context);
        editorAdapter = new RecommendedEditorAdapter(context);

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
            public void onSuccess(final RecommendedStarHunterBean response) {
                starHunterAdapter.setData(response);
                storyAdapter.setData(response);

                recommmended_starHunter_hlv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                recommended_story_hlv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                recommmended_starHunter_hlv.setAdapter(starHunterAdapter);
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

                recommended_hlv_first.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                recommended_hlv_features.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                recommended_hlv_line.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                recommended_hlv_blockbuster.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

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

        recommend_tv_one.startAnimation(AnimationTextView.getAnimation().showTranslateOne());
        recommend_tv_two.startAnimation(AnimationTextView.getAnimation().showTranslateTwo());
        recommend_tv_three.startAnimation(AnimationTextView.getAnimation().showTranslateThree());
        recommend_tv_four.startAnimation(AnimationTextView.getAnimation().showTranslateFour());
        recommend_tv_five.startAnimation(AnimationTextView.getAnimation().showTranslateFive());
        recommend_tv_six.startAnimation(AnimationTextView.getAnimation().showTranslateSix());

        //毛玻璃效果图片
        Glide.with(context).load("http://images.17173.com/2012/web/2012/07/16/q0716ar01s.jpg").bitmapTransform(new BlurTransformation(context, 20)).into(recommend_iv_mbl);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.itme_title_theme:
                goTo(context, DialogActivity.class);

                //ofFloat()方法的第一个参数表示动画操作的对象（可以是任意对象），
                // 第二个参数表示操作对象的属性名字（只要是对象有的属性都可以），
                // 第三个参数之后就是动画过渡值。当然过度值可以有一个到N个，
                // 如果是一个值的话默认这个值是动画过渡值的结束值。如果有N个值，动画就在这N个值之间过渡。
                ObjectAnimator oaX = ObjectAnimator.ofFloat(contentView, "scaleX", 1f, 0.9f);
                ObjectAnimator oaY = ObjectAnimator.ofFloat(contentView, "scaleY", 1f, 0.9f);
                set.play(oaX);
                set.play(oaY);
                set.start();
                break;
            case R.id.itme_title_tv:
                goTo(context, AllCityActivity.class);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        ObjectAnimator oaX = ObjectAnimator.ofFloat(contentView, "scaleX", 0.9f, 1f);
        ObjectAnimator oaY = ObjectAnimator.ofFloat(contentView, "scaleY", 0.9f, 1f);
        set.play(oaX);
        set.play(oaY);
        set.start();
    }
}
