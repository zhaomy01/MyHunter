package com.example.dllo.myhunter.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.RecommendedStarHunterJumpBean;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/8/22.
 * 推荐页面明星猎人跳转页面里的故事集的适配器
 */
public class StoryJumpLvAdapter extends BaseAdapter {
    private RecommendedStarHunterJumpBean data;
    private Context context;

    public StoryJumpLvAdapter(Context context) {
        this.context = context;
    }

    public void setData(RecommendedStarHunterJumpBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.getData().getTrips().getData().size();
    }

    @Override
    public Object getItem(int position) {
        return data.getData().getTrips().getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StoryHolder storyHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_storyjumplv, parent, false);
            storyHolder = new StoryHolder(convertView);
            convertView.setTag(storyHolder);
        } else {
            storyHolder = (StoryHolder) convertView.getTag();
        }
        RecommendedStarHunterJumpBean.DataBean.TripsBean.DataBeanTwo bean = data.getData().getTrips().getData().get(position);
        storyHolder.textView_title.setText(bean.getName());
        storyHolder.textView_browse.setText(String.valueOf(bean.getView_count()));
        storyHolder.textView_like.setText(String.valueOf(bean.getLiked_count()));
        storyHolder.textView_comments.setText(String.valueOf(bean.getTotal_comments_count()));
        Picasso.with(context).load(bean.getCover_image_default()).into(storyHolder.imageView);

        return convertView;
    }

    class StoryHolder {
        private TextView textView_title, textView_browse, textView_like, textView_comments;
        private ImageView imageView;

        public StoryHolder(View view) {
            textView_title = (TextView) view.findViewById(R.id.story_tv_title);
            textView_browse = (TextView) view.findViewById(R.id.story_tv_browse);
            textView_like = (TextView) view.findViewById(R.id.story_tv_like);
            textView_comments = (TextView) view.findViewById(R.id.story_tv_comments);
            imageView = (ImageView) view.findViewById(R.id.story_iv_top);
        }
    }
}
