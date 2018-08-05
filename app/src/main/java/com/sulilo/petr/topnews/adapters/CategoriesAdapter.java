package com.sulilo.petr.topnews.adapters;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sulilo.petr.topnews.R;
import com.sulilo.petr.topnews.activities.NewsFullActivity;
import com.sulilo.petr.topnews.activities.NewsShortActivity;
import com.sulilo.petr.topnews.entity.Category;

import java.util.List;

import static com.sulilo.petr.topnews.utilities.NewsApp.getContext;


public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    static String TAG = "CategoriesAdapter";
    public static String CATEGORY_ID = "categoryId";

    private List<Category> categories;

    public CategoriesAdapter(List<Category> categories) {
        this.categories = categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.tvCategory.setText(category.getName());
        holder.tvCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick Category id = " + category.getId());
                Context context = getContext();

                Intent intent = new Intent(context, NewsShortActivity.class);
                intent.putExtra(CATEGORY_ID,category.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (categories == null){
            return 0;
        }
        return categories.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategory;


        public ViewHolder(View itemView) {
            super(itemView);
            tvCategory = itemView.findViewById(R.id.CategoryCategories);
        }
    }
}
