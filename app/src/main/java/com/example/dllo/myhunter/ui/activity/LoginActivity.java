package com.example.dllo.myhunter.ui.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.myhunter.R;

/**
 * Created by zlw on 16/8/12.
 * 登录界面
 */
public class LoginActivity extends AbsBaseActivity implements View.OnClickListener {
    private TextView login_tv_zc, login_tv_forget;
    private ImageView login_iv_fh;
    private Button btn_toNumberLogin, btn_toEmailLogin;

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        login_tv_zc = byView(R.id.login_tv_zc);
        login_iv_fh = byView(R.id.login_iv_fh);
        btn_toNumberLogin = byView(R.id.login_btn_toNumberLogin);
        btn_toEmailLogin = byView(R.id.login_btn_toEmailLogin);
        login_tv_forget = byView(R.id.login_tv_forget);
    }

    @Override
    protected void initDatas() {
        login_tv_zc.setOnClickListener(this);
        login_iv_fh.setOnClickListener(this);
        btn_toNumberLogin.setOnClickListener(this);
        btn_toEmailLogin.setOnClickListener(this);
        login_tv_forget.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_tv_zc:
                goTo(this, RegisterActivity.class);
                finish();
                break;
            case R.id.login_iv_fh:
                finish();
                break;
            case R.id.login_btn_toNumberLogin:
                goTo(this, NumberLoginActivity.class);
                finish();
                break;
            case R.id.login_btn_toEmailLogin:
                goTo(this, EmailLoginActivity.class);
                finish();
                break;
            case R.id.login_tv_forget:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setView(R.layout.item_dialog_forget);
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
                break;
        }
    }

}
