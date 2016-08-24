package com.example.dllo.myhunter.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dllo.myhunter.R;

/**
 * 注册页面
 */
public class RegisterActivity extends AbsBaseActivity implements View.OnClickListener {
    private ImageView register_iv_fh;
    private EditText register_et_phone;
    private EditText register_et_passwrod;
    private Button  register_btn_agree;
    @Override
    protected int setLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initViews() {
        register_iv_fh = byView(R.id.register_iv_fh);
        register_et_phone = byView(R.id.register_et_phone);
        register_et_passwrod = byView(R.id.register_et_password);
        register_btn_agree = byView(R.id.register_btn_agree);
    }

    @Override
    protected void initDatas() {
        register_iv_fh.setOnClickListener(this);
        register_btn_agree.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_iv_fh:
                finish();
                break;
            case R.id.register_btn_agree:
                SharedPreferences sp = getSharedPreferences("MyHunter",MODE_PRIVATE);
                SharedPreferences.Editor editor= sp.edit();
                String phone = register_et_phone.getText().toString();
                String password = register_et_passwrod.getText().toString();
                if (sp.getString(phone,"6").equals(phone)){
                    Toast.makeText(this, "账号已存在", Toast.LENGTH_SHORT).show();
                }else if (!phone.isEmpty() && !password.isEmpty()){
                    editor.putString(phone,phone);
                    editor.putString(phone+"2",password);
                    editor.putString("key",phone);
                    editor.commit();
                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
               else {
                    Toast.makeText(this, "请输入账号或密码", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
