package com.sulilo.petr.topnews.api.response;

/**
 * Created by petr on 07.07.18.
 */

import com.google.gson.annotations.SerializedName;
import com.sulilo.petr.topnews.entity.Category;
import com.sulilo.petr.topnews.entity.NewsShort;

import java.util.List;

public class NewsShortResponse {
    @SerializedName("code")
    private Long code;

    @SerializedName("list")
    private List<NewsShort> list;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public List<NewsShort> getList() {
        return list;
    }

    public void setList(List<NewsShort> list) {
        this.list = list;
    }
}
