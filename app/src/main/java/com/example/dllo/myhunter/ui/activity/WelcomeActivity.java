package com.example.dllo.myhunter.ui.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.example.dllo.myhunter.R;

/**
 * 欢迎页
 */
public class WelcomeActivity extends AbsBaseActivity implements View.OnClickListener {
    private TextView welcome_tv;

    @Override
    protected int setLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initViews() {
        welcome_tv = byView(R.id.welcome_tv);
    }

    @Override
    protected void initDatas() {
        welcome_tv.setOnClickListener(this);
         new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String time = millisUntilFinished / 1000 + "s";
                welcome_tv.setText(time);
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
