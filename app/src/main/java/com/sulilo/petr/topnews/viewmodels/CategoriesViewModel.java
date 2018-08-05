package com.sulilo.petr.topnews.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.widget.Toast;

import com.sulilo.petr.topnews.api.response.CategoryResponse;
import com.sulilo.petr.topnews.entity.Category;
import com.sulilo.petr.topnews.utilities.NewsApp;

import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CategoriesViewModel extends ViewModel {

    private static final String TAG = "CategoriesViewModel";

    private MutableLiveData<List<Category>> categoryList;

    public LiveData<List<Category>> getCategories() {
        if (categoryList == null) {
            categoryList = new MutableLiveData<List<Category>>();
            loadCategories();
        }
        return categoryList;
    }

    private void loadCategories(){
        NewsApp.getApi().getListOfCategories().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                categoryList.setValue(response.body().getList());
                Log.d(TAG,"onResponse, categories size = " + categoryList.getValue().size());
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                Toasty.error(NewsApp.getContext(), "Could not retrieve data", Toast.LENGTH_SHORT, true).show();
                Log.d(TAG,"onFailure");
            }
        });
    }
}
