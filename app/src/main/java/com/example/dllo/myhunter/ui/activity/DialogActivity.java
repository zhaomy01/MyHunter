package com.example.dllo.myhunter.ui.activity;

import android.view.Display;
import android.view.Gravity;
import android.view.WindowManager;

import com.example.dllo.myhunter.R;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃    神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * <p>
 * ━━━━━━感觉萌萌哒━━━━━━
 */
public class DialogActivity extends AbsBaseActivity {

    @Override
    protected int setLayout() {
        return R.layout.itme_popup_recomm;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {
        setFinishOnTouchOutside(true);//设置点击空白区域回弹
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay(); // 为获取屏幕宽、高
        android.view.WindowManager.LayoutParams p = getWindow().getAttributes();
        getWindow().setGravity(Gravity.BOTTOM);
        p.height = (int) (d.getHeight() * 0.8); // 高度设置为屏幕的0.8
        p.width = d.getWidth(); // 宽度设置为屏幕的0.7
        getWindow().setAttributes(p);
    }
}
