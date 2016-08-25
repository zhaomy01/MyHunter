package com.example.dllo.myhunter.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.dllo.myhunter.R;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 账户设置
 */
public class AccountSettingActivity extends AbsBaseActivity implements View.OnClickListener {
    private LinearLayout sex;// 性别
    private LinearLayout birthday;// 生日
    private PopupWindow popupWindow;
    private ImageView back;
    private TextView userName;
    private CircleImageView titlePhoto;// 头像
    private Button btn_picture, btn_photo, btn_cancle;
    private SharedPreferences.Editor editor;

    @Override
    protected int setLayout() {
        return R.layout.activity_account_setting;
    }

    @Override
    protected void initViews() {
        sex = byView(R.id.account_sex);
        birthday = byView(R.id.account_birthday);
        back = byView(R.id.found_account_back);
        userName = byView(R.id.account_tv_username);
        titlePhoto = byView(R.id.account_cim_titlephoto);
    }

    @Override
    protected void initDatas() {
        SharedPreferences spPicture = getSharedPreferences("Picture", MODE_PRIVATE);
        editor = spPicture.edit();
        titlePhoto.setImageBitmap(BitmapFactory.decodeFile(spPicture.getString("tu", "")));
        sex.setOnClickListener(this);
        birthday.setOnClickListener(this);
        back.setOnClickListener(this);
        titlePhoto.setOnClickListener(this);
        // 获取名字
        SharedPreferences sp = getSharedPreferences("MyHunter", MODE_PRIVATE);
        String name = sp.getString("key", "");
        userName.setText(name);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.account_sex:
                initPop();
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                } else {
                    popupWindow.showAsDropDown(sex);
                }
                break;
            case R.id.account_birthday:
                break;
            case R.id.found_account_back:
                goTo(this, MainActivity.class);
                finish();
                break;
            case R.id.account_cim_titlephoto:
                // 调取系统的相册
                showDialog();
                break;
        }
    }

    private void initPop() {
        popupWindow = new PopupWindow(this);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 加载布局
        View view = LayoutInflater.from(this).inflate(R.layout.account_setting_pop, null);
        popupWindow.setContentView(view);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_pop));
        popupWindow.setFocusable(true);// 获取焦点
        // 点击收回
        popupWindow.setOutsideTouchable(true);
    }
    // 选取图片,弹出dialog
    private void showDialog() {
        View view = getLayoutInflater().inflate(R.layout.photo_choose_dialog, null);
        final Dialog dialog = new Dialog(this, R.style.transparentFrameWindowStyle);
        dialog.setContentView(view, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        Window window = dialog.getWindow();
        // 设置显示动画
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.x = 0;
        wl.y = getWindowManager().getDefaultDisplay().getHeight();
        // 以下这两句是为了保证按钮可以水平满屏
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;

        // 设置显示位置
        dialog.onWindowAttributesChanged(wl);
        // 设置点击外围解散
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();

        btn_picture = (Button) window.findViewById(R.id.btn_picture);
        btn_photo = (Button) window.findViewById(R.id.btn_photo);
        btn_cancle = (Button) window.findViewById(R.id.btn_cancle);

        // 相册
        btn_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_PICK, null);
                intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent1, 1);
                dialog.dismiss();
            }
        });
        // 相机
        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent2.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "head.jpg")));
                startActivityForResult(intent2, 2);// 采用ForResult打开
                dialog.dismiss();
            }
        });
        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    cropPhoto(data.getData());// 裁剪图片
                }
                Uri selectdeImage = data.getData();
                Cursor cursor = getContentResolver().query(selectdeImage, null, null, null, null);
                while (cursor.moveToNext()) {
                    String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                    titlePhoto.setImageBitmap(BitmapFactory.decodeFile(path));
                    editor.putString("tu", path);
                    editor.commit();
                }
                cursor.close();
                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    File temp = new File(Environment.getExternalStorageDirectory() + "/head.jpg");
                    cropPhoto(Uri.fromFile(temp));// 裁剪图片
                }
                break;
        }
    }

    /**
     * 调用系统的裁剪
     *
     * @param uri
     */
    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3);
    }

}