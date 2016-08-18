package com.example.dllo.myhunter.ui.activity;

import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.ui.adapter.DialogAdapter;
import com.example.dllo.myhunter.view.MyGridView;

/**
 * 主题页面Dialog
 */
public class DialogActivity extends AbsBaseActivity implements AdapterView.OnItemClickListener {
    private MyGridView itme_popup_grid;
    private String[] type = {"全部", "时尚", "城市探索", "个性定制", "聚会", "线上活动", "绘画", "语言",
            "明信片", "户外", "经验分享", "技能get", "亲子",
            "占卜", "音乐", "美食", "运动健身",
            "目的地咨询", "摄影", "新奇特", "手工制作", "文化体验"};
    private DialogAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.itme_popup_recomm;
    }

    @Override
    protected void initViews() {
        itme_popup_grid = byView(R.id.itme_popup_grid);
    }

    @Override
    protected void initDatas() {
        showWindow();
        adapter = new DialogAdapter(this, type);
        itme_popup_grid.setAdapter(adapter);
        itme_popup_grid.setOnItemClickListener(this);
    }

    /**
     * Didlog设置在屏幕的显示大小
     */
    private void showWindow() {
        setFinishOnTouchOutside(true);//设置点击空白区域回弹
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay(); // 为获取屏幕宽、高
        android.view.WindowManager.LayoutParams p = getWindow().getAttributes();
        getWindow().setGravity(Gravity.BOTTOM);
        p.height = (int) (d.getHeight() * 0.8); // 高度设置为屏幕的0.8
        p.width = d.getWidth(); // 宽度设置为屏幕的0.7
        getWindow().setAttributes(p);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("xxxx", "position:" + position);

    }
}
