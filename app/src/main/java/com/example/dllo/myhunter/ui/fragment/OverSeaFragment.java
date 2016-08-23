package com.example.dllo.myhunter.ui.fragment;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.AllCityBean;
import com.example.dllo.myhunter.tools.network.DlaHttp;
import com.example.dllo.myhunter.tools.network.OnHttpCallback;
import com.example.dllo.myhunter.ui.adapter.DomesticAdapter;
import com.example.dllo.myhunter.ui.adapter.ExpandableListViewAdapter;
import com.example.dllo.myhunter.view.MyExpandableListView;
import com.example.dllo.myhunter.view.MyGridView;

/**
 * Created by dllo on 16/8/18.
 */
public class OverSeaFragment extends AbsBaseFragment {
    private DomesticAdapter overseaGridViewAdapter;
    private MyGridView overseaGridView;
    private MyExpandableListView expandableListView;
    private ExpandableListViewAdapter expandableListViewAdapter;
    private String url = "http://api.breadtrip.com/hunter/products/v2/metadata/?with_citydata&with_sortdata&city_name=%E5%85%A8%E9%83%A8%E5%9F%8E%E5%B8%82 ";

    @Override
    protected int setLayout() {
        return R.layout.fragment_oversea;
    }

    @Override
    protected void initViews() {
        overseaGridView = byView(R.id.oversea_gridview);
        expandableListView = byView(R.id.oversea_allcity_expandableListview);
        
    }

    @Override
    protected void initDatas() {
        expandableListView.setGroupIndicator(null);
        expandableListView.setDivider(null);

        DlaHttp.getInstance().startRequest(url, AllCityBean.class, new OnHttpCallback<AllCityBean>() {
            @Override
            public void onSuccess(AllCityBean response) {
                overseaGridViewAdapter = new DomesticAdapter(context, 2);
                overseaGridViewAdapter.setData(response);
                overseaGridView.setAdapter(overseaGridViewAdapter);

                expandableListViewAdapter = new ExpandableListViewAdapter(context);
                expandableListViewAdapter.setFather(response);
                expandableListView.setAdapter(expandableListViewAdapter);


            }

            @Override
            public void onError(Throwable ex) {

            }
        });

    }
}
