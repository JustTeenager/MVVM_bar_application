package com.example.mvvm_test_application.utils;

import com.example.mvvm_test_application.model.Cocktail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface CocktailsAPI {

    @GET("/getCocktail.php")
    Call<List<Cocktail>> getCocktails();
}
