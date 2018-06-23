package com.padcmyanmar.tedassignment.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TedTalksVO {
    @SerializedName("talk_id")
    private int talkId;

    @SerializedName("title")
    private String title;
    private SpeakerVO speaker;
    private String imageUrl;

    @SerializedName("durationInSec")
    private int descriptionInSec;
    private String description;

    private List<TagVO> tags;

    public int getTalkId() {
        return talkId;
    }

    public String getTitle() {
        return title;
    }

    public SpeakerVO getSpeaker() {
        return speaker;
    }

    public List<TagVO> getTags() {
        return tags;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getDescriptionInSec() {
        return descriptionInSec;
    }

    public String getDescription() {
        return description;
    }
}
