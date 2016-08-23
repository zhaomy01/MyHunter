package com.example.dllo.myhunter.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dllo.myhunter.tools.FragmentManagerTran;
import com.example.dllo.myhunter.ui.activity.AbsBaseActivity;

/**
 * Fragment基类
 */
public abstract class AbsBaseFragment extends Fragment {
    protected FragmentManagerTran fragmentManagerTran;
    protected Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        fragmentManagerTran = ((AbsBaseActivity) context).getFragmentManagerTran();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(setLayout(), container, false);
    }

    /**
     * 绑定布局
     * @return
     */
    protected abstract int setLayout();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    /**
     * 初始化组件
     */
    protected abstract void initViews();


    /**
     * 绑ID findViewById
     * @param resId
     * @param <T>
     * @return
     */
    protected <T extends View> T byView(int resId) {
        return (T) getView().findViewById(resId);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initDatas();
    }

    /**
     * 初始化数据
     */
    protected abstract void initDatas();

    /**
     * 跳转
     * @param from
     * @param to
     */
    protected void goTo(Context from, Class<? extends AbsBaseActivity> to){
        Intent intent = new Intent(from,to);
        context.startActivity(intent);
    }


}
