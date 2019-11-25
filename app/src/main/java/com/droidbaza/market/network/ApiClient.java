package com.droidbaza.market.network;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by droidbaza on 25/11/19.
 */


class ApiClient {

    static Retrofit getApiClient(Context context) {

        File cacheDirectory = new File(context.getCacheDir().getAbsolutePath(), "OKHttpCache");

        OkHttpClient client = new OkHttpClient
                .Builder()
                .cache(new Cache(cacheDirectory, Integer.MAX_VALUE))
                .addNetworkInterceptor(chain -> {
                    Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .header("Cache-Control", "public, max-age=432000")
                            .header("Pragma", "")
                            .build();
                })
                .build();


        return new Retrofit.Builder()
                .baseUrl("https://api.bestbuy.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

    }

}
