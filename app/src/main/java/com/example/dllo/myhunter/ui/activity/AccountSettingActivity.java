package com.example.dllo.myhunter.ui.activity;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.dllo.myhunter.R;

/**
 * Created by zlw on 16/8/18.
 * 账户设置
 */
public class AccountSettingActivity extends AbsBaseActivity implements View.OnClickListener {
    private LinearLayout sex;// 性别
    private LinearLayout birthday;// 生日
    private PopupWindow popupWindow;
    private ImageView back;
    private TextView userName;

    @Override
    protected int setLayout() {
        return R.layout.activity_account_setting;
    }

    @Override
    protected void initViews() {
        sex = byView(R.id.account_sex);
        birthday = byView(R.id.account_birthday);
        back = byView(R.id.found_account_back);
        userName = byView(R.id.account_tv_username);
    }

    @Override
    protected void initDatas() {
        sex.setOnClickListener(this);
        birthday.setOnClickListener(this);
        back.setOnClickListener(this);
        SharedPreferences sp = getSharedPreferences("MyHunter",MODE_PRIVATE);
        String name = sp.getString("key","");
        userName.setText(name);
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
            case R.id.found_account_back:
                finish();
                break;
        }
    }

    private void initPop() {
        popupWindow = new PopupWindow(this);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 加载布局
        View view = LayoutInflater.from(this).inflate(R.layout.account_setting_pop, null);
        popupWindow.setContentView(view);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_pop));
        popupWindow.setFocusable(true);// 获取焦点
        // 点击收回
        popupWindow.setOutsideTouchable(true);
    }

}
