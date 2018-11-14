package com.shop.entity;

public class NewsWithBLOBs extends News {
    private String thumb_url;

    private String content;

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url == null ? null : thumb_url.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}