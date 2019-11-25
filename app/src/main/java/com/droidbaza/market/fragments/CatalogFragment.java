package com.droidbaza.market.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.droidbaza.market.adapters.ProductsAdapter;
import com.droidbaza.market.R;
import com.droidbaza.market.pojo.Product;
import com.droidbaza.market.network.GetProducts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by droidbaza on 25/11/19.
 */


public class CatalogFragment extends Fragment {

    private List<Product> products = new ArrayList<>();
    private ProductsAdapter adapter;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_catalog, container, false);
        initView(v);

        return v;
    }

    private void initView(View v) {
        RecyclerView recyclerView = v.findViewById(R.id.recyclerview);
        adapter = new ProductsAdapter(products, getContext());
        GridLayoutManager lm = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
        progressBar = v.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        getProducts();

    }

    private void getProducts() {
        assert getArguments() != null;
        String args = getArguments().getString("KEY");
        new GetProducts(getContext(), progressBar, adapter, products, args).getData();
    }
}
