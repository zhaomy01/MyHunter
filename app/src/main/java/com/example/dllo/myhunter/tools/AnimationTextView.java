package com.example.dllo.myhunter.tools;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * 文字动画类
 */
public class AnimationTextView {

    private TranslateAnimation animation;
    private AlphaAnimation alphaAnimation;

    private static final class showAnima {
        private static final AnimationTextView ANIMATION_TEXT_VIEW = new AnimationTextView();
    }

    public static AnimationTextView getAnimation() {
        return showAnima.ANIMATION_TEXT_VIEW;
    }

    //横移动画
    public TranslateAnimation showTranslateOne() {
        animation = new TranslateAnimation(0, 0, 0, 30);
        animation.setDuration(1500);//设置动画持续时间
        animation.setRepeatCount(-1);//设置重复次数
        animation.setRepeatMode(Animation.REVERSE);//设置反方向执行
        return animation;
    }

    public TranslateAnimation showTranslateTwo() {
        animation = new TranslateAnimation(0, 0, 0, 20);
        animation.setDuration(3000);//设置动画持续时间
        animation.setRepeatCount(-1);//设置重复次数
        animation.setRepeatMode(Animation.REVERSE);//设置反方向执行
        return animation;
    }

    public TranslateAnimation showTranslateThree() {
        animation = new TranslateAnimation(0, 0, 0, 30);
        animation.setDuration(2000);//设置动画持续时间
        animation.setRepeatCount(-1);//设置重复次数
        animation.setRepeatMode(Animation.REVERSE);//设置反方向执行
        return animation;
    }

    public TranslateAnimation showTranslateFour() {
        animation = new TranslateAnimation(0, 0, 0, 30);
        animation.setDuration(3000);//设置动画持续时间
        animation.setRepeatCount(-1);//设置重复次数
        animation.setRepeatMode(Animation.REVERSE);//设置反方向执行
        return animation;
    }

    public TranslateAnimation showTranslateFive() {
        animation = new TranslateAnimation(0, 0, 0, 20);
        animation.setDuration(1500);//设置动画持续时间
        animation.setRepeatCount(-1);//设置重复次数
        animation.setRepeatMode(Animation.REVERSE);//设置反方向执行
        return animation;
    }

    public TranslateAnimation showTranslateSix() {
        animation = new TranslateAnimation(0, 0, 0, 35);
        animation.setDuration(4000);//设置动画持续时间
        animation.setRepeatCount(-1);//设置重复次数
        animation.setRepeatMode(Animation.REVERSE);//设置反方向执行
        return animation;
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
