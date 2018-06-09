package com.padcmyanmar.tedassignment.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.tedassignment.R;
import com.padcmyanmar.tedassignment.delegates.TedsDelegate;
import com.padcmyanmar.tedassignment.viewholders.NextTedsTalkViewHolder;
import com.padcmyanmar.tedassignment.viewholders.TedsViewHolder;

public class NextTedsAdapter extends RecyclerView.Adapter {


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_teds_list,parent,false);
        return new NextTedsTalkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
