package com.example.dllo.myhunter.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.RecommendedBean;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/16.
 * 推荐页面的编辑精选的竖向滑动的ListView适配器
 */
public class RecommendedEditorAdapter extends BaseAdapter {
    private RecommendedBean data;
    private Context context;

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
    public View getView(int position, View convertView, ViewGroup parent) {
        EditorHolder editorHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_recommended_editor_vlv, parent, false);
            editorHolder = new EditorHolder(convertView);
            convertView.setTag(editorHolder);
        } else {
            editorHolder = (EditorHolder) convertView.getTag();
        }
        editorHolder.textView_content.setText(data.getData().getOther_products().getProduct_list().get(position).getTitle());
        editorHolder.textView_address.setText(data.getData().getOther_products().getProduct_list().get(position).getAddress());
        editorHolder.textView_like_counts.setText(String.valueOf(data.getData().getOther_products().getProduct_list().get(position).getLike_count()));
        editorHolder.textView_price.setText(String.valueOf(data.getData().getOther_products().getProduct_list().get(position).getPrice()));
        Picasso.with(context).load(data.getData().getOther_products().getProduct_list().get(position).getTitle_page()).into(editorHolder.imageView_top);
        Picasso.with(context).load(data.getData().getOther_products().getProduct_list().get(position).getUser().getAvatar_l()).into(editorHolder.circleImageView_icon);
        editorHolder.button_one.setText(data.getData().getOther_products().getProduct_list().get(position).getTab_list().get(0));
        editorHolder.button_two.setText(data.getData().getOther_products().getProduct_list().get(position).getTab_list().get(1));
        return convertView;
    }

    class EditorHolder {
        private TextView textView_content, textView_address, textView_like_counts, textView_price;
        private ImageView imageView_top;
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
        }
    }
}
