package com.sulilo.petr.topnews.repository;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

import com.sulilo.petr.topnews.entity.NewsShort;


public class NewsShortDataSourceFactory extends DataSource.Factory<Long,NewsShort> {

    private long idCategory;

    public NewsShortDataSourceFactory(long idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public DataSource<Long, NewsShort> create() {
        PagedKeyShortNewsDataSource source = new PagedKeyShortNewsDataSource(idCategory);
        return source;
    }
}
