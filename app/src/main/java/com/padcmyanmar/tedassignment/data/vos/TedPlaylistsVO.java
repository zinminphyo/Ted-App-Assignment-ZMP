package com.padcmyanmar.tedassignment.data.vos;

public class TedPlaylistsVO {

    private int playlistId;
    private String title;
    private String imageUrl;
    private int totalTalks;
    private TedTalksVO talksInPlaylists;

    public int getPlaylistId() {
        return playlistId;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getTotalTalks() {
        return totalTalks;
    }

    public TedTalksVO getTalksInPlaylists() {
        return talksInPlaylists;
    }
}
