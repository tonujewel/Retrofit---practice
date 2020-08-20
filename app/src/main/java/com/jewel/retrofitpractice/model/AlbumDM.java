package com.jewel.retrofitpractice.model;

import com.google.gson.annotations.SerializedName;

public class AlbumDM {

    @SerializedName("albumId")
    private Integer albumid;
    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
    @SerializedName("thumbnailUrl")
    private String thumbnailurl;

    public AlbumDM(Integer albumid, Integer id, String title, String url, String thumbnailurl) {
        this.albumid = albumid;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailurl = thumbnailurl;
    }

    public Integer getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Integer albumid) {
        this.albumid = albumid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailurl() {
        return thumbnailurl;
    }

    public void setThumbnailurl(String thumbnailurl) {
        this.thumbnailurl = thumbnailurl;
    }
}
