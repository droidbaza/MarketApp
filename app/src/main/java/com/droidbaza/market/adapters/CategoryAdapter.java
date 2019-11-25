package com.droidbaza.market.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.droidbaza.market.Contract;
import com.droidbaza.market.R;
import com.droidbaza.market.pojo.Category;

import java.util.List;

/**
 * Created by droidbaza on 25/11/19.
 */


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<Category> categories;
    private Context context;
    private Contract.CategoryListener listener;

    public CategoryAdapter(List<Category> categories, Context context, Contract.CategoryListener listener) {
        this.categories = categories;
        this.context = context;
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView image;

        ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.nameCategory);
            image = view.findViewById(R.id.imageCategory);
        }
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.ViewHolder holder, int position) {
        Category item = categories.get(position);
        String name = item.getName();
        holder.name.setText(name);
        Glide.with(context).load(item.getImageUri()).into(holder.image);
        holder.itemView.setOnClickListener(v -> listener.onCategoryClicked(item));

    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);
        return new CategoryAdapter.ViewHolder(itemView);
    }


    @Override
    public int getItemCount() {
        return categories.size();
    }
}
