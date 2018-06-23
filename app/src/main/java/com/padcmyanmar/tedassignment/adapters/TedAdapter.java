package com.padcmyanmar.tedassignment.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.tedassignment.R;
import com.padcmyanmar.tedassignment.data.vos.TedTalksVO;
import com.padcmyanmar.tedassignment.delegates.TedsDelegate;
import com.padcmyanmar.tedassignment.viewholders.TedsViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zinminphyoe on 6/2/18.
 */

public class TedAdapter extends RecyclerView.Adapter<TedsViewHolder> {

    private TedsDelegate mTedsDelegate;
    private List<TedTalksVO> mTalksList;

    public TedAdapter(TedsDelegate tedsDelegate) {
        mTedsDelegate = tedsDelegate;
        mTalksList = new ArrayList<>();
    }

    @Override
    public TedsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_ted_talks, parent, false);
        return new TedsViewHolder(view, mTedsDelegate);
    }

    @Override
    public void onBindViewHolder(TedsViewHolder holder, int position) {
        holder.setNewData(mTalksList.get(position));
    }


    @Override
    public int getItemCount() {
        return mTalksList.size();
    }

    public void setTedTalksList(List<TedTalksVO> talksList) {

        mTalksList = talksList;
        notifyDataSetChanged();
    }
}
