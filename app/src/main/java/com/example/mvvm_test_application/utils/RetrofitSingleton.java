package com.example.mvvm_test_application.utils;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private Retrofit mRetrofit;
    private static RetrofitSingleton mRetrofitSingleton;

    private RetrofitSingleton(){
        Gson gson= new GsonBuilder().setLenient().create();
        mRetrofit=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
                //.baseUrl(null)
                .build();
    }

    public static RetrofitSingleton newInstance() {
        if (mRetrofitSingleton == null) {
            mRetrofitSingleton = new RetrofitSingleton();
        }
        return mRetrofitSingleton;
    }

    public CocktailsAPI getCocktailsApi(){
        return mRetrofit.create(CocktailsAPI.class);
    }

}
