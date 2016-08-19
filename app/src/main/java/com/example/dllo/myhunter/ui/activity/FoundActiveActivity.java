package com.example.dllo.myhunter.ui.activity;

import android.view.View;
import android.widget.ImageView;

import com.example.dllo.myhunter.R;

/**
 * Created by zlw on 16/8/18.
 * 发现旁边笔的页面
 */
public class FoundActiveActivity extends AbsBaseActivity {
    private ImageView back;
    @Override
    protected int setLayout() {
        return R.layout.activity_found_active;
    }

    @Override
    protected void initViews() {

        back = byView(R.id.found_active_back);
    }

    @Override
    protected void initDatas() {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
