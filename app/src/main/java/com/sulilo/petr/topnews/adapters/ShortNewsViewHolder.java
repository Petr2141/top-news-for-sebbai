package com.sulilo.petr.topnews.adapters;

import android.app.Application;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sulilo.petr.topnews.R;
import com.sulilo.petr.topnews.activities.NewsFullActivity;
import com.sulilo.petr.topnews.activities.NewsShortActivity;
import com.sulilo.petr.topnews.entity.NewsShort;

import java.text.ParseException;
import java.util.Date;


public class ShortNewsViewHolder extends RecyclerView.ViewHolder {

    private TextView tvDate;
    private TextView tvTitle;
    private TextView tvShortNews;

    ShortNewsViewHolder(View itemView) {
        super(itemView);

        tvDate      = itemView.findViewById(R.id.textViewDate);
        tvTitle     = itemView.findViewById(R.id.textViewTitle);
        tvShortNews = itemView.findViewById(R.id.editTextShortCont);
    }

    void bindTo(NewsShort news) {
        itemView.setTag(news.getId());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'");

        try {
            Date date = format.parse(news.getDate());
            tvDate.setText(date.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        tvTitle.setText(news.getTitle());
        tvShortNews.setText(news.getShortDescription());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), NewsFullActivity.class);

                intent.putExtra(NewsFullActivity.ID_FULL_NEWS,news.getId());
                intent.putExtra(NewsFullActivity.TITLE,       news.getTitle());
                intent.putExtra(NewsFullActivity.SHORT_NEWS,  news.getShortDescription());

                itemView.getContext().startActivity(intent);
            }
        });
    }

    void clear() {
        itemView.invalidate();
        tvDate.invalidate();
        tvTitle.invalidate();
        tvShortNews.invalidate();
    }
}
