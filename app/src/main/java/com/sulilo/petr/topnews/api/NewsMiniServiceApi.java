package com.sulilo.petr.topnews.api;

/**
 * Created by petr on 06.07.18.
 */

import com.sulilo.petr.topnews.api.response.CategoryResponse;
import com.sulilo.petr.topnews.api.response.NewsFullResponse;
import com.sulilo.petr.topnews.api.response.NewsShortResponse;
import com.sulilo.petr.topnews.entity.Category;
import com.sulilo.petr.topnews.entity.NewsFull;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NewsMiniServiceApi {

    @GET("/v1/news/categories")
    Call<CategoryResponse> getListOfCategories();

    @GET("/v1/news/categories/{id}/news")
    Call<NewsShortResponse> getNewsListInCategories(@Path("id") long idCategory, @Query("page") int page);

    @GET("/v1/news/details")
    Call<NewsFullResponse> getFullNews(@Query("id") long idNews);
    // если запрос ID которого нет в бд, то возвращает 200 и другой формвт json, т.е.
    // надо обработать такой вариант

}
