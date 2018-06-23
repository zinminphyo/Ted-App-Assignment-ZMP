package com.padcmyanmar.tedassignment.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.tedassignment.data.vos.TedTalksVO;

import java.util.List;

public class GetTedsResponse {

    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<TedTalksVO> ted_talks;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<TedTalksVO> getTalks() {
        return ted_talks;
    }

    public boolean isResponseOK() {
        return (code == 200 && ted_talks != null);
    }
}
