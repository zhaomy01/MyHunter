package com.example.dllo.myhunter.tools;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * 文字动画类
 */
public class AnimationTextView {

    private AlphaAnimation alphaAnimation;

    private static final class showAnima {
        private static final AnimationTextView ANIMATION_TEXT_VIEW = new AnimationTextView();
    }

    public static AnimationTextView getAnimation() {
        return showAnima.ANIMATION_TEXT_VIEW;
    }

    private TranslateAnimation getTranslateAnimation(int toYDelta, int durationMillis) {
        TranslateAnimation animation = new TranslateAnimation(0, 0, 0, toYDelta);
        animation.setDuration(durationMillis);//设置动画持续时间
        animation.setRepeatCount(-1);//设置重复次数
        animation.setRepeatMode(Animation.REVERSE);//设置反方向执行
        return animation;
    }

    //横移动画
    public TranslateAnimation showTranslateOne() {
        return getTranslateAnimation(30, 1500);
    }

    public TranslateAnimation showTranslateTwo() {
        return getTranslateAnimation(20, 3000);
    }

    public TranslateAnimation showTranslateThree() {
        return getTranslateAnimation(30, 2000);
    }

    public TranslateAnimation showTranslateFour() {
        return getTranslateAnimation(30, 3000);
    }

    public TranslateAnimation showTranslateFive() {
        return getTranslateAnimation(20, 1500);
    }

    public TranslateAnimation showTranslateSix() {
        return getTranslateAnimation(35, 4000);
    }

    //虚化
    public AlphaAnimation showAnimation() {
        alphaAnimation = new AlphaAnimation(1.0f, 0.2f);
        alphaAnimation.setDuration(4000);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        alphaAnimation.setRepeatCount(-1);
        return alphaAnimation;
    }


}
