package com.padcmyanmar.tedassignment.network;

import com.padcmyanmar.tedassignment.events.ErrorTedTalksEvent;
import com.padcmyanmar.tedassignment.events.SuccessTedTalksEvent;
import com.padcmyanmar.tedassignment.network.responses.GetTedsResponse;
import com.padcmyanmar.tedassignment.utils.TedAppConstants;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgentImpl implements TedsDataAgent {

    private static RetrofitDataAgentImpl sObjInstance;
    private TedsApi theApi;

    private RetrofitDataAgentImpl() {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TedAppConstants.TEDS_TALK_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(TedsApi.class);


    }

    public static RetrofitDataAgentImpl getsObjInstance() {

        if (sObjInstance == null) {
            sObjInstance = new RetrofitDataAgentImpl();
        }
        return sObjInstance;
    }

    @Override
    public void loadTedLists(int page, String accessToken) {
        Call<GetTedsResponse> loadTedsCall = theApi.loadtedtalks(accessToken, String.valueOf(page));
        loadTedsCall.enqueue(new Callback<GetTedsResponse>() {
            @Override
            public void onResponse(Call<GetTedsResponse> call, Response<GetTedsResponse> response) {
                GetTedsResponse tedsResponse = response.body();
                if (tedsResponse != null && tedsResponse.isResponseOK()) {
                    SuccessTedTalksEvent event = new SuccessTedTalksEvent(tedsResponse.getTalks());
                    EventBus.getDefault().post(event);
                } else {
                    if (tedsResponse == null) {
                        ErrorTedTalksEvent event = new ErrorTedTalksEvent("Empty response in network call");
                        EventBus.getDefault().post(event);
                    } else {
                        ErrorTedTalksEvent event = new ErrorTedTalksEvent(tedsResponse.getMessage());
                        EventBus.getDefault().post(event);
                    }
                }
            }

            @Override
            public void onFailure(Call<GetTedsResponse> call, Throwable t) {
                ErrorTedTalksEvent event = new ErrorTedTalksEvent(t.getMessage());
                EventBus.getDefault().post(event);
            }
        });
    }
}
