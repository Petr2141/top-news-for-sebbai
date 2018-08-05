package com.sulilo.petr.topnews.activities;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.sulilo.petr.topnews.R;
import com.sulilo.petr.topnews.adapters.CategoriesAdapter;
import com.sulilo.petr.topnews.adapters.ShortNewsAdapter;
import com.sulilo.petr.topnews.entity.NewsShort;
import com.sulilo.petr.topnews.repository.NewsShortDataSourceFactory;
import com.sulilo.petr.topnews.repository.NewsShortRepository;
import com.sulilo.petr.topnews.viewmodels.NewsShortViewModel;
import com.sulilo.petr.topnews.viewmodels.ViewModelParameterizedProvider;

import java.util.ArrayList;
import java.util.List;

public class NewsShortActivity extends AppCompatActivity {

    static String TAG = "NewsShortActivity";
    private static final int ID_CATEGORY = 0;
    private static final int PAGE_SIZE = 5;

    RecyclerView recyclerView;
    NewsShortViewModel model;
    Long idCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_short);

        recyclerView = findViewById(R.id.recyclerNewsShort);

        final ShortNewsAdapter adapter = new ShortNewsAdapter();

        model = getViewModel();

        NewsShortDataSourceFactory sourceFactory = new NewsShortDataSourceFactory(idCategory);

        LiveData<PagedList<NewsShort>> livePagedList =
                new LivePagedListBuilder(sourceFactory, PAGE_SIZE).build();

        livePagedList.observe(this, (PagedList<NewsShort> newsShorts) -> {
            adapter.submitList(livePagedList.getValue());
        });


        model.getNewsShortList().observe(this, (PagedList<NewsShort> newsShorts) -> {
            adapter.submitList(model.getNewsShortList().getValue());
        });


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private NewsShortViewModel getViewModel(){
        NewsShortRepository repo = new NewsShortRepository();
        idCategory = getIntent().getLongExtra(CategoriesAdapter.CATEGORY_ID,ID_CATEGORY);
        Log.d(TAG, "get Extra Category id = " + idCategory);

        Object[] params = {repo,idCategory};
        model = ViewModelParameterizedProvider.ofActivity(this,params).get(NewsShortViewModel.class);

        return model;
    }
}
