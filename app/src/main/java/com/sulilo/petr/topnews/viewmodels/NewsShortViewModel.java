package com.sulilo.petr.topnews.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.PagedList;
import android.util.Log;

import com.sulilo.petr.topnews.entity.Category;
import com.sulilo.petr.topnews.entity.NewsShort;
import com.sulilo.petr.topnews.repository.NewsShortRepository;

import java.util.List;


public class NewsShortViewModel extends ViewModel {

    private static final int PAGE_SIZE = 5;

    private MutableLiveData<PagedList<NewsShort>> newsShortList;
    private NewsShortRepository repository;
    private Long idCategory;

    private static final String TAG = "CategoriesViewModel";


    public NewsShortViewModel(NewsShortRepository repository, Long idCategory) {
        this.repository = repository;
        this.idCategory = idCategory;
    }


    public LiveData<PagedList<NewsShort>> getNewsShortList() {
        if (newsShortList == null) {
            newsShortList = new MutableLiveData<PagedList<NewsShort>>();
            loadNewsShort();
        }
        return newsShortList;
    }

    private void loadNewsShort() {
        newsShortList.setValue(repository.getListNewsShortInCat(idCategory,PAGE_SIZE).getValue());
    }
}
