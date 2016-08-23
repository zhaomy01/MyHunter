package com.example.dllo.myhunter.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.ui.adapter.AllCityViewpagerAdapter;
import com.example.dllo.myhunter.ui.fragment.DomesticFragment;
import com.example.dllo.myhunter.ui.fragment.OverSeaFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 全部城市页面
 */
public class AllCityActivity extends AbsBaseActivity implements View.OnClickListener {
    private EditText editText;
    private ImageView imageView,imageView_back;
    private TabLayout tabLayout;
    private AllCityViewpagerAdapter viewPagerAdapter;
    private List<Fragment> fragments;
    private ViewPager viewPager;
    @Override
    protected int setLayout() {
        return R.layout.activity_allcity;
    }

    @Override
    protected void initViews() {
        editText  = byView(R.id.allcity_editText);
        imageView = byView(R.id.allcity_delete);
        imageView_back = byView(R.id.back_btn);
        tabLayout = byView(R.id.tabLayout);
    }

    @Override
    protected void initDatas() {
        viewPager = byView(R.id.viewPager);
        imageView_back.setOnClickListener(this);

        fragments = new ArrayList<>();
        fragments.add(new DomesticFragment());
        fragments.add(new OverSeaFragment());

        viewPagerAdapter = new AllCityViewpagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onClick(View v) {
        finish();

    }
}
