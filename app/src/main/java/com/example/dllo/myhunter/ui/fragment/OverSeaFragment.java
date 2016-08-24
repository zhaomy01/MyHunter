package com.example.dllo.myhunter.ui.fragment;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.AllCityBean;
import com.example.dllo.myhunter.model.net.NetUrl;
import com.example.dllo.myhunter.tools.network.DlaHttp;
import com.example.dllo.myhunter.tools.network.OnHttpCallback;
import com.example.dllo.myhunter.ui.adapter.DomesticAdapter;
import com.example.dllo.myhunter.ui.adapter.ExpandableListViewAdapter;
import com.example.dllo.myhunter.view.MyExpandableListView;
import com.example.dllo.myhunter.view.MyGridView;

/**
 * 海外城市
 */
public class OverSeaFragment extends AbsBaseFragment {
    private DomesticAdapter overseaGridViewAdapter;
    private MyGridView overseaGridView;
    private MyExpandableListView expandableListView;
    private ExpandableListViewAdapter expandableListViewAdapter;
    private String url = NetUrl.OVERSEA_URL;

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
