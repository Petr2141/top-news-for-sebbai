package com.sulilo.petr.topnews.api.response;

/**
 * Created by petr on 07.07.18.
 */

import com.google.gson.annotations.SerializedName;
import com.sulilo.petr.topnews.entity.Category;

import java.util.List;

public class CategoryResponse {
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public List<Category> getList() {
        return list;
    }

    public void setList(List<Category> list) {
        this.list = list;
    }

    @SerializedName("code")
    private Long code;

    @SerializedName("list")
    private List<Category> list;
}
