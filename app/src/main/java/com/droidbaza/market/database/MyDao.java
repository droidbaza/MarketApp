package com.droidbaza.market.database;

import com.droidbaza.market.pojo.Product;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by droidbaza on 25/11/19.
 */


@Dao
public interface MyDao {

    @Query("SELECT * FROM product")
    LiveData<List<Product>> getAll();

    @Insert
    long insert(Product product);

    @Delete
    void delete(Product product);

    @Update
    void update(Product product);
}
