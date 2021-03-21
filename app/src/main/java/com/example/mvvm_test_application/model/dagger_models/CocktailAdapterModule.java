package com.example.mvvm_test_application.model.dagger_models;


import androidx.fragment.app.FragmentActivity;

import com.example.mvvm_test_application.model.Cocktail;
import com.example.mvvm_test_application.model.CocktailAdapter;
import com.example.mvvm_test_application.utils.RetrofitSingleton;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextAndCallbacksModule.class)
public class CocktailAdapterModule {

    private List<Cocktail> cocktails;
    private CocktailAdapter.Callback callback;

    @Provides
    public CocktailAdapter CocktailAdapterModule(List<Cocktail> cocktails,int position,CocktailAdapter.Callback callback){
        //this.activity = activity;
        this.cocktails = cocktails;
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
