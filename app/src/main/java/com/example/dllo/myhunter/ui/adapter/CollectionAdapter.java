package com.example.dllo.myhunter.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.CollectionBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/8/25.
 * 我的页面中的我的收藏跳转页面布局的listView的适配器
 */
public class CollectionAdapter extends BaseAdapter{
    private List<CollectionBean> data;
    private Context context;

    public CollectionAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<CollectionBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CollectionHolder collectionHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_collection_vlv,parent,false);
            collectionHolder = new CollectionHolder(convertView);
            convertView.setTag(collectionHolder);
        }else {
            collectionHolder = (CollectionHolder) convertView.getTag();
        }
        collectionHolder.textView_content.setText(data.get(position).getContent());
        collectionHolder.textView_address.setText(data.get(position).getAddress()+"出发");
        collectionHolder.textView_price.setText(data.get(position).getPrice()+".0元起");
        Picasso.with(context).load(data.get(position).getUrl()).into(collectionHolder.imageView);

        return convertView;
    }
    class CollectionHolder {
        private ImageView imageView;
        private TextView textView_content,textView_price,textView_address;
        public CollectionHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.collection_imageview);
            textView_content = (TextView) view.findViewById(R.id.collection_tv_content);
            textView_price = (TextView) view.findViewById(R.id.collection_tv_price);
            textView_address = (TextView) view.findViewById(R.id.collection_tv_address);
        }
    }
}
