package com.sulilo.petr.topnews.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;



public class Category {
    @PrimaryKey
    @ColumnInfo(name = "id")
    Long id;

    @ColumnInfo(name = "name")
    String name;

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
