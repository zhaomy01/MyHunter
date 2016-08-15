package com.example.dllo.myhunter.ui.adapter;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.RecommendedBean;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/15.
 * 推荐页面明星猎人自定义横滑ListView适配器
 */
public class RecommendedStarHunterAdapter extends BaseAdapter {
    private RecommendedBean data;
    private Context context;

    public RecommendedStarHunterAdapter(Context context) {
        this.context = context;
    }

    public void setData(RecommendedBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.getData().getTags().size();
    }

    @Override
    public Object getItem(int position) {
        return data.getData().getTags().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StarHunterHolder hunterHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_recommended_starthunter_hlv,parent,false);
            hunterHolder = new StarHunterHolder(convertView);
            convertView.setTag(hunterHolder);
        }else {
            hunterHolder = (StarHunterHolder) convertView.getTag();
            hunterHolder.textView_name.setText(data.getData().getTags().get(position).getHunter_list().getName());
        }
        return convertView;
    }

    class StarHunterHolder {
        private TextView textView_name, textView_content;
        private ImageView imageView_top;
        private CircleImageView circleImageView;

        public StarHunterHolder(View view) {
            textView_name = (TextView) view.findViewById(R.id.star_hunter_nameTv);
            textView_content = (TextView) view.findViewById(R.id.star_hunter_contentTv);
            imageView_top = (ImageView) view.findViewById(R.id.star_hunter_topIv);
            circleImageView = (CircleImageView) view.findViewById(R.id.star_hunter_iconIv);
        }
    }
}
