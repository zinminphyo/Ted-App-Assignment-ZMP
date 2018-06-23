package com.padcmyanmar.tedassignment.activies;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.padcmyanmar.tedassignment.R;
import com.padcmyanmar.tedassignment.adapters.TedAdapter;
import com.padcmyanmar.tedassignment.data.models.TedsModel;
import com.padcmyanmar.tedassignment.data.vos.TedTalksVO;
import com.padcmyanmar.tedassignment.delegates.TedsDelegate;
import com.padcmyanmar.tedassignment.events.SuccessTedTalksEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends BaseActivity implements TedsDelegate {

    private TedAdapter mTedAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView rvTeds = findViewById(R.id.rv_ted_talks);
        mTedAdapter = new TedAdapter(this);
        rvTeds.setAdapter(mTedAdapter);
        rvTeds.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        TedsModel.getObjInstance().loadNewsList();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTapTedLists(TedTalksVO tedTalk) {
        Intent intent = new Intent(getApplicationContext(), TedTalkDetailActivity.class);
        intent.putExtra("tedsId", String.valueOf(tedTalk.getTalkId()));

        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetTedsTalks(SuccessTedTalksEvent event) {

        Log.d("onSuccessGetTeds", "onSuccessEvent : " + event.getTedsTalks());
        for (TedTalksVO teds : event.getTedsTalks()) {
            mTedAdapter.setTedTalksList(event.getTedsTalks());
        }


    }
}
