package com.droidbaza.market.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.droidbaza.market.database.DbClient;
import com.droidbaza.market.pojo.Product;

import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by droidbaza on 25/11/19.
 */


public class DeleteItem {
    private Context context;
    private Product item;

    public DeleteItem(Context context, Product item) {
        this.context = context;
        this.item = item;
    }

    public void deleteItem() {
        Completable.fromAction(() -> {
            PreferenceManager
                    .getDefaultSharedPreferences(context)
                    .edit().putBoolean("KEY_CHECK" + item.getSku(), false).apply();
            DbClient.getInstance(context).getMyDb().myDao().delete(item);

        }).subscribeOn(Schedulers.io()).subscribe();
    }
}
