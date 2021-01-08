package com.example.mvvm_test_application.utils;

import com.example.mvvm_test_application.model.Cocktail;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    public static final String SERVER_URL="http://a0501921.xsph.ru";
    private Retrofit mRetrofit;
    private static List<Cocktail> mCocktailsList=new ArrayList<>();
    private static RetrofitSingleton mRetrofitSingleton;

    private RetrofitSingleton(){
        Gson gson= new GsonBuilder().setLenient().create();
        mRetrofit=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(SERVER_URL)
                .build();
    }

    public static RetrofitSingleton newInstance() {
        if (mRetrofitSingleton == null) {
            mRetrofitSingleton = new RetrofitSingleton();
        }
        return mRetrofitSingleton;
    }

    public static List<Cocktail> getCocktailsFilteredList(String type) {
        List<Cocktail> list=new ArrayList<>();
        for (int i=0;i<mCocktailsList.size();i++){
            if (mCocktailsList.get(i).getType().equals(type)) list.add(mCocktailsList.get(i));
        }
        return list;
    }

    public static void setCocktailsList(List<Cocktail> mCocktailsList) {
        RetrofitSingleton.mCocktailsList = mCocktailsList;
    }

    public CocktailsAPI getCocktailsApi(){
        return mRetrofit.create(CocktailsAPI.class);
    }

}
