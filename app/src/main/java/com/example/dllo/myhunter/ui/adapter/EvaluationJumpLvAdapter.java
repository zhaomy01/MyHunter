package com.example.dllo.myhunter.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.RecommendedStarHunterJumpBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/20.
 *  推荐页面明星猎人跳转页面里的评论的适配器
 */
public class EvaluationJumpLvAdapter extends BaseAdapter {
    private RecommendedStarHunterJumpBean data;
    private Context context;

    public void setData(RecommendedStarHunterJumpBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public EvaluationJumpLvAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.getData().getClient_comments().getData().size();
    }

    @Override
    public Object getItem(int position) {
        return data.getData().getClient_comments().getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StarHunterJumpHolder jumpHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_evaluationjumplv, parent, false);
            jumpHolder = new StarHunterJumpHolder(convertView);
            convertView.setTag(jumpHolder);
        }else {
            jumpHolder  = (StarHunterJumpHolder) convertView.getTag();
        }
        RecommendedStarHunterJumpBean.DataBean.ClientCommentsBean.DataBeanThree bean = data.getData().getClient_comments().getData().get(position);
        jumpHolder.textView_content.setText(bean.getComment_public());
        jumpHolder.textView_date.setText(bean.getDatetime_formatted());
        Picasso.with(context).load(bean.getClient_avatar()).into(jumpHolder.circleImageView_icon);

        return convertView;
    }

    class StarHunterJumpHolder {
        private TextView textView_content, textView_date;
        private CircleImageView circleImageView_icon;


        public StarHunterJumpHolder(View view) {
            textView_content = (TextView) view.findViewById(R.id.starhunter_jump_tv_content);
            textView_date = (TextView) view.findViewById(R.id.starhunter_jump_tv_date);
            circleImageView_icon = (CircleImageView) view.findViewById(R.id.starhunter_jump_iv_icon);
        }
    }
}
