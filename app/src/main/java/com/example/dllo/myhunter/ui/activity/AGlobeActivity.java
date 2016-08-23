package com.example.dllo.myhunter.ui.activity;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.AllCityBean;
import com.example.dllo.myhunter.tools.network.DlaHttp;
import com.example.dllo.myhunter.tools.network.OnHttpCallback;
import com.example.dllo.myhunter.ui.adapter.TextTagsAdapter;
import com.moxun.tagcloudlib.view.TagCloudView;

/**
 * 地球仪  转动页面
 */
public class AGlobeActivity extends AbsBaseActivity {
    private TagCloudView fragmentTagcloud;
    private String url = "http://api.breadtrip.com/hunter/products/v2/metadata/?with_citydata&with_sortdata&city_name=%E5%85%A8%E9%83%A8%E5%9F%8E%E5%B8%82";
    private TextTagsAdapter adapter;
    private String[] ints;

    @Override
    protected int setLayout() {
        return R.layout.activity_aglobe;
    }

    @Override
    protected void initViews() {
        fragmentTagcloud = byView(R.id.fragment_tagcloud);
    }

    @Override
    protected void initDatas() {
        DlaHttp.getInstance().startRequest(url, AllCityBean.class, new OnHttpCallback<AllCityBean>() {
            @Override
            public void onSuccess(AllCityBean response) {
                int count = response.getCity_data().getDomestic_city().getAll_city_list().size();
                ints = new String[count];
                for (int i = 0; i < count; i++) {
                    String wel = response.getCity_data().getDomestic_city().getAll_city_list().get(i).getName();
                    ints[i] = wel;
                }
                adapter = new TextTagsAdapter(ints);
                fragmentTagcloud.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
