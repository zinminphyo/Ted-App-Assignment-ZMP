package com.padcmyanmar.tedassignment.data.vos;

import java.util.List;

public class PodCastVO {

    private int podcastId;
    private String title;
    private String imageUrl;
    private String description;
    private List<SegmentVO> segments;

    public int getPodcastId() {
        return podcastId;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public List<SegmentVO> getSegments() {
        return segments;
    }
}
