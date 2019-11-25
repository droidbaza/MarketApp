package com.droidbaza.market.database;

import com.droidbaza.market.pojo.Product;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Created by droidbaza on 25/11/19.
 */


@Database(entities = {Product.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract MyDao myDao();
}