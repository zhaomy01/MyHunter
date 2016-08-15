package com.example.dllo.myhunter.ui.fragment;


import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.RecommendedBean;
import com.example.dllo.myhunter.tools.network.DlaHttp;
import com.example.dllo.myhunter.tools.network.OnHttpCallback;
import com.example.dllo.myhunter.ui.adapter.RecommendedAdapter;
import com.example.dllo.myhunter.ui.adapter.RecommendedHorizontalAdapter;
import com.example.dllo.myhunter.view.HorizontalListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐页面
 */
public class RecommendedFragment extends AbsBaseFragment {
    private ViewPager viewPager;
    private RecommendedAdapter recommendedAdapter;
    private RecommendedHorizontalAdapter blockbusterAdapter,lineAdapter,firstAdapter,featuresAdapter;
    private LinearLayout pointContainer,recommend_linearLayout;//小圆点容器
    private Handler handle;
    private Runnable rotateRunbale;
    private List<String> imgUrl;
    private HorizontalListView recommended_hlv_blockbuster,recommended_hlv_line,recommended_hlv_first,recommended_hlv_features;

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
    }

    @Override
    protected void initDatas() {
        imgUrl = new ArrayList<>();
        blockbusterAdapter = new RecommendedHorizontalAdapter(context,0);
        lineAdapter = new RecommendedHorizontalAdapter(context,1);
        firstAdapter = new RecommendedHorizontalAdapter(context,2);
        featuresAdapter = new RecommendedHorizontalAdapter(context,3);
        recommendedAdapter = new RecommendedAdapter(context);
        
        final String url = "http://api.breadtrip.com/hunter/products/newstyle/?city_name=%E5%85%A8%E9%83%A8%E5%9F%8E%E5%B8%82&lat=0.0&lng=0.0";

        DlaHttp.getInstance().startRequest(url, RecommendedBean.class, new OnHttpCallback<RecommendedBean>() {
            @Override
            public void onSuccess(RecommendedBean response) {
                for (int i = 0; i <response.getData().getBanners().size() ; i++) {
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
                handle.postDelayed(rotateRunbale,3000);
            }
        };
        //Handler发布延时任务
        //第一次将该任务发布出去,之后任务内部还会发布该任务,死循环
        handle.postDelayed(rotateRunbale,3000);
    }

}
