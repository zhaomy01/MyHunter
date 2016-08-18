package com.example.dllo.myhunter.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.FoundBean;
import com.example.dllo.myhunter.model.net.NetUrl;
import com.example.dllo.myhunter.tools.OnRecycleListenerInterface;
import com.example.dllo.myhunter.tools.network.DlaHttp;
import com.example.dllo.myhunter.tools.network.OnHttpCallback;
import com.example.dllo.myhunter.ui.activity.RecommendWebViewActivity;
import com.example.dllo.myhunter.ui.adapter.FoundAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 发现页面
 */
public class FoundFragment extends AbsBaseFragment {

    private RecyclerView recyclerView;
    private FoundAdapter foundAdapter;
    private List<FoundBean> data;
    private LinearLayout lLStickyHeadView;
    private TextView userName,time;
    private CircleImageView titleImage;

    @Override
    protected int setLayout() {
        return R.layout.fragment_found;
    }

    @Override
    protected void initViews() {
        recyclerView = byView(R.id.found_rv);
        lLStickyHeadView = byView(R.id.found_item_ll);
        time = byView(R.id.found_tv_date_added);
        userName = byView(R.id.found_tv_username);
        titleImage = byView(R.id.found_cim_avatar_s);
    }

    @Override
    protected void initDatas() {
        data = new ArrayList<>();
        foundAdapter = new FoundAdapter(context);
        DlaHttp.getInstance().startRequest(NetUrl.FOUND_URL, FoundBean.class, new OnHttpCallback<FoundBean>() {
            @Override
            public void onSuccess(final FoundBean response) {
                data.add(response);
                foundAdapter.setData(data);
                recyclerView.setAdapter(foundAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                foundAdapter.setOnRecycleListenerInterface(new OnRecycleListenerInterface() {
                    @Override
                    public void onRecycleListenerInterface(int pos) {
                        int url = response.getData().getFeeds().get(pos).getProduct_id();
                        final Intent intent = new Intent(context, RecommendWebViewActivity.class);
                        String foundWebUrl = NetUrl.FOUND_WEBVIEW_START + url + NetUrl.FOUND_WEBVIEW_END;
                        intent.putExtra("path", foundWebUrl);
                        context.startActivity(intent);
                    }
                });
            }

            @Override
            public void onError(Throwable ex) {

            }
        });


        /**
         * 标题悬浮
         */
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                View stickInfoView = recyclerView.findChildViewUnder(lLStickyHeadView.getMeasuredWidth() / 2, 0);
                FoundAdapter.MyHolder holder = (FoundAdapter.MyHolder) recyclerView.getChildViewHolder(stickInfoView);
                userName.setText(holder.found_tv_username.getContentDescription());
                Picasso.with(context).load((String) holder.found_cim_avatar_s.getContentDescription()).into(titleImage);
                time.setText(holder.found_tv_date_added.getContentDescription());
                View transInfoView = recyclerView.findChildViewUnder(lLStickyHeadView.getMeasuredWidth() / 2, lLStickyHeadView.getMeasuredHeight() + 1);
                if (transInfoView != null && transInfoView.getTag() != null) {
                    int transViewStatus = (int) transInfoView.getTag();
                    int dealY = transInfoView.getTop() - lLStickyHeadView.getMeasuredHeight();
                    if (transViewStatus == FoundAdapter.HAS_STICKY_VIEW) {
                        if (transInfoView.getTop() > 0) {
                            lLStickyHeadView.setTranslationY(dealY);
                        } else {
                            lLStickyHeadView.setTranslationY(0);
                        }
                    } else if (transViewStatus == FoundAdapter.NONE_STICKY_VIEW) {
                        lLStickyHeadView.setTranslationY(0);
                    }
                }
            }
        });


    }

}
