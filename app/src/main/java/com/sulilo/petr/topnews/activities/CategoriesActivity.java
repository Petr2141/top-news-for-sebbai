package com.sulilo.petr.topnews.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.sulilo.petr.topnews.R;
import com.sulilo.petr.topnews.adapters.CategoriesAdapter;
import com.sulilo.petr.topnews.entity.Category;
import com.sulilo.petr.topnews.viewmodels.CategoriesViewModel;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Category> categories;

    static String TAG = "CategoriesActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categories = new ArrayList<>();
        final CategoriesAdapter adapter = new CategoriesAdapter(categories);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerCategoryes);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        getViewModel(adapter,recyclerView);

    }

    private CategoriesViewModel getViewModel(CategoriesAdapter adap,RecyclerView recycler){
        CategoriesViewModel model = ViewModelProviders.of(this).get(CategoriesViewModel.class);
        model.getCategories().observe(this, categories -> {
            categories = model.getCategories().getValue();
            adap.setCategories(categories);
            recycler.getAdapter().notifyDataSetChanged();
            Log.d(TAG,"Call observe. Update UI. categories.size =" + categories.size());
        } );
        return model;
    }
}
