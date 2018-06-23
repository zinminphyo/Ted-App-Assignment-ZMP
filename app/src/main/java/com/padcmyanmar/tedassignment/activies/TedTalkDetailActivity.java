package com.padcmyanmar.tedassignment.activies;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.tedassignment.R;
import com.padcmyanmar.tedassignment.adapters.NextTedsAdapter;
import com.padcmyanmar.tedassignment.data.models.TedsModel;
import com.padcmyanmar.tedassignment.data.vos.TedTalksVO;
import com.padcmyanmar.tedassignment.delegates.TedsDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TedTalkDetailActivity extends BaseActivity {

    @BindView(R.id.tv_talks_speaker)
    TextView tvTalkSpeakerName;

    @BindView(R.id.tv_talk_des)
    TextView tvTalkDesc;

    @BindView(R.id.iv_ted_talk_back_drop)
    ImageView ivTedTalkBackDrop;

    @BindView(R.id.tv_talks_title)
    TextView tvTalkTitle;

    @BindView(R.id.profile_image)
    ImageView ivProfileImage;

    @BindView(R.id.tv_speaker_name)
    TextView tvSpeakerName;

    @BindView(R.id.tv_speaker_work)
    TextView tvSpeakerWork;
    
    @BindView(R.id.iv_back_button)
    ImageView ivBackButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ted_talk_details);
        ButterKnife.bind(this, this);
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        RecyclerView rvNextTeds = findViewById(R.id.rv_next_teds_lists);
        NextTedsAdapter nextTedsAdapter = new NextTedsAdapter();
        rvNextTeds.setAdapter(nextTedsAdapter);
        rvNextTeds.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        int tedsId = Integer.parseInt(getIntent().getStringExtra("tedsId"));

        TedTalksVO teds = TedsModel.getObjInstance().getTedsById(tedsId);
        bindData(teds);

    }

    public void bindData(TedTalksVO tedTalks) {

        tvTalkSpeakerName.setText(tedTalks.getSpeaker().getSpeakerName());

        tvTalkDesc.setText(tedTalks.getDescription());

        Glide.with(ivTedTalkBackDrop.getContext())
                .load(tedTalks.getImageUrl())
                .into(ivTedTalkBackDrop);

        tvTalkTitle.setText(tedTalks.getTitle());

        tvSpeakerName.setText(tedTalks.getSpeaker().getSpeakerName());


        Glide.with(ivProfileImage.getContext())
                .load(tedTalks.getImageUrl())
                .into(ivProfileImage);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}
