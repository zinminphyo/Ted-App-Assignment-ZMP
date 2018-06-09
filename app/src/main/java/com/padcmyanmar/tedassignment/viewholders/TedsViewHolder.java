package com.padcmyanmar.tedassignment.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.padcmyanmar.tedassignment.delegates.TedsDelegate;

/**
 * Created by zinminphyoe on 6/2/18.
 */

public class TedsViewHolder extends RecyclerView.ViewHolder {

    private TedsDelegate mTedsDelegate;

    public TedsViewHolder(View itemView, TedsDelegate tedsDelegate) {
        super(itemView);
        mTedsDelegate = tedsDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTedsDelegate.onTapTedLists();
            }
        });
    }
}
