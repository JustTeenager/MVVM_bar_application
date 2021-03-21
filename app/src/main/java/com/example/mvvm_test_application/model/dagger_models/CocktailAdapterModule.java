package com.example.mvvm_test_application.model.dagger_models;


import androidx.fragment.app.FragmentActivity;

import com.example.mvvm_test_application.model.Cocktail;
import com.example.mvvm_test_application.model.CocktailAdapter;
import com.example.mvvm_test_application.utils.RetrofitSingleton;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ContextAndCallbacksModule.class})
public class CocktailAdapterModule {

    private CocktailAdapter.Callback callback;
    private int position;


    public CocktailAdapterModule(int position){
        this.position = position;
    }

    @Provides
    public CocktailAdapter provideCocktailAdapter(CocktailAdapter.Callback callback){
        //this.activity = activity;
        this.callback = callback;
        if (position == 0) {
            return new CocktailAdapter(RetrofitSingleton.getCocktailsFilteredList("Виски"));
            //Виски
        } else if (position == 1) {
            return new CocktailAdapter(RetrofitSingleton.getCocktailsFilteredList("Водка"));
            //Водка
        } else {
            return new CocktailAdapter(RetrofitSingleton.getCocktailsFilteredList("Шампанское"));
            //Шампанское
        }
    }

}
