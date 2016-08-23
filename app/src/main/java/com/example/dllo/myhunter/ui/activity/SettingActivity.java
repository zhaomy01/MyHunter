package com.example.dllo.myhunter.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

import com.example.dllo.myhunter.R;

/**
 * Created by zlw on 16/8/18.
 * 设置界面
 */
public class SettingActivity extends AbsBaseActivity implements View.OnClickListener {
    private TextView exit;// 退出
    @Override
    protected int setLayout() {
        return R.layout.actvity_setting;
    }

    @Override
    protected void initViews() {
        exit = byView(R.id.setting_tv_exit);

    }

    @Override
    protected void initDatas() {
        exit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case  R.id.setting_tv_exit:
                dialog();
                break;
        }

    }
    //点击退出按钮 弹出dialog,点击确定,退出;点击取消,留在当前页;

    public void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("你确定退出当前页面吗?");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

}
