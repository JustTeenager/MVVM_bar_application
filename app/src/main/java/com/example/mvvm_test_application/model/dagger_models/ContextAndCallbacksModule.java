package com.example.mvvm_test_application.model.dagger_models;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.example.mvvm_test_application.model.CocktailAdapter;
import com.example.mvvm_test_application.utils.DownloaderService;
import com.example.mvvm_test_application.viewmodel.CocktailViewModel;
import com.example.mvvm_test_application.viewmodel.DrinkTypeViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextAndCallbacksModule {
    @NonNull
    private FragmentActivity activity;

    public ContextAndCallbacksModule(FragmentActivity activity){
        this.activity=activity;
    }

    @Provides
    public DrinkTypeViewModel.Callback provideDrinkTypeViewModelCallback(){
        return (DrinkTypeViewModel.Callback) activity;
    }

    @Provides
    public CocktailViewModel.Callback provideCocktailViewModelCallback(){
        return (CocktailViewModel.Callback) activity;
    }

    @Provides
    public CocktailAdapter.Callback provideCocktailAdapterCallback(){
        return (CocktailAdapter.Callback) activity;
    }

    @Provides
    public DownloaderService.UILoadingCommander provideUILoadingCommander(){
        return (DownloaderService.UILoadingCommander) activity;
    }


    @Provides
    public FragmentActivity provideActivity(){
        return activity;
    }
}
