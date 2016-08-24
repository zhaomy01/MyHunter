package com.example.dllo.myhunter.ui.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.OverSeaJumpBean;
import com.example.dllo.myhunter.model.net.NetUrl;
import com.example.dllo.myhunter.tools.network.DlaHttp;
import com.example.dllo.myhunter.tools.network.OnHttpCallback;
import com.example.dllo.myhunter.ui.activity.AllCityActivity;
import com.example.dllo.myhunter.ui.adapter.OverSeaJumpLvAdapter;
import com.example.dllo.myhunter.view.VerticalListView;

/**
 * Created by dllo on 16/8/23.
 */
public class RecommendedOverSeaFragment extends AbsBaseFragment implements View.OnClickListener {
    private TextView textView_title;
    private OverSeaJumpLvAdapter overSeaJumpLvAdapter;
    private VerticalListView verticalListView;

    @Override
    protected int setLayout() {
        return R.layout.fragment_recommendedoversea;
    }

    @Override
    protected void initViews() {
        textView_title = byView(R.id.item_title_tv);
        verticalListView = byView(R.id.oversea_listview);


    }

    @Override
    protected void initDatas() {
        textView_title.setOnClickListener(this);
        SharedPreferences sp = context.getSharedPreferences("city", Context.MODE_PRIVATE);
        String str = sp.getString("str", "全部城市");
        textView_title.setText(str);
        String url = "http://api.breadtrip.com/hunter/products/v2/?&city_name=" + str;
        overSeaJumpLvAdapter = new OverSeaJumpLvAdapter(context);
        DlaHttp.getInstance().startRequest(url, OverSeaJumpBean.class, new OnHttpCallback<OverSeaJumpBean>() {
            @Override
            public void onSuccess(OverSeaJumpBean response) {
                overSeaJumpLvAdapter.setData(response);
                verticalListView.setAdapter(overSeaJumpLvAdapter);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_title_tv:
                goTo(context, AllCityActivity.class);
                break;
        }
    }
}
