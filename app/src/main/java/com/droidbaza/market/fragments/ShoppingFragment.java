package com.droidbaza.market.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.droidbaza.market.R;
import com.droidbaza.market.adapters.ShoppingAdapter;
import com.droidbaza.market.database.DbClient;
import com.droidbaza.market.pojo.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by droidbaza on 25/11/19.
 */


public class ShoppingFragment extends Fragment {

    public static ShoppingFragment newInstance() {
        return new ShoppingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_shopping, container, false);
        getData(v);
        return v;
    }

    private void getData(View v) {
        RecyclerView rv = v.findViewById(R.id.rvShop);
        ImageView imageView = v.findViewById(R.id.gif);
        TextView orderPrice = v.findViewById(R.id.orderPrice);
        Button makeOrder = v.findViewById(R.id.makeOrder);
        CoordinatorLayout orderLayout = v.findViewById(R.id.orderLayout);
        LinearLayout noProducts = v.findViewById(R.id.no_products);

        List<Product> productList = new ArrayList<>();
        ShoppingAdapter adapter = new ShoppingAdapter(productList, getContext(), v);
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);

        Glide
                .with(Objects.requireNonNull(getContext()))
                .asGif()
                .load(R.raw.cat2)
                .into(imageView);

        DbClient
                .getInstance(getContext())
                .getMyDb()
                .myDao()
                .getAll().observe(this, stations -> {

            if (stations.size() > 0) {
                noProducts.setVisibility(View.INVISIBLE);
                orderLayout.setVisibility(View.VISIBLE);
            } else {
                noProducts.setVisibility(View.VISIBLE);
                orderLayout.setVisibility(View.GONE);
            }

            makeOrder.setOnClickListener(v1 -> Toast.makeText(getContext(),
                    getContext().getString(R.string.order_toast), Toast.LENGTH_LONG).show());

            float sum = 0;
            for (int i = 0; i < stations.size(); i++) {
                Product item = stations.get(i);
                float price = item.getSalePrice() * item.getCount();
                sum = sum + price;
            }
            orderPrice.setText(String.valueOf(sum));

            adapter.setProducts(stations);
            adapter.notifyDataSetChanged();
            rv.setAdapter(adapter);

        });

    }
}
