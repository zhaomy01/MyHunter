package com.example.dllo.myhunter.ui.activity;

import android.view.View;
import android.widget.ImageView;

import com.example.dllo.myhunter.R;

/**
 * 注册页面
 */
public class RegisterActivity extends AbsBaseActivity implements View.OnClickListener {
    private ImageView register_iv_fh;
    @Override
    protected int setLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initViews() {
        register_iv_fh = byView(R.id.register_iv_fh);
    }

    @Override
    protected void initDatas() {
        register_iv_fh.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_iv_fh:
                finish();
                break;
        }
    }
}
