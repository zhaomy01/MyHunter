package com.example.dllo.myhunter.ui.activity;

import android.view.View;
import android.widget.LinearLayout;

import com.example.dllo.myhunter.R;

/**
 * Created by zlw on 16/8/18.
 * 账户设置
 */
public class AccountSettingActivity extends AbsBaseActivity implements View.OnClickListener {
    private LinearLayout sex;// 性别
    private LinearLayout birthday;// 生日
    @Override
    protected int setLayout() {
        return R.layout.activity_account_setting;
    }

    @Override
    protected void initViews() {
        sex = byView(R.id.account_sex);
        birthday = byView(R.id.account_birthday);

    }

    @Override
    protected void initDatas() {

        sex.setOnClickListener(this);
        birthday.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.account_sex:
                break;
            case R.id.account_birthday:
                break;
        }
    }
}
