package com.example.dllo.myhunter.ui.adapter;

import android.content.Context;
import android.renderscript.Type;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.RecommendedStarHunterBean;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/15.
 * 推荐页面明星猎人自定义横滑ListView适配器
 */
public class RecommendedStarHunterAdapter extends BaseAdapter {
    private RecommendedStarHunterBean data;
    private Context context;
    private int type;

    public RecommendedStarHunterAdapter(Context context, int type) {
        this.context = context;
        this.type = type;
    }

    public void setData(RecommendedStarHunterBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.getData().getHunters().getHunterLists().size();
    }

    @Override
    public Object getItem(int position) {
        return data.getData().getHunters().getHunterLists().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (type == 0) {
            StarHunterHolder hunterHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_recommended_starthunter_hlv, parent, false);
                hunterHolder = new StarHunterHolder(convertView);
                convertView.setTag(hunterHolder);
            } else {
                hunterHolder = (StarHunterHolder) convertView.getTag();
            }
            hunterHolder.textView_name.setText(data.getData().getHunters().getHunterLists().get(position).getUsername());
            hunterHolder.textView_content.setText(data.getData().getHunters().getHunterLists().get(position).getDescription());
            Picasso.with(context).load(data.getData().getHunters().getHunterLists().get(position).getProduct_image()).into(hunterHolder.imageView_top);
            Picasso.with(context).load(data.getData().getHunters().getHunterLists().get(position).getAvatar_l()).into(hunterHolder.circleImageView);
        } else if (type == 1) {
            StoryHolder storyHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_recommended_story_hlv, parent, false);
                storyHolder = new StoryHolder(convertView);
                convertView.setTag(storyHolder);
            } else {
                storyHolder = (StoryHolder) convertView.getTag();
            }
            storyHolder.textView_name.setText(data.getData().getSpots().getSpot_list().get(position).getUser().getName());
            storyHolder.textView_content.setText(data.getData().getSpots().getSpot_list().get(position).getText());
            storyHolder.textView_add.setText(data.getData().getSpots().getSpot_list().get(position).getTarget().getTitle());
            Picasso.with(context).load(data.getData().getSpots().getSpot_list().get(position).getUser().getAvatar_l()).into(storyHolder.circleImageView);
            Picasso.with(context).load(data.getData().getSpots().getSpot_list().get(position).getCover_image()).into(storyHolder.imageView_middle);

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

    class StoryHolder {
        private TextView textView_name, textView_content, textView_add;
        private CircleImageView circleImageView;
        private ImageView imageView_middle;

        public StoryHolder(View view) {
            textView_name = (TextView) view.findViewById(R.id.story_hunter_nameTv);
            textView_content = (TextView) view.findViewById(R.id.story_hunter_contentTv);
            textView_add = (TextView) view.findViewById(R.id.story_hunter_addTv);
            circleImageView = (CircleImageView) view.findViewById(R.id.story_hunter_iconIv);
            imageView_middle = (ImageView) view.findViewById(R.id.story_hunter_middleIv);

        }
    }
}
