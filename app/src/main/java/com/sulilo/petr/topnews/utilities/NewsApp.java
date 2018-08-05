package com.sulilo.petr.topnews.utilities;

import android.app.Application;
import android.content.Context;

import com.sulilo.petr.topnews.api.NewsMiniServiceApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NewsApp extends Application {

    private static String BASE_URL = "http://testtask.sebbia.com";

    private static NewsMiniServiceApi newsServiceApi;
    private Retrofit retrofit;

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        initContext();

        retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();

        newsServiceApi = retrofit.create(NewsMiniServiceApi.class);

    }
    private void initContext() {
        context = this;
    }

    public static NewsMiniServiceApi getApi(){
        return newsServiceApi;
    }

    public static Context getContext() {
        return context;
    }
}
