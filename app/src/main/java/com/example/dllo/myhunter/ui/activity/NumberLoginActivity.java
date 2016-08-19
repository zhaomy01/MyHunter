package com.example.dllo.myhunter.ui.activity;

import android.view.View;
import android.widget.ImageView;

import com.example.dllo.myhunter.R;

/**
 * Created by dllo on 16/8/17.
 */
public class NumberLoginActivity extends AbsBaseActivity implements View.OnClickListener {
    private ImageView iv_back;

    @Override
    protected int setLayout() {
        return R.layout.activity_numberlogin;
    }

    @Override
    protected void initViews() {
        iv_back = byView(R.id.register_iv_fh);

    }

    @Override
    protected void initDatas() {
        iv_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_iv_fh:
                finish();
                break;
        }
    }
}
