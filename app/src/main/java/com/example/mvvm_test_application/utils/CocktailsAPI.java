package com.example.mvvm_test_application.utils;

import com.example.mvvm_test_application.model.Cocktail;

import java.util.List;

import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CocktailsAPI {

    @GET("/папка")
    List<Cocktail> getCocktails(String type);

    @POST("/папка")
    @FormUrlEncoded
    void addCocktail(Cocktail cocktail);
}
