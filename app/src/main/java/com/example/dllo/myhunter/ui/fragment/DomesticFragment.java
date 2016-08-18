package com.example.dllo.myhunter.ui.fragment;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.AllCityBean;
import com.example.dllo.myhunter.tools.network.DlaHttp;
import com.example.dllo.myhunter.tools.network.OnHttpCallback;
import com.example.dllo.myhunter.ui.adapter.DomesticAdapter;
import com.example.dllo.myhunter.view.MyGridView;
import com.example.dllo.myhunter.view.VerticalListView;

/**
 * Created by dllo on 16/8/18.
 */
public class DomesticFragment extends AbsBaseFragment {
    private DomesticAdapter gridViewAdapter, verticlaAdaper;
    private MyGridView myGridView;
    private VerticalListView verticalListView;
    private String url = "http://api.breadtrip.com/hunter/products/v2/metadata/?with_citydata&with_sortdata&city_name=%E5%85%A8%E9%83%A8%E5%9F%8E%E5%B8%82 ";

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
            public void onSuccess(AllCityBean response) {
                gridViewAdapter = new DomesticAdapter(context, 0);
                verticlaAdaper = new DomesticAdapter(context, 1);

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
