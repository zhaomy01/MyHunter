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
import com.example.dllo.myhunter.model.bean.RecommendedBean;
import com.example.dllo.myhunter.tools.OnRecycleListenerInterface;
import com.squareup.picasso.Picasso;

/**
 * 推荐页面的适配器
 */
public class RecommendedRcAdapter extends RecyclerView.Adapter<RecommendedRcAdapter.MyHolder>{
    private RecommendedBean data;
    private Context context;
    private int type;
    private OnRecycleListenerInterface onRecycleListenerInterface;

    public void setOnRecycleListenerInterface(OnRecycleListenerInterface onRecycleListenerInterface) {
        this.onRecycleListenerInterface = onRecycleListenerInterface;
        notifyDataSetChanged();
    }

    public RecommendedRcAdapter(Context context, int type) {
        this.context = context;
        this.type = type;
    }

    public void setData(RecommendedBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itme_recommended_horizontal,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        if (type == 0) {
            RecommendedBean.DataBean.ProductModulesBean.Product bean0 = data.getData().getProduct_modules().get(0).getProduct_list().get(position);
            holder.tv_title.setText(bean0.getTitle());
            holder.tv_number.setText(bean0.getPrice());
            Picasso.with(context).load(bean0.getTitle_page()).config(Bitmap.Config.RGB_565).into(holder.iv);
        }
        if (type == 1){
            RecommendedBean.DataBean.ProductModulesBean.Product bean1 = data.getData().getProduct_modules().get(1).getProduct_list().get(position);
            holder.tv_title.setText(bean1.getTitle());
            holder.tv_number.setText(bean1.getPrice());
            Picasso.with(context).load(bean1.getTitle_page()).config(Bitmap.Config.RGB_565).into(holder.iv);
        }
        if (type == 2){
            RecommendedBean.DataBean.ProductModulesBean.Product bean2 = data.getData().getProduct_modules().get(2).getProduct_list().get(position);
            holder.tv_title.setText(bean2.getTitle());
            holder.tv_number.setText(bean2.getPrice());
            Picasso.with(context).load(bean2.getTitle_page()).config(Bitmap.Config.RGB_565).into(holder.iv);
        }
        if (type == 3){
            RecommendedBean.DataBean.ProductModulesBean.Product bean3 = data.getData().getProduct_modules().get(3).getProduct_list().get(position);
            holder.tv_title.setText(bean3.getTitle());
            holder.tv_number.setText(bean3.getPrice());
            Picasso.with(context).load(bean3.getTitle_page()).config(Bitmap.Config.RGB_565).into(holder.iv);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getAdapterPosition();
                onRecycleListenerInterface.onRecycleListenerInterface(pos);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.getData().getProduct_modules().get(0).getProduct_list().size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        private ImageView iv;
        private TextView tv_title,tv_number;

        public MyHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.itme_recommend_hor_iv);
            tv_title = (TextView) itemView.findViewById(R.id.itme_recommend_hor_tit);
            tv_number = (TextView) itemView.findViewById(R.id.itme_recommend_hor_q);
        }
    }
}
