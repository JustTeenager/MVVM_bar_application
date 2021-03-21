package com.example.mvvm_test_application.model.dagger_models;

import android.content.Context;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvm_test_application.view.CocktailFragment;
import com.example.mvvm_test_application.viewmodel.CocktailDataViewModel;
import com.example.mvvm_test_application.viewmodel.CocktailItemViewModel;
import com.example.mvvm_test_application.viewmodel.CocktailViewModel;
import com.example.mvvm_test_application.viewmodel.DrinkTypeViewModel;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextAndCallbacksModule.class)
public class ViewModelsModule {

    @Provides
    public CocktailDataViewModel provideCocktailDataViewModel(FragmentActivity activity) {
       return ViewModelProviders.of(activity).get(CocktailDataViewModel.class);
    }

    @Provides
    public CocktailItemViewModel provideCocktailItemViewModel(){
       return new CocktailItemViewModel();
    }

    @Provides
    public CocktailViewModel provideCocktailViewModel(CocktailViewModel.Callback callback){
        CocktailViewModel model=new CocktailViewModel();
        model.setCallback(callback);
        return model;
    }

    @Provides
    public DrinkTypeViewModel provideDrinkTypeViewModel(DrinkTypeViewModel.Callback callback){
        return new DrinkTypeViewModel(callback);
    }

}
