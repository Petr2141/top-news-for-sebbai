package com.sulilo.petr.topnews.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;
import android.text.Html;
import android.text.Spanned;


public class NewsFull {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private Long id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "shortDescription")
    private String shortDescription;
    @ColumnInfo(name = "fullDescription")
    private String fullDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Spanned getFullDescription() {
        Spanned htmlDescription;
        if (fullDescription == null) {
            fullDescription = "";
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                htmlDescription = Html.fromHtml(fullDescription,Html.FROM_HTML_MODE_LEGACY);
            } else {
                htmlDescription = Html.fromHtml(fullDescription);
            }
        return htmlDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }
}
