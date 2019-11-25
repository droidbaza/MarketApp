package com.droidbaza.market.pojo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by droidbaza on 25/11/19.
 */


@Entity
public class Product {

    @SerializedName("sku")
    @Expose
    @PrimaryKey
    private Integer sku;
    @SerializedName("name")
    @Expose
    @ColumnInfo
    private String name;
    @SerializedName("salePrice")
    @Expose
    @ColumnInfo
    private Float salePrice;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @ColumnInfo
    private int count = 1;

    @SerializedName("image")
    @Expose
    @ColumnInfo
    private String image;

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Float salePrice) {
        this.salePrice = salePrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}