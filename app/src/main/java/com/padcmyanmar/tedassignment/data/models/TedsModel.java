package com.padcmyanmar.tedassignment.data.models;

import android.util.Log;

import com.padcmyanmar.tedassignment.data.vos.TedTalksVO;
import com.padcmyanmar.tedassignment.events.SuccessTedTalksEvent;
import com.padcmyanmar.tedassignment.network.HttpUrlConnectionDataAgentImpl;
import com.padcmyanmar.tedassignment.network.RetrofitDataAgentImpl;
import com.padcmyanmar.tedassignment.network.TedsDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;

public class TedsModel {

    private static TedsModel objInstance;
    private TedsDataAgent mDataAgent;
    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";
    private Map<Integer, TedTalksVO> mTedTalks;

    private TedsModel() {

        mDataAgent = RetrofitDataAgentImpl.getsObjInstance();

        mTedTalks = new HashMap<>();

        EventBus.getDefault().register(this);

    }

    public static TedsModel getObjInstance() {
        if (objInstance == null) {
            objInstance = new TedsModel();
        }
        return objInstance;
    }


    public void loadNewsList() {
        mDataAgent.loadTedLists(1, DUMMY_ACCESS_TOKEN);
    }

    public TedTalksVO getTedsById(int tedsId) {
        return mTedTalks.get(tedsId);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccessGetTedTalks(SuccessTedTalksEvent event) {
        for (TedTalksVO tedTalks : event.getTedsTalks()) {
            mTedTalks.put(tedTalks.getTalkId(), tedTalks);
        }

    }
}
