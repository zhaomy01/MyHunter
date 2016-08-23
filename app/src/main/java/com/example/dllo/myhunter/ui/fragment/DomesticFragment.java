package com.example.dllo.myhunter.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.AllCityBean;
import com.example.dllo.myhunter.model.net.NetUrl;
import com.example.dllo.myhunter.tools.network.DlaHttp;
import com.example.dllo.myhunter.tools.network.OnHttpCallback;
import com.example.dllo.myhunter.ui.activity.MainActivity;
import com.example.dllo.myhunter.ui.adapter.DomesticAdapter;
import com.example.dllo.myhunter.view.MyGridView;
import com.example.dllo.myhunter.view.VerticalListView;

import java.io.UnsupportedEncodingException;

/**
 * Created by dllo on 16/8/18.
 * 国内界面
 */
public class DomesticFragment extends AbsBaseFragment {
    private DomesticAdapter gridViewAdapter, verticlaAdaper;
    private MyGridView myGridView;
    private VerticalListView verticalListView;
    private String url = NetUrl.DOMESTIC_URL;
    private int TYPE_ZERO = 0;  //热门城市
    private int TYPE_ONE = 1;   //全部城市

    @Override
    protected int setLayout() {
        return R.layout.fragment_domestic;
    }

    @Override
    protected void initViews() {
        myGridView = byView(R.id.domestic_gridview);
        verticalListView = byView(R.id.domestic_allcity_verticalListView);
        verticalListView.setDivider(null);

    }

    @Override
    protected void initDatas() {

        DlaHttp.getInstance().startRequest(url, AllCityBean.class, new OnHttpCallback<AllCityBean>() {
            @Override
            public void onSuccess(final AllCityBean response) {
                gridViewAdapter = new DomesticAdapter(context, TYPE_ZERO);
                verticlaAdaper = new DomesticAdapter(context, TYPE_ONE);

                verticlaAdaper.setData(response);
                gridViewAdapter.setData(response);

                myGridView.setAdapter(gridViewAdapter);
                verticalListView.setAdapter(verticlaAdaper);

            }

            @Override
            public void onError(Throwable ex) {

            }
        });

    }

}
