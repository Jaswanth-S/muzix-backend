package com.stackroute.muzix.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="Tracks")
public class Track {

    @Id
    private String trackId;

    @JsonProperty("name")

    private String trackName;

    private String comments;

    @JsonProperty("listeners")
    private int trackListeners;

    @JsonProperty("url")
    private String trackUrl;

    private Artist artist;

    public Track(String trackId, String trackName, String comments, int trackListeners, String trackUrl, Artist artist) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.comments = comments;
        this.trackListeners = trackListeners;
        this.trackUrl = trackUrl;
        this.artist = artist;
    }

    public Track() {
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackId='" + trackId + '\'' +
                ", trackName='" + trackName + '\'' +
                ", comments='" + comments + '\'' +
                ", trackListeners='" + trackListeners + '\'' +
                ", trackUrl='" + trackUrl + '\'' +
                ", artist=" + artist +
                '}';
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getTrackListeners() {
        return trackListeners;
    }

    public void setTrackListeners(int trackListeners) {
        this.trackListeners = trackListeners;
    }

    public String getTrackUrl() {
        return trackUrl;
    }

    public void setTrackUrl(String trackUrl) {
        this.trackUrl = trackUrl;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
