package com.sulilo.petr.topnews.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.widget.Toast;

import com.sulilo.petr.topnews.api.response.CategoryResponse;
import com.sulilo.petr.topnews.api.response.NewsFullResponse;
import com.sulilo.petr.topnews.entity.Category;
import com.sulilo.petr.topnews.entity.NewsFull;
import com.sulilo.petr.topnews.utilities.NewsApp;

import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by petr on 26.07.18.
 */

public class NewsFullViewModel extends ViewModel {

    private static final String TAG = "NewsFullViewModel";

    private MutableLiveData<NewsFull> newsFull;

    public LiveData<NewsFull> getNewsFull(long idNews) {
        if (newsFull == null) {
            newsFull = new MutableLiveData<NewsFull>();
            loadNewsFull(idNews);
        }
        return newsFull;
    }

    private void loadNewsFull(long idNews){

        NewsApp.getApi().getFullNews(idNews).enqueue(new Callback<NewsFullResponse>() {
            @Override
            public void onResponse(Call<NewsFullResponse> call, Response<NewsFullResponse> response) {
                newsFull.setValue(response.body().getNews());
            }

            @Override
            public void onFailure(Call<NewsFullResponse> call, Throwable t) {
                Toasty.error(NewsApp.getContext(), "Could not retrieve data", Toast.LENGTH_SHORT, true).show();
                Log.d(TAG,"onFailure");
            }
        });
    }
}
