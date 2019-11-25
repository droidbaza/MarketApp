package com.droidbaza.market.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.droidbaza.market.R;
import com.droidbaza.market.database.DbClient;
import com.droidbaza.market.pojo.Product;
import com.droidbaza.market.database.AddItem;
import com.droidbaza.market.database.DeleteItem;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by droidbaza on 25/11/19.
 */

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ViewHolder> {

    private View shopView;
    private int count;
    private List<Product> products;
    private Context context;

    public ShoppingAdapter(List<Product> products, Context context, View shopView) {
        this.products = products;
        this.context = context;
        this.shopView = shopView;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, price, count;
        ImageView image, icAdd, icRemoved;
        Button del;

        ViewHolder(View v) {
            super(v);

            name = v.findViewById(R.id.nameShop);
            price = v.findViewById(R.id.priceShop);
            image = v.findViewById(R.id.imageShop);
            del = v.findViewById(R.id.del);
            icAdd = v.findViewById(R.id.ic_add);
            icRemoved = v.findViewById(R.id.ic_remove);
            count = v.findViewById(R.id.product_count);

        }
    }


    @Override
    public void onBindViewHolder(ShoppingAdapter.ViewHolder holder, int position) {

        Product item = products.get(position);
        String name = item.getName();
        final int count = item.getCount();
        Float price = item.getSalePrice();
        String finalPrice = price * count + " $";

        holder.name.setText(name);
        holder.price.setText(finalPrice);
        holder.count.setText(String.valueOf(count));

        Glide
                .with(context)
                .load(item.getImage())
                .into(holder.image);

        holder.icAdd.setOnClickListener(view -> {

            if (count >= 1) {
                int a = count + 1;

                holder.count.setText(String.valueOf(a));
                holder.count.setVisibility(View.VISIBLE);
                item.setCount(a);

                Completable.fromAction(() -> DbClient.getInstance(context)
                        .getMyDb().myDao().update(item)).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe();
            }
        });


        holder.icRemoved.setOnClickListener(view -> {

            if (count > 1) {
                int j = count - 1;
                holder.count.setVisibility(View.VISIBLE);
                holder.icRemoved.setVisibility(View.VISIBLE);
                item.setCount(j);

                Completable.fromAction(() -> DbClient.getInstance(context)
                        .getMyDb().myDao().update(item)).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe();
            } else {
                holder.icRemoved.setVisibility(View.GONE);
            }

        });

        holder.del.setOnClickListener(v -> {
            deleteItem(position);
        });
    }

    private void deleteItem(int position) {
        Product item = products.get(position);
        CoordinatorLayout coordinatorLayout = shopView.findViewById(R.id.snackbar_layout);
        new DeleteItem(context, item).deleteItem();

        Snackbar.make(coordinatorLayout, context.getString(R.string.snack_bar_text), Snackbar.LENGTH_LONG)
                .setAction(context.getString(R.string.snack_bar_cancel), v -> new AddItem(context, item).addItem())
                .show();
    }

    @NonNull
    @Override
    public ShoppingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product_shopping, parent, false);
        return new ShoppingAdapter.ViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

}

