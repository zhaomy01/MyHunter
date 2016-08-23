package com.example.dllo.myhunter.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.FoundBean;
import com.example.dllo.myhunter.tools.OnRecycleListenerInterface;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by zlw on 16/8/15.
 * 发现的适配器
 */
public class FoundAdapter extends RecyclerView.Adapter<FoundAdapter.MyHolder> {
    private Context context;
    private List<FoundBean> data;
    private OnRecycleListenerInterface onRecycleListenerInterface;

    public static final int FIRST_STICKY_VIEW = 1;
    public static final int HAS_STICKY_VIEW = 2;
    public static final int NONE_STICKY_VIEW = 3;

    private CircleImageView found_cim_one, found_cim_two, found_cim_three, found_cim_four, found_cim_five;
    private CircleImageView[] imgs = {found_cim_one, found_cim_two, found_cim_three, found_cim_four, found_cim_five};
    private int[] imgsId = {R.id.found_cim_one, R.id.found_cim_two, R.id.found_cim_three, R.id.found_cim_four, R.id.found_cim_five};

    public FoundAdapter(Context context) {
        this.context = context;
    }

    public void setOnRecycleListenerInterface(OnRecycleListenerInterface onRecycleListenerInterface) {
        this.onRecycleListenerInterface = onRecycleListenerInterface;
        notifyDataSetChanged();
    }

    public void setData(List<FoundBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder myHolder = null;
        View view = LayoutInflater.from(context).inflate(R.layout.item_found_rv, parent, false);
        myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        FoundBean.DataBean.FeedsBean bean = data.get(0).getData().getFeeds().get(position);

        if (data.get(0).getData().getFeeds().get(position).getProduct() == null) {
        } else {

            if (position == 0 ){
                Picasso.with(context).load(bean.getUser().getAvatar_s()).into(holder.found_cim_avatar_s);
                holder.found_tv_username.setText(bean.getUser().getUsername());
                holder.found_tv_date_added.setText(bean.getDate_added());
                holder.found_cim_avatar_s.setVisibility(View.VISIBLE);
                holder.found_tv_username.setVisibility(View.VISIBLE);
                holder.found_tv_date_added.setVisibility(View.VISIBLE);

                holder.found_tv_title.setText(bean.getProduct().getTitle());
                holder.found_tv_address.setText(bean.getProduct().getAddress());
                holder.found_tv_price.setText(bean.getProduct().getPrice());
                holder.found_tv_text.setText(bean.getProduct().getText());
                Picasso.with(context).load(bean.getProduct().getCover()).into(holder.found_im_cover);
                // 点赞头像
                int num = data.get(0).getData().getFeeds().get(position).getLiked_users().size() > 5 ? 5 : data.get(0).getData().getFeeds().get(position).getLiked_users().size();
                for (int i = 0; i < num; i++) {
                    Picasso.with(context).load(data.get(0).getData().getFeeds().get(position).getLiked_users().get(i).getAvatar_s()).into(imgs[i]);
                }
                holder.found_tv_like_count.setText(bean.getLiked_count() + "个人赞");
                holder.found_tv_comment_count.setText(bean.getComment_count() + "");

                holder.itemView.setTag(FIRST_STICKY_VIEW);
            }else{
                if (!TextUtils.equals(bean.getUser().getAvatar_s(),data.get(0).getData().getFeeds().get(position-1).getUser().getAvatar_s())){
                    holder.found_cim_avatar_s.setVisibility(View.VISIBLE);
                    Picasso.with(context).load(bean.getUser().getAvatar_s()).into(holder.found_cim_avatar_s);
                    holder.itemView.setTag(HAS_STICKY_VIEW);
                }else {
                    holder.found_cim_avatar_s.setVisibility(View.VISIBLE);
                    holder.itemView.setTag(NONE_STICKY_VIEW);
                }
                if (!TextUtils.equals(bean.getUser().getUsername(),data.get(0).getData().getFeeds().get(position-1).getUser().getUsername())){
                    holder.found_tv_username.setText(bean.getUser().getUsername());
                    holder.found_tv_username.setVisibility(View.VISIBLE);
                    holder.itemView.setTag(HAS_STICKY_VIEW);
                }else {
                    holder.found_tv_username.setVisibility(View.VISIBLE);
                    holder.itemView.setTag(NONE_STICKY_VIEW);
                }
                if (!TextUtils.equals(bean.getDate_added(),data.get(0).getData().getFeeds().get(position - 1).getDate_added())){
                    holder.found_tv_date_added.setText(bean.getDate_added());
                    holder.found_tv_date_added.setVisibility(View.VISIBLE);
                    holder.itemView.setTag(HAS_STICKY_VIEW);
                }
                else {
                    holder.found_tv_date_added.setVisibility(View.VISIBLE);
                    holder.itemView.setTag(NONE_STICKY_VIEW);
                }

            }

            Picasso.with(context).load(bean.getUser().getAvatar_s()).into(holder.found_cim_avatar_s);
            holder.found_tv_username.setText(bean.getUser().getUsername());
            holder.found_tv_date_added.setText(bean.getDate_added());
            holder.found_tv_title.setText(bean.getProduct().getTitle());
            holder.found_tv_address.setText(bean.getProduct().getAddress());
            holder.found_tv_price.setText(bean.getProduct().getPrice());
            holder.found_tv_text.setText(bean.getProduct().getText());
            Picasso.with(context).load(bean.getProduct().getCover()).into(holder.found_im_cover);
            // 点赞头像
            int num = data.get(0).getData().getFeeds().get(position).getLiked_users().size() > 5 ? 5 : data.get(0).getData().getFeeds().get(position).getLiked_users().size();
            for (int i = 0; i < num; i++) {
                Picasso.with(context).load(data.get(0).getData().getFeeds().get(position).getLiked_users().get(i).getAvatar_s()).into(imgs[i]);
            }
            holder.found_tv_like_count.setText(bean.getLiked_count() + "个人赞");
            holder.found_tv_comment_count.setText(bean.getComment_count() + "");
            holder.found_tv_date_added.setContentDescription(bean.getDate_added());
            holder.found_cim_avatar_s.setContentDescription(bean.getUser().getAvatar_s());
            holder.found_tv_username.setContentDescription(bean.getUser().getUsername());
        }


        // 点击事件
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
        return data != null ?data.get(0).getData().getFeeds().size() : 0;
    }

