package com.droidbaza.market.adapters;

import android.content.Context;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.droidbaza.market.R;
import com.droidbaza.market.pojo.Product;
import com.droidbaza.market.database.AddItem;
import com.droidbaza.market.database.DeleteItem;

import java.util.List;

/**
 * Created by droidbaza on 25/11/19.
 */


public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private List<Product> products;
    private Context context;

    public ProductsAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, price;
        ImageView image;
        CheckBox checkBox;

        ViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.name);
            price = view.findViewById(R.id.price);
            image = view.findViewById(R.id.image);
            checkBox = view.findViewById(R.id.checkBox);

        }
    }

    @Override
    public void onBindViewHolder(ProductsAdapter.ViewHolder holder, int position) {

        Product item = products.get(position);
        String name = item.getName() + " ";
        String price = item.getSalePrice() + " $";

        holder.name.setText(name);
        holder.price.setText(price);

        Glide
                .with(context)
                .load(item.getImage())
                .into(holder.image);

        final String key = "KEY_CHECK" + item.getSku();
        boolean checked = PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(key, false);

        holder.checkBox.setChecked(checked);
        Animation shake = AnimationUtils.loadAnimation(context, R.anim.shakeanimation);

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {
                holder.checkBox.startAnimation(shake);
                new AddItem(context, item).addItem();

            } else {
                holder.checkBox.startAnimation(shake);
                new DeleteItem(context, item).deleteItem();
            }
        });

    }

    @NonNull
    @Override
    public ProductsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductsAdapter.ViewHolder(itemView);
    }


    @Override
    public int getItemCount() {
        return products.size();
    }
}

