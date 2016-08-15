package com.example.dllo.myhunter.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.myhunter.R;

/**
 * Created by zlw on 16/8/12.
 * 登录界面
 */
public class LoginActivity extends AbsBaseActivity implements View.OnClickListener {
    private TextView login_tv_zc;
    private ImageView login_iv_fh;
    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        login_tv_zc = byView(R.id.login_tv_zc);
        login_iv_fh = byView(R.id.login_iv_fh);
    }

    @Override
    protected void initDatas() {
        login_tv_zc.setOnClickListener(this);
        login_iv_fh.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_tv_zc:
                goTo(this,RegisterActivity.class);
                break;
            case R.id.login_iv_fh:
                finish();
                break;
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_in,R.anim.activity_out);
    }
}
