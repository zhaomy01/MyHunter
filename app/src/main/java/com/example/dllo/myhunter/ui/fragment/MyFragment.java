package com.example.dllo.myhunter.ui.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.ui.activity.AccountSettingActivity;
import com.example.dllo.myhunter.ui.activity.SettingActivity;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/23.
 */
public class MyFragment extends  AbsBaseFragment implements View.OnClickListener {
    private TextView myUserName;
    private ImageView mySetting;
    private CircleImageView titlePhoto;
    @Override
    protected int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initViews() {
        myUserName = byView(R.id.my_tv_username);
        mySetting = byView(R.id.my_iv_setting);
        titlePhoto = byView(R.id.my_iv_photo);

    }

    @Override
    protected void initDatas() {

        mySetting.setOnClickListener(this);
        titlePhoto.setOnClickListener(this);
        // 从sp 中取得用户名字,在用户名字的地方显示
        SharedPreferences sp = context.getSharedPreferences("MyHunter", Context.MODE_PRIVATE);
         String name = sp.getString("key","");
        myUserName.setText(name);
// 刷新头像
        SharedPreferences spPicture = context.getSharedPreferences("Picture", Context.MODE_PRIVATE);
        titlePhoto.setImageBitmap(BitmapFactory.decodeFile(spPicture.getString("tu","")));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_iv_setting:
                goTo(context, SettingActivity.class);
                getActivity().finish();
                break;
            case R.id.my_iv_photo:
                goTo(context, AccountSettingActivity.class);
                break;
        }
    }
}
