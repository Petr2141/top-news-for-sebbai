package com.sulilo.petr.topnews.adapters;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sulilo.petr.topnews.R;
import com.sulilo.petr.topnews.entity.NewsShort;

import static com.sulilo.petr.topnews.utilities.NewsApp.getContext;

/**
 * Created by petr on 11.07.18.
 */

public class ShortNewsAdapter extends PagedListAdapter<NewsShort,ShortNewsViewHolder> {

    public ShortNewsAdapter() {
        super(NewsShort.DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ShortNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.news_item,parent,false);
        return new ShortNewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ShortNewsViewHolder holder, int position) {
        NewsShort newsShort = getItem(position);

        if (newsShort != null){
            holder.bindTo(newsShort);
        }
        else {
            holder.clear();
        }
    }
}
