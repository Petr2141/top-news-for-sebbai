package com.sulilo.petr.topnews.repository;

import com.sulilo.petr.topnews.api.response.NewsShortResponse;
import com.sulilo.petr.topnews.entity.NewsShort;
import com.sulilo.petr.topnews.utilities.NewsApp;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PagedKeyShortNewsDataSource extends PageKeyedDataSource<Long,NewsShort> {

    private static final int firstPage = 0;
    private static final long secondPage = 1l;

    private long idCategory;

    public PagedKeyShortNewsDataSource(long idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull LoadInitialCallback<Long, NewsShort> callback) {
        NewsApp.getApi().getNewsListInCategories(idCategory,firstPage).enqueue(new Callback<NewsShortResponse>() {
            @Override
            public void onResponse(Call<NewsShortResponse> call, Response<NewsShortResponse> response) {
                List<NewsShort> dataList = response.body().getList();
                callback.onResult(dataList,null, secondPage);
            }

            @Override
            public void onFailure(Call<NewsShortResponse> call, Throwable t) {
                List<NewsShort> dataList = new ArrayList<>();
                callback.onResult(dataList,null, null);
            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, NewsShort> callback) {
        // ignored, since we only ever append to our initial load
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, NewsShort> callback) {
        int afterKey = params.key.intValue();
        NewsApp.getApi().getNewsListInCategories(idCategory, afterKey).enqueue(new Callback<NewsShortResponse>() {
            @Override
            public void onResponse(Call<NewsShortResponse> call, Response<NewsShortResponse> response) {
                List<NewsShort> dataList = response.body().getList();
                long            nextPage = params.key + 1;

                callback.onResult(dataList,nextPage);
            }

            @Override
            public void onFailure(Call<NewsShortResponse> call, Throwable t) {
                List<NewsShort> dataList = new ArrayList<>();
                callback.onResult(dataList,null);
            }
        });
    }
}
