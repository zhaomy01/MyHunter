package com.example.dllo.myhunter.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.CollectionBean;
import com.example.dllo.myhunter.model.db.DatabaseManager;
import com.example.dllo.myhunter.ui.adapter.CollectionAdapter;

import java.util.List;

/**
 * Created by dllo on 16/8/25.
 * 我的页面中我的收藏跳转的Activity
 */
public class CollectionActivity extends AbsBaseActivity implements View.OnClickListener {
    private ListView verticalListView;
    private CollectionAdapter collectionAdapter;
    private List<CollectionBean> data;
    private ImageView imageView_back;

    @Override
    protected int setLayout() {
        return R.layout.activity_collection;
    }

    @Override
    protected void initViews() {
        verticalListView = byView(R.id.collection_vlv);
        imageView_back = byView(R.id.cellection_title_iv);

    }

    @Override
    protected void initDatas() {
        imageView_back.setOnClickListener(this);
        collectionAdapter = new CollectionAdapter(this);
        data = DatabaseManager.getOurInstance().getQueryAll(CollectionBean.class);
        collectionAdapter.setData(data);
        verticalListView.setAdapter(collectionAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cellection_title_iv:
            finish();
            break;
        }
    }
}
