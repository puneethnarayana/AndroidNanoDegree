package com.example.bill.movies1;

import java.io.Serializable;

/**
 * Created by bill on 3/6/16.
 */
public class Movies implements Serializable {

    private String thePath;
    private int id;
    private String originalTitle;
    private String summary;
    private String releaseDate;
    private String posterPath;
    private double popularity;
    private String title;
    private  int voteAverage;
    private int voteCount;

    public int getVoteCount() {
        return voteCount;
    }
    public void setVoteCount(int vote_count) {
        this.voteCount = vote_count;
    }

    public int getVoteAverage() {
        return voteAverage;
    }
    public void setVoteAverage(int voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getPath() {
        return thePath;
    }

    public void setPath(String thePath) {
        this.thePath = thePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String original_title) {
        this.originalTitle = original_title;
    }

    public String getOverview() {
        return summary;
    }

    public void setOverview(String overview) {
        this.summary = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String release_date) {
        this.releaseDate = release_date;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String poster_path) {
        this.posterPath = poster_path;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
