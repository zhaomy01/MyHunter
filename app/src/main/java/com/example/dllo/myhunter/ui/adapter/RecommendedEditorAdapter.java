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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.CollectionBean;
import com.example.dllo.myhunter.model.bean.RecommendedBean;
import com.example.dllo.myhunter.model.db.DatabaseManager;
import com.example.dllo.myhunter.ui.activity.LoginActivity;
import com.squareup.picasso.Picasso;


import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/16.
 * 推荐页面的编辑精选的竖向滑动的ListView适配器
 */
public class RecommendedEditorAdapter extends BaseAdapter {
    private RecommendedBean data;
    private Context context;
    private boolean flag = true;

    public RecommendedEditorAdapter(Context context) {
        this.context = context;
    }

    public void setData(RecommendedBean data) {
        this.data = data;
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return data.getData().getOther_products().getProduct_list().size();
    }

    @Override
    public Object getItem(int position) {
        return data.getData().getOther_products().getProduct_list().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        EditorHolder editorHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_recommended_editor_vlv, parent, false);
            editorHolder = new EditorHolder(convertView);
            convertView.setTag(editorHolder);
        } else {
            editorHolder = (EditorHolder) convertView.getTag();
        }
        final RecommendedBean.DataBean.OtherProductsBean.ProdBean bean = data.getData().getOther_products().getProduct_list().get(position);
        editorHolder.textView_content.setText(bean.getTitle());
        editorHolder.textView_address.setText(bean.getAddress());
        editorHolder.textView_like_counts.setText(String.valueOf(bean.getLike_count()));
        editorHolder.textView_price.setText(String.valueOf(bean.getPrice()));
        Picasso.with(context).load(bean.getTitle_page()).config(Bitmap.Config.RGB_565).into(editorHolder.imageView_top);
        Picasso.with(context).load(bean.getUser().getAvatar_l()).config(Bitmap.Config.RGB_565).into(editorHolder.circleImageView_icon);
        editorHolder.button_one.setText(bean.getTab_list().get(0));
        editorHolder.button_two.setText(bean.getTab_list().get(1));
        final EditorHolder finalEditorHolder1 = editorHolder;
        //收藏按钮点击收藏
        editorHolder.imageView_collection.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SharedPreferences sp = context.getSharedPreferences("city", Context.MODE_PRIVATE);
                String str = sp.getString("str", "全部城市");

                SharedPreferences sp1 = context.getSharedPreferences("MyHunter", Context.MODE_PRIVATE);
                String name = sp1.getString("key", "");
                SharedPreferences.Editor editor = context.getSharedPreferences("MyHunter", Context.MODE_PRIVATE).edit();
                if (!name.isEmpty()) {
                    CollectionBean collectionBean = new CollectionBean();
                    collectionBean.setUrl(bean.getTitle_page());
                    collectionBean.setContent(bean.getTitle());
                    collectionBean.setPrice(bean.getPrice());
                    collectionBean.setAddress(str);
                    if (flag) {
                        DatabaseManager.getOurInstance().insert(collectionBean);
                        editor.putInt("image", R.mipmap.ic_like_seleted);
                        editor.commit();
                        flag = false;
                    } else {
                        DatabaseManager.getOurInstance().delete(CollectionBean.class, "content", new String[]{collectionBean.getContent()});
                        editor.putInt("image", R.mipmap.ic_like_normal);
                        editor.commit();
                        flag = true;
                    }
                    finalEditorHolder1.imageView_collection.setImageResource(sp1.getInt("image", 1));

                } else {
                    context.startActivity(new Intent(context, LoginActivity.class));
                }

            }
        });

        return convertView;
    }

    class EditorHolder {
        private TextView textView_content, textView_address, textView_like_counts, textView_price;
        private ImageView imageView_top, imageView_collection;
        private CircleImageView circleImageView_icon;
        private Button button_one, button_two;

        public EditorHolder(View view) {
            textView_content = (TextView) view.findViewById(R.id.editor_contentTv);
            textView_address = (TextView) view.findViewById(R.id.editor_addressTv);
            textView_like_counts = (TextView) view.findViewById(R.id.editor_like_countsTv);
            textView_price = (TextView) view.findViewById(R.id.editor_priceTv);
            imageView_top = (ImageView) view.findViewById(R.id.editor_topIv);
            circleImageView_icon = (CircleImageView) view.findViewById(R.id.editor_iconIv);
            button_one = (Button) view.findViewById(R.id.editor_buttonOne);
            button_two = (Button) view.findViewById(R.id.editor_buttonTwo);
            imageView_collection = (ImageView) view.findViewById(R.id.recommended_collection);
        }
    }
}
