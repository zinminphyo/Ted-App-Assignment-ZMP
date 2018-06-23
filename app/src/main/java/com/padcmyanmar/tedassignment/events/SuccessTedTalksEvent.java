package com.padcmyanmar.tedassignment.events;

import com.padcmyanmar.tedassignment.data.vos.TedTalksVO;

import java.util.List;

public class SuccessTedTalksEvent {

    private List<TedTalksVO> tedsTalks;

    public SuccessTedTalksEvent(List<TedTalksVO> tedsTalks) {
        this.tedsTalks = tedsTalks;
    }

    public List<TedTalksVO> getTedsTalks() {
        return tedsTalks;
    }
}
