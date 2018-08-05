package com.sulilo.petr.topnews.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;
import android.support.v7.util.DiffUtil;



public class NewsShort {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private long id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "shortDescription")
    private String shortDescription;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public static final DiffUtil.ItemCallback<NewsShort> DIFF_CALLBACK = new DiffUtil.ItemCallback<NewsShort>() {
        @Override
        public boolean areItemsTheSame(NewsShort oldItem, NewsShort newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(NewsShort oldItem, NewsShort newItem) {
            return oldItem.title.equals(newItem.title) & oldItem.shortDescription.equals(newItem.shortDescription);
        }
    };
}
