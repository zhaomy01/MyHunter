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
import com.example.dllo.myhunter.model.bean.AllCityHotJumpBean;
import com.example.dllo.myhunter.model.bean.RecommendedStarHunterBean;
import com.example.dllo.myhunter.tools.OnRecycleListenerInterface;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 推荐页面明星猎人自定义横滑ListView适配器
 */
public class RecommendedStarHunteAdapter extends RecyclerView.Adapter<RecommendedStarHunteAdapter.MyHolder> {
    private RecommendedStarHunterBean data;
    private AllCityHotJumpBean databean;
    private Context context;
    private OnRecycleListenerInterface recycleListenerInterface;

    public void setDatabean(AllCityHotJumpBean databean) {
        this.databean = databean;
        notifyDataSetChanged();
    }

    public RecommendedStarHunteAdapter(Context context) {
        this.context = context;
    }

    public void setRecycleListenerInterface(OnRecycleListenerInterface recycleListenerInterface) {
        this.recycleListenerInterface = recycleListenerInterface;
    }

    public void setData(RecommendedStarHunterBean data) {
        this.data = data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recommended_starthunter_hlv, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        if (recycleListenerInterface != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getAdapterPosition();
                    recycleListenerInterface.onRecycleListenerInterface(pos);
                }
            });

        }
        RecommendedStarHunterBean.DataBean.HunteBean.HunterList bean = data.getData().getHunters().getHunterLists().get(position);
        holder.textView_name.setText(bean.getUsername());
        holder.textView_content.setText(bean.getDescription());
        Picasso.with(context).load(bean.getProduct_image()).config(Bitmap.Config.RGB_565).into(holder.imageView_top);
        Picasso.with(context).load(bean.getAvatar_l()).config(Bitmap.Config.RGB_565).into(holder.circleImageView);
    }

    @Override
    public int getItemCount() {
        return data.getData().getHunters().getHunterLists().size();
    }



    class MyHolder extends RecyclerView.ViewHolder {
        private TextView textView_name, textView_content;
        private ImageView imageView_top;
        private CircleImageView circleImageView;

        public MyHolder(View itemView) {
            super(itemView);
            textView_name = (TextView) itemView.findViewById(R.id.star_hunter_nameTv);
            textView_content = (TextView) itemView.findViewById(R.id.star_hunter_contentTv);
            imageView_top = (ImageView) itemView.findViewById(R.id.star_hunter_topIv);
            circleImageView = (CircleImageView) itemView.findViewById(R.id.star_hunter_iconIv);
        }
    }
}
