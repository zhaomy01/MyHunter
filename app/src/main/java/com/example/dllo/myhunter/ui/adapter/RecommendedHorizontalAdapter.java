package com.example.dllo.myhunter.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.RecommendedBean;
import com.squareup.picasso.Picasso;


public class RecommendedHorizontalAdapter extends BaseAdapter {
    private RecommendedBean data;
    private Context context;
    private int type;

    public RecommendedHorizontalAdapter(Context context,int type) {
        this.context = context;
        this.type = type;
    }

    public void setData(RecommendedBean data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.getData().getProduct_modules().get(0).getProduct_list().size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.itme_recommended_horizontal,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (type == 0) {
            holder.tv_title.setText(data.getData().getProduct_modules().get(0).getProduct_list().get(position).getTitle());
            holder.tv_number.setText(data.getData().getProduct_modules().get(0).getProduct_list().get(position).getPrice());
            Picasso.with(context).load(data.getData().getProduct_modules().get(0).getProduct_list().get(position).getTitle_page()).into(holder.iv);
        }
        if (type == 1){
            holder.tv_title.setText(data.getData().getProduct_modules().get(1).getProduct_list().get(position).getTitle());
            holder.tv_number.setText(data.getData().getProduct_modules().get(1).getProduct_list().get(position).getPrice());
            Picasso.with(context).load(data.getData().getProduct_modules().get(1).getProduct_list().get(position).getTitle_page()).into(holder.iv);
        }
        if (type == 2){
            holder.tv_title.setText(data.getData().getProduct_modules().get(2).getProduct_list().get(position).getTitle());
            holder.tv_number.setText(data.getData().getProduct_modules().get(2).getProduct_list().get(position).getPrice());
            Picasso.with(context).load(data.getData().getProduct_modules().get(2).getProduct_list().get(position).getTitle_page()).into(holder.iv);
        }
        if (type == 3){
            holder.tv_title.setText(data.getData().getProduct_modules().get(3).getProduct_list().get(position).getTitle());
            holder.tv_number.setText(data.getData().getProduct_modules().get(3).getProduct_list().get(position).getPrice());
            Picasso.with(context).load(data.getData().getProduct_modules().get(3).getProduct_list().get(position).getTitle_page()).into(holder.iv);
        }

        return convertView;
    }

    class ViewHolder{
        private ImageView iv;
        private TextView tv_title,tv_number;

        public ViewHolder(View view) {
            iv = (ImageView) view.findViewById(R.id.itme_recommend_hor_iv);
            tv_title = (TextView) view.findViewById(R.id.itme_recommend_hor_tit);
            tv_number = (TextView) view.findViewById(R.id.itme_recommend_hor_q);
        }
    }

}
