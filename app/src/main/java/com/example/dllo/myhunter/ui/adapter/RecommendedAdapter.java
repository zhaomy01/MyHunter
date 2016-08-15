package com.example.dllo.myhunter.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dllo.myhunter.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * 推荐页面的轮播适配器
 */
public class RecommendedAdapter extends PagerAdapter {
    private Context context;
    private List<String> data;

    public RecommendedAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        //ViewPager 有多少页,整数最大值 21亿
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.itme_recommended_lbt, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.itme_recommend_iv);
        Picasso.with(context).load(data.get(position % data.size())).into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
