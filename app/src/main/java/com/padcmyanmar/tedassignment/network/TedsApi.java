package com.padcmyanmar.tedassignment.network;

import android.telecom.Call;

import com.padcmyanmar.tedassignment.network.responses.GetTedsResponse;
import com.padcmyanmar.tedassignment.utils.TedAppConstants;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TedsApi {

    @FormUrlEncoded
    @POST(TedAppConstants.GET_TEDS_TALKS)
    retrofit2.Call<GetTedsResponse> loadtedtalks(
            @Field(TedAppConstants.PARAM_ACCESS_TOKEN) String accessToken,
            @Field(TedAppConstants.PARAM_PAGE) String page);

}
