package com.padcmyanmar.tedassignment.data.models;

import com.padcmyanmar.tedassignment.network.HttpUrlConnectionDataAgentImpl;
import com.padcmyanmar.tedassignment.network.TedsDataAgent;

public class TedsModel {

    private static TedsModel objInstance;
    private TedsDataAgent mDataAgent;
    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private TedsModel() {
        mDataAgent = HttpUrlConnectionDataAgentImpl.getObjInstance();
    }

    public static TedsModel getObjInstance(){
        if (objInstance == null){
            objInstance = new TedsModel();
        }
        return objInstance;
    }

    public void loadNewsList(){
             mDataAgent.loadTedLists(1,DUMMY_ACCESS_TOKEN);
    }
}
