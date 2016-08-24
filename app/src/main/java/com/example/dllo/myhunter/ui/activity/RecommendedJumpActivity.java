package com.example.dllo.myhunter.ui.activity;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.myhunter.R;
import com.example.dllo.myhunter.model.bean.RecommendedStarHunterJumpBean;
import com.example.dllo.myhunter.model.net.NetUrl;
import com.example.dllo.myhunter.tools.network.DlaHttp;
import com.example.dllo.myhunter.tools.network.OnHttpCallback;
import com.example.dllo.myhunter.ui.adapter.ActiviJumpLvAdapter;
import com.example.dllo.myhunter.ui.adapter.EvaluationJumpLvAdapter;
import com.example.dllo.myhunter.ui.adapter.StoryJumpLvAdapter;
import com.example.dllo.myhunter.view.VerticalListView;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 推荐页面中:明星猎人,体验故事点击背景图片的跳转页面
 */
public class RecommendedJumpActivity extends AbsBaseActivity implements View.OnClickListener {
    private String ID = "id";
    private TextView textView_follower_count, textView_following_count, textView_name, textView_profression, textView_user_desc;
    private TextView textView_goodcomment, textView_receive, textView_reply;
    private CircleImageView imageView_icon;
    private ImageView imageView_back, imageView_backgroundCover;
    private VerticalListView verticalListView_evaluation, verticalListView_activi, verticalListView_story;
    private EvaluationJumpLvAdapter evaluationJumpLvAdapter;
    private ActiviJumpLvAdapter activiJumpLvAdapter;
    private StoryJumpLvAdapter storyJumpLvAdapter;
    private Button button_evaluation_count, button_activi_count, button_story_count;


    @Override
    protected int setLayout() {
        return R.layout.activity_recommendedjump;
    }

    @Override
    protected void initViews() {
        textView_follower_count = byView(R.id.hunder_tv_followers_count);
        textView_following_count = byView(R.id.hunter_tv_following_count);
        textView_name = byView(R.id.hunder_tv_name);
        textView_profression = byView(R.id.hunter_tv_profression);
        textView_user_desc = byView(R.id.hunter_tv_user_desc);
        textView_goodcomment = byView(R.id.hunder_tv_goodcomment_rate);
        textView_receive = byView(R.id.hunder_tv_receive_rate);
        textView_reply = byView(R.id.hunter_tv_reply_rate);
        imageView_icon = byView(R.id.hunter_iv_icon);
        imageView_back = byView(R.id.hunter_iv_back);
        verticalListView_evaluation = byView(R.id.evaluation_lv);
        button_evaluation_count = byView(R.id.btn_evaluation_count);
        button_activi_count = byView(R.id.btn_activi_count);
        imageView_backgroundCover = byView(R.id.hunder_iv_backgroundCover);
        verticalListView_activi = byView(R.id.activi_lv);
        button_story_count = byView(R.id.btn_story_count);
        verticalListView_story = byView(R.id.story_lv);
    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        String id = intent.getStringExtra(ID);
        String url = NetUrl.SH_HEAD_URL + id + NetUrl.SH_TAIL_URL;
        imageView_back.setOnClickListener(this);
        evaluationJumpLvAdapter = new EvaluationJumpLvAdapter(this);
        activiJumpLvAdapter = new ActiviJumpLvAdapter(this);
        storyJumpLvAdapter = new StoryJumpLvAdapter(this);
        DlaHttp.getInstance().startRequest(url, RecommendedStarHunterJumpBean.class, new OnHttpCallback<RecommendedStarHunterJumpBean>() {
            @Override
            public void onSuccess(RecommendedStarHunterJumpBean response) {
                textView_follower_count.setText(String.valueOf(response.getData().getUser_info().getFollowers_count()));
                textView_following_count.setText(String.valueOf(response.getData().getUser_info().getFollowings_count()));
                textView_name.setText(response.getData().getUser_info().getName());
                textView_profression.setText(response.getData().getUser_info().getProfession());
                textView_user_desc.setText(response.getData().getUser_info().getUser_desc());
                textView_goodcomment.setText(response.getData().getUser_info().getGoodcomment_rate() + "%");
                textView_receive.setText(response.getData().getUser_info().getReceive_rate() + "%");
                textView_reply.setText(response.getData().getUser_info().getReply_rate() + "%");
                button_evaluation_count.setText(String.valueOf(response.getData().getClient_comments().getTotal_count()));
                button_activi_count.setText(String.valueOf(response.getData().getProducts().getTotal_count()));
                button_story_count.setText(String.valueOf(response.getData().getTrips().getTotal_count()));

                Picasso.with(getApplicationContext()).load(response.getData().getUser_info().getAvatar_l()).into(imageView_icon);
                Picasso.with(getApplicationContext()).load(response.getData().getUser_info().getCover()).into(imageView_backgroundCover);
                //明星猎人跳转页面的评论解析
                evaluationJumpLvAdapter.setData(response);
                verticalListView_evaluation.setAdapter(evaluationJumpLvAdapter);
                //明星猎人跳转页面的活动解析
                activiJumpLvAdapter.setData(response);
                verticalListView_activi.setAdapter(activiJumpLvAdapter);
                //明星猎人跳转页面的故事集解析
                storyJumpLvAdapter.setData(response);
                verticalListView_story.setAdapter(storyJumpLvAdapter);

            }

            @Override
            public void onError(Throwable ex) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
