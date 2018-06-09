package com.padcmyanmar.tedassignment.activies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.padcmyanmar.tedassignment.R;
import com.padcmyanmar.tedassignment.adapters.NextTedsAdapter;
import com.padcmyanmar.tedassignment.delegates.TedsDelegate;

public class TedTalkDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ted_talk_details);
        Toolbar toolbar =findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        RecyclerView rvNextTeds = findViewById(R.id.rv_next_teds_lists);
        NextTedsAdapter nextTedsAdapter =new NextTedsAdapter();
        rvNextTeds.setAdapter(nextTedsAdapter);
        rvNextTeds.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

    }
}
