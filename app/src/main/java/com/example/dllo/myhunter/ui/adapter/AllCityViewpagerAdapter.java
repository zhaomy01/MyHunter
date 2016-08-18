package com.example.dllo.myhunter.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/8/18.
 */
public class AllCityViewpagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<String> titleList;
    public AllCityViewpagerAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
        titleList = new ArrayList<>();
        titleList.add("国内");
        titleList.add("海外");
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments != null ? fragments.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
