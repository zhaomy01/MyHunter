package com.example.dllo.myhunter.ui.activity;

import android.support.design.widget.FloatingActionButton;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.ui.fragment.FoundFragment;
import com.example.dllo.myhunter.ui.fragment.RecommendedFragment;
import com.example.dllo.myhunter.view.FanMenuButtons;

public class MainActivity extends AbsBaseActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private RadioGroup main_radiog;
    private RecommendedFragment recommendedFragment;
    private FoundFragment foundFragment;
    private ImageButton main_ib_trip;
    private PopupWindow popupWindow;
    private LinearLayout plus_lily_qx,main_linay_ys;
    private ImageView plus_iv_city,plus_iv_travel;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        main_radiog = byView(R.id.main_radiog);
        main_ib_trip = byView(R.id.main_ib_trip);
        main_linay_ys = byView(R.id.main_linay_ys);
    }

    @Override
    protected void initDatas() {
        recommendedFragment = new RecommendedFragment();
        foundFragment = new FoundFragment();
        main_radiog.setOnCheckedChangeListener(this);
        main_ib_trip.setOnClickListener(this);
        main_radiog.check(R.id.main_rb_recommended);
        initpopup();

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.myFAB);
        final FanMenuButtons sub = (FanMenuButtons) findViewById(R.id.myFABSubmenu);
        if (sub != null) {
            sub.setOnFanButtonClickListener(new FanMenuButtons.OnFanClickListener() {
                @Override
                public void onFanButtonClicked(int index) {
                    if (index == 7){
                        goTo(MainActivity.this,AGlobeActivity.class);
                    }
                    if (index == 6){
                        goTo(MainActivity.this,LoginActivity.class);
                    }
                }
            });

            if (fab != null) {
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sub.toggleShow();
                    }
                });
            }
        }

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
                goTo(this,LoginActivity.class);
                break;
            case R.id.main_rb_my:
                goTo(this,LoginActivity.class);
                break;

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_ib_trip:
                popupWindow.showAsDropDown(main_linay_ys,0,2);
                showScaleAnim();
                showAnim();
                break;

        }
    }


    /**
     * popupWindow
     */
    public void initpopup(){
        popupWindow = new PopupWindow(this);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        View view = getLayoutInflater().inflate(R.layout.itme_popup_wo,null);
        plus_iv_city = (ImageView) view.findViewById(R.id.plus_iv_city);
        plus_iv_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goTo(MainActivity.this,AsAHunterActivity.class);
            }
        });
        plus_iv_travel = (ImageView) view.findViewById(R.id.plus_iv_travel);
        plus_iv_travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo(MainActivity.this,BreadTravelActivity.class);
            }
        });
        plus_lily_qx = (LinearLayout) view.findViewById(R.id.plus_lily_qx);
        plus_lily_qx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);

        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.width = d.getWidth();
        getWindow().setAttributes(p);

    }

    /**
     * 加号里面的两个Button的动画效果
     */
    public void showScaleAnim(){
        AnimationSet animationSet = new AnimationSet(true);
        //缩放
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1f, 0.0f, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(500);
        animationSet.addAnimation(scaleAnimation);
        //平移
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_SELF, 0.9f,
                Animation.RELATIVE_TO_PARENT, 0);
        translateAnimation.setDuration(500);
        animationSet.addAnimation(translateAnimation);
        //旋转
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(500);
        animationSet.addAnimation(rotateAnimation);
        plus_iv_city.startAnimation(animationSet);
        plus_iv_travel.startAnimation(animationSet);
    }
    //加号的旋转
    public void showAnim(){
        RotateAnimation rotateAnimation = new RotateAnimation(0, 180,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(500);
        main_ib_trip.startAnimation(rotateAnimation);
    }

}
