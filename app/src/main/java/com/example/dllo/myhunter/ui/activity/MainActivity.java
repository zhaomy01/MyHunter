package com.example.dllo.myhunter.ui.activity;

import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.ui.fragment.FoundFragment;
import com.example.dllo.myhunter.ui.fragment.PlusFragment;
import com.example.dllo.myhunter.ui.fragment.RecommendedFragment;

public class MainActivity extends AbsBaseActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private RadioGroup main_radiog;
    private RecommendedFragment recommendedFragment;
    private FoundFragment foundFragment;
    private PlusFragment plusFragment;
    private ImageButton main_ib_trip;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        main_radiog = byView(R.id.main_radiog);
        main_ib_trip = byView(R.id.main_ib_trip);
    }

    @Override
    protected void initDatas() {
        recommendedFragment = new RecommendedFragment();
        foundFragment = new FoundFragment();
        plusFragment = new PlusFragment();
        main_radiog.setOnCheckedChangeListener(this);
        main_ib_trip.setOnClickListener(this);

        main_radiog.check(R.id.main_rb_recommended);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_rb_recommended:
                fragmentManagerTran.fragmentJump(R.id.main_fly_fragment, recommendedFragment);
                break;
            case R.id.main_rb_found:
                fragmentManagerTran.fragmentJump(R.id.main_fly_fragment, foundFragment);
                break;
            case R.id.main_rb_message:

                break;
            case R.id.main_rb_my:

                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_ib_trip:
                fragmentManagerTran.fragmentJump(R.id.main_fly_fragment,plusFragment);
                break;
        }
    }
}
