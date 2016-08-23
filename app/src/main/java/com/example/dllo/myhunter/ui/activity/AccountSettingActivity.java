package com.example.dllo.myhunter.ui.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.dllo.myhunter.R;

/**
 * Created by zlw on 16/8/18.
 * 账户设置
 */
public class AccountSettingActivity extends AbsBaseActivity implements View.OnClickListener {
    private LinearLayout sex;// 性别
    private LinearLayout birthday;// 生日
    private PopupWindow popupWindow;

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
        switch (v.getId()) {
            case R.id.account_sex:

                initPop();

                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                } else {
                    popupWindow.showAsDropDown(sex);
                }
                break;
            case R.id.account_birthday:
                break;
        }
    }

    private void initPop() {
        popupWindow = new PopupWindow(this);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 加载布局
        View view = LayoutInflater.from(this).inflate(R.layout.account_setting_pop, null);
        popupWindow.setContentView(view);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_qq));
        popupWindow.setFocusable(true);// 获取焦点
        // 点击收回
        popupWindow.setOutsideTouchable(true);
    }

}
