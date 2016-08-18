package com.example.dllo.myhunter.ui.adapter;

import android.content.Context;
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

public class RecommendedTwoHunterAdapter extends RecyclerView.Adapter<RecommendedTwoHunterAdapter.MyHolder> {
    private RecommendedStarHunterBean data;
    private Context context;

    public RecommendedTwoHunterAdapter(Context context) {
        this.context = context;
    }

    public void setData(RecommendedStarHunterBean data) {
        this.data = data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recommended_story_hlv, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.textView_name.setText(data.getData().getSpots().getSpot_list().get(position).getUser().getName());
        holder.textView_content.setText(data.getData().getSpots().getSpot_list().get(position).getText());
        holder.textView_add.setText(data.getData().getSpots().getSpot_list().get(position).getTarget().getTitle());
        Picasso.with(context).load(data.getData().getSpots().getSpot_list().get(position).getUser().getAvatar_l()).into(holder.circleImageView);
        Picasso.with(context).load(data.getData().getSpots().getSpot_list().get(position).getCover_image()).into(holder.imageView_middle);
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
