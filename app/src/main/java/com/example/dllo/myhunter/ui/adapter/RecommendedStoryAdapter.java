package com.example.dllo.myhunter.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.RecommendedStarHunterBean;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 推荐页面中体验故事——横滑Recyclerview适配器
 */
public class RecommendedStoryAdapter extends RecyclerView.Adapter<RecommendedStoryAdapter.MyHolder> {
    private RecommendedStarHunterBean data;
    private Context context;

    public RecommendedStoryAdapter(Context context) {
        this.context = context;
    }

    public void setData(RecommendedStarHunterBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recommended_story_hlv, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override

    public void onBindViewHolder(MyHolder holder, int position) {
        RecommendedStarHunterBean.DataBean.SpotsBean.SpotListBean bean = data.getData().getSpots().getSpot_list().get(position);
        holder.textView_name.setText(bean.getUser().getName());
        holder.textView_content.setText(bean.getText());
        holder.textView_add.setText(bean.getTarget().getTitle());
        Picasso.with(context).load(bean.getUser().getAvatar_l()).config(Bitmap.Config.RGB_565).into(holder.circleImageView);
        Picasso.with(context).load(bean.getCover_image()).config(Bitmap.Config.RGB_565).into(holder.imageView_middle);
    }

    @Override
    public int getItemCount() {
        return data.getData().getHunters().getHunterLists().size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private TextView textView_name, textView_content, textView_add;
        private CircleImageView circleImageView;
        private ImageView imageView_middle;

        public MyHolder(View itemView) {
            super(itemView);
            textView_name = (TextView) itemView.findViewById(R.id.story_hunter_nameTv);
            textView_content = (TextView) itemView.findViewById(R.id.story_hunter_contentTv);
            textView_add = (TextView) itemView.findViewById(R.id.story_hunter_addTv);
            circleImageView = (CircleImageView) itemView.findViewById(R.id.story_hunter_iconIv);
            imageView_middle = (ImageView) itemView.findViewById(R.id.story_hunter_middleIv);
        }
    }
}
