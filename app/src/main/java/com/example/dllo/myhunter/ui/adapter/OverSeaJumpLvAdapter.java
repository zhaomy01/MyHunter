package com.example.dllo.myhunter.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.CollectionBean;
import com.example.dllo.myhunter.model.bean.OverSeaJumpBean;
import com.example.dllo.myhunter.model.db.DatabaseManager;
import com.example.dllo.myhunter.ui.activity.LoginActivity;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/23.
 */
public class OverSeaJumpLvAdapter extends BaseAdapter {
    private Context context;
    private OverSeaJumpBean data;

    public OverSeaJumpLvAdapter(Context context) {
        this.context = context;
    }

    public void setData(OverSeaJumpBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.getProduct_list().size();
    }

    @Override
    public Object getItem(int position) {
        return data.getProduct_list().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        OverSeaJumpHolder overSeaJumpHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_oversea_lv, parent, false);
            overSeaJumpHolder = new OverSeaJumpHolder(convertView);
            convertView.setTag(overSeaJumpHolder);
        } else {
            overSeaJumpHolder = (OverSeaJumpHolder) convertView.getTag();
        }
        final OverSeaJumpBean.ProductListBean bean = data.getProduct_list().get(position);
        overSeaJumpHolder.textView_content.setText(bean.getTitle());
        overSeaJumpHolder.textView_address.setText(bean.getAddress());
        overSeaJumpHolder.textView_like_counts.setText(String.valueOf(bean.getLike_count()) + "人喜欢");
        overSeaJumpHolder.textView_price.setText(String.valueOf(bean.getDiscount_price()));
        Picasso.with(context).load(bean.getTitle_page()).config(Bitmap.Config.RGB_565).into(overSeaJumpHolder.imageView_top);
        Picasso.with(context).load(bean.getUser().getAvatar_l()).config(Bitmap.Config.RGB_565).into(overSeaJumpHolder.circleImageView_icon);
        final OverSeaJumpHolder finalOverSeaJumpHolder = overSeaJumpHolder;
        overSeaJumpHolder.imageView_collection.setOnClickListener(new View.OnClickListener() {
            private boolean flag = true;

            @Override
            public void onClick(View v) {
                SharedPreferences sp = context.getSharedPreferences("city", Context.MODE_PRIVATE);
                String str = sp.getString("str", "全部城市");

                SharedPreferences sp1 = context.getSharedPreferences("MyHunter", Context.MODE_PRIVATE);
                String name = sp1.getString("key", "");
                if (!name.isEmpty()) {
                    CollectionBean collectionBean = new CollectionBean();
                    collectionBean.setUrl(bean.getTitle_page());
                    collectionBean.setContent(bean.getTitle());
                    collectionBean.setPrice(bean.getPrice());
                    collectionBean.setAddress(str);
                    if (flag) {
                        finalOverSeaJumpHolder.imageView_collection.setImageResource(R.mipmap.ic_like_seleted);
                        DatabaseManager.getOurInstance().insert(collectionBean);
                        flag = false;
                    } else {
                        finalOverSeaJumpHolder.imageView_collection.setImageResource(R.mipmap.ic_like_normal);
                        flag = true;
                    }
                } else {
                    context.startActivity(new Intent(context, LoginActivity.class));
                }
            }
        });
        return convertView;
    }

    class OverSeaJumpHolder {
        private TextView textView_content, textView_address, textView_like_counts, textView_price;
        private ImageView imageView_top, imageView_collection;
        private CircleImageView circleImageView_icon;

        public OverSeaJumpHolder(View view) {
            textView_content = (TextView) view.findViewById(R.id.oversea_contentTv);
            textView_address = (TextView) view.findViewById(R.id.oversea_addressTv);
            textView_like_counts = (TextView) view.findViewById(R.id.oversea_like_countsTv);
            textView_price = (TextView) view.findViewById(R.id.oversea_priceTv);
            imageView_top = (ImageView) view.findViewById(R.id.oversea_topIv);
            circleImageView_icon = (CircleImageView) view.findViewById(R.id.oversea_iconIv);
            imageView_collection = (ImageView) view.findViewById(R.id.oversea_collection);
        }
    }
}