   public class MyHolder extends RecyclerView.ViewHolder {

        public CircleImageView found_cim_avatar_s;
       public TextView found_tv_username, found_tv_date_added;
       private ImageView found_im_cover;
        private TextView found_tv_title, found_tv_address, found_tv_price, found_tv_text,
                found_tv_like_count, found_tv_comment_count;

        public MyHolder(View itemView) {
            super(itemView);
            found_cim_avatar_s = (CircleImageView) itemView.findViewById(R.id.found_cim_avatar_s);
            found_im_cover = (ImageView) itemView.findViewById(R.id.found_im_cover);
            found_tv_username = (TextView) itemView.findViewById(R.id.found_tv_username);
            found_tv_date_added = (TextView) itemView.findViewById(R.id.found_tv_date_added);
            found_tv_title = (TextView) itemView.findViewById(R.id.found_tv_title);
            found_tv_address = (TextView) itemView.findViewById(R.id.found_tv_address);
            found_tv_price = (TextView) itemView.findViewById(R.id.found_tv_price);
            found_tv_text = (TextView) itemView.findViewById(R.id.found_tv_text);
            found_tv_like_count = (TextView) itemView.findViewById(R.id.found_tv_like_count);
            found_tv_comment_count = (TextView) itemView.findViewById(R.id.found_tv_comment_count);
//点赞头像
            for (int i = 0; i < imgsId.length; i++) {
                imgs[i] = (CircleImageView) itemView.findViewById(imgsId[i]);
            }
        }
    }
}
