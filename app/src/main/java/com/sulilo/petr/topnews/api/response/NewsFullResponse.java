package com.sulilo.petr.topnews.api.response;

/**
 * Created by petr on 07.07.18.
 */

import com.google.gson.annotations.SerializedName;
import com.sulilo.petr.topnews.entity.NewsFull;

import java.util.List;

public class NewsFullResponse {
    @SerializedName("code")
    private Long code;

    @SerializedName("news") // new и остальные поля надо переписать
    private NewsFull news;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public NewsFull getNews() {
        return news;
    }

    public void setNews(NewsFull news) {
        this.news = news;
    }
}
