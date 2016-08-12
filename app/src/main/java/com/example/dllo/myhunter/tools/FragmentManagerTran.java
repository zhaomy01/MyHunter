package com.example.dllo.myhunter.tools;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Fragment管理类
 */
public class FragmentManagerTran {

    private FragmentActivity fragmentAty;

    public FragmentManagerTran(FragmentActivity fragmentAty) {
        this.fragmentAty = fragmentAty;
    }

    /**
     * 占位用的方法
     * @param id
     * @param fragment
     */
    public void fragmentJump(int id, Fragment fragment){
        FragmentManager manager = fragmentAty.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(id,fragment).addToBackStack(null);
        transaction.commit();

    }

    /**
     * 将当前Fragment弹出栈
     */
    public void fragmentRemove(){
        FragmentManager manager = fragmentAty.getSupportFragmentManager();
        manager.popBackStack();
    }

}
