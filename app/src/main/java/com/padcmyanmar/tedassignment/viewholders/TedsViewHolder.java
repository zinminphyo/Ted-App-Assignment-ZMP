package com.padcmyanmar.tedassignment.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.tedassignment.R;
import com.padcmyanmar.tedassignment.data.vos.TedTalksVO;
import com.padcmyanmar.tedassignment.delegates.TedsDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zinminphyoe on 6/2/18.
 */

public class TedsViewHolder extends RecyclerView.ViewHolder {

    private TedsDelegate mTedsDelegate;
    private TedTalksVO mTalkTeds;

    @BindView(R.id.iv_talks_back_drop)
    ImageView ivTalksBackDrop;
    @BindView(R.id.tv_talks_speaker)
    TextView tvTalksSpeaker;
    @BindView(R.id.tv_talks_title)
    TextView tvTalksTitle;
    @BindView(R.id.tv_time_duration)
    TextView tvTimeDuration;

    public TedsViewHolder(View itemView, TedsDelegate tedsDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mTedsDelegate = tedsDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTedsDelegate.onTapTedLists(mTalkTeds);
            }
        });
    }

    public void setNewData(TedTalksVO tedsTalks) {

        mTalkTeds = tedsTalks;
        tvTalksSpeaker.setText(mTalkTeds.getSpeaker().getSpeakerName());
        tvTalksTitle.setText(mTalkTeds.getTitle());
        tvTimeDuration.setText(String.valueOf(tedsTalks.getDescriptionInSec()));

        Glide.with(ivTalksBackDrop.getContext())
                .load(tedsTalks.getImageUrl())
                .into(ivTalksBackDrop);


    }
}
