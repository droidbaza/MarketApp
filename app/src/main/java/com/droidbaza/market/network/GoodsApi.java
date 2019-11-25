package com.droidbaza.market.network;

import com.droidbaza.market.pojo.Goods;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by droidbaza on 25/11/19.
 */


public interface GoodsApi {

    @GET("products{path}?&format=json&show=sku,name,salePrice,image&apiKey=8ccddf4rtjz5k5btqam84qak")
    Single<Goods> getGoods(@Path("path") String pathId);
}