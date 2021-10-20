package com.example.news.Models;

public class BannerDetails {

    int id;
    String headline;
    String imgLink,url;

    public BannerDetails(int id, String headline, String imgLink,String url) {
        this.id = id;
        this.headline = headline;
        this.imgLink = imgLink;
        this.url=url;
    }

    public int getId() {
        return id;
    }

    public String getHeadline() {
        return headline;
    }

    public String getImgLink() {
        return imgLink;
    }
    public String getUrl() {
        return url;
    }
}
