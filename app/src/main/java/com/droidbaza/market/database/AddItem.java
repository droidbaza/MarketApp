package com.droidbaza.market.database;

import android.content.Context;
import android.preference.PreferenceManager;

import com.droidbaza.market.pojo.Product;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by droidbaza on 25/11/19.
 */


public class AddItem {
    private Context context;
    private Product item;

    public AddItem(Context context, Product item) {
        this.context = context;
        this.item = item;
    }

    public void addItem() {
        Single.fromCallable(() -> {
            PreferenceManager
                    .getDefaultSharedPreferences(context)
                    .edit().putBoolean("KEY_CHECK" + item.getSku(), true).apply();
            return DbClient.getInstance(context).getMyDb().myDao().insert(item);
        }).subscribeOn(Schedulers.io())
                .subscribe();
    }
}
