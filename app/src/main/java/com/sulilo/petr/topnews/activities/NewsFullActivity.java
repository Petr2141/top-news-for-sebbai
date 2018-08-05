package com.sulilo.petr.topnews.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sulilo.petr.topnews.R;
import com.sulilo.petr.topnews.databinding.ActivityNewsFullBinding;
import com.sulilo.petr.topnews.entity.NewsFull;
import com.sulilo.petr.topnews.viewmodels.NewsFullViewModel;

public class NewsFullActivity extends AppCompatActivity {

    private Long idFullNews;
    public static final String ID_FULL_NEWS = "id_full_news";
    public static final String TITLE        = "title";
    public static final String SHORT_NEWS   = "short_news";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_full);
        idFullNews = getIntent().getLongExtra(ID_FULL_NEWS, 19L);


        ActivityNewsFullBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_news_full);

        //На экране новости должны отображаться название и короткое описание (сразу)
        NewsFull preNews = new NewsFull();
        preNews.setTitle(           getIntent().getStringExtra(TITLE));
        preNews.setShortDescription(getIntent().getStringExtra(SHORT_NEWS));
        binding.setNewsFull(preNews);

        // observer for full news
        NewsFullViewModel model = ViewModelProviders.of(this).get(NewsFullViewModel.class);
        model.getNewsFull(idFullNews).observe(this, newsFull -> {
            newsFull = model.getNewsFull(idFullNews).getValue();
            binding.setNewsFull(newsFull);
        });
    }
}
