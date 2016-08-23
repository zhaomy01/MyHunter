package com.example.dllo.myhunter.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.RecommendedStarHunterBean;
import com.example.dllo.myhunter.model.bean.RecommendedStarHunterJumpBean;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/8/22.
 * 推荐页面明星猎人跳转页面里的活动的适配器
 */
public class ActiviJumpLvAdapter extends BaseAdapter {
    private RecommendedStarHunterJumpBean data;
    private Context context;

    public ActiviJumpLvAdapter(Context context) {
        this.context = context;
    }

    public void setData(RecommendedStarHunterJumpBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.getData().getProducts().getData().size();
    }

    @Override
    public Object getItem(int position) {
        return data.getData().getProducts().getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ActiviHolder activiHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_activijumplv, parent, false);
            activiHolder = new ActiviHolder(convertView);
            convertView.setTag(activiHolder);
        } else {
            activiHolder = (ActiviHolder) convertView.getTag();
        }
        RecommendedStarHunterJumpBean.DataBean.ProductsBean.DataBeanOne bean = data.getData().getProducts().getData().get(position);
        activiHolder.textView_content.setText(bean.getTitle());
        activiHolder.textView_address.setText(bean.getAddress());
        activiHolder.textView_like_counts.setText(String.valueOf(bean.getLike_count()));
        activiHolder.textView_price.setText(bean.getPrice());
        Picasso.with(context).load(bean.getTitle_page()).into(activiHolder.imageView_top);
        return convertView;
    }

    class ActiviHolder {
        private TextView textView_content, textView_address, textView_like_counts, textView_price;
        private ImageView imageView_top;

        public ActiviHolder(View view) {
            textView_content = (TextView) view.findViewById(R.id.activi_contentTv);
            textView_address = (TextView) view.findViewById(R.id.activi_addressTv);
            textView_like_counts = (TextView) view.findViewById(R.id.activi_like_countsTv);
            textView_price = (TextView) view.findViewById(R.id.activi_priceTv);
            imageView_top = (ImageView) view.findViewById(R.id.activi_topIv);
        }
    }
}
