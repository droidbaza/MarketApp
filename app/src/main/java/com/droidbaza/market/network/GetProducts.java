package com.droidbaza.market.network;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.droidbaza.market.adapters.ProductsAdapter;
import com.droidbaza.market.pojo.Goods;
import com.droidbaza.market.pojo.Product;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by droidbaza on 25/11/19.
 */


public class GetProducts {
    private Context context;
    private ProgressBar progressBar;
    private ProductsAdapter adapter;
    private List<Product> products;
    private String args;

    public GetProducts(Context context, ProgressBar progressBar, ProductsAdapter adapter, List<Product> products, String args) {
        this.context = context;
        this.progressBar = progressBar;
        this.adapter = adapter;
        this.products = products;
        this.args = args;
    }


    public void getData() {
        ApiClient.getApiClient(context).create(GoodsApi.class)
                .getGoods(args).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Goods>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(Goods goods) {

                        List<Product> productList = goods.getProducts();
                        products.addAll(productList);
                        adapter.notifyDataSetChanged();
                        progressBar.setVisibility(View.INVISIBLE);

                    }

                    @Override
                    public void onError(Throwable e) {

                        Toast.makeText(context, "ERROR" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
