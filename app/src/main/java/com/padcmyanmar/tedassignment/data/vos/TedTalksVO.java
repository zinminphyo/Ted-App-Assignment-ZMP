package com.padcmyanmar.tedassignment.data.vos;

import java.util.List;

public class TedTalksVO {

    private int talkId;
    private String title;
    private SpeakerVO speaker;
    private String imageUrl;
    private String descriptionInSec;
    private  String description;

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

    public String getDescriptionInSec() {
        return descriptionInSec;
    }

    public String getDescription() {
        return description;
    }
}
