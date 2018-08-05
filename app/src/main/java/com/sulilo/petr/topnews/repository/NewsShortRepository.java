package com.sulilo.petr.topnews.repository;

import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.sulilo.petr.topnews.entity.NewsShort;



public class NewsShortRepository {

    public LiveData<PagedList<NewsShort>> getListNewsShortInCat(long idCategory ,int pageSize){

        NewsShortDataSourceFactory sourceFactory = new NewsShortDataSourceFactory(idCategory);

        LiveData<PagedList<NewsShort>> livePagedList =
            new LivePagedListBuilder(sourceFactory, pageSize).build();

        return livePagedList;
    }

}
