package com.example.mvvm_test_application.model.dagger_models;

import com.example.mvvm_test_application.utils.RetrofitSingleton;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RetrofitSingletonModule {
    @Provides
    @Singleton
    public RetrofitSingleton provideRetrofitSingleton(){
        return RetrofitSingleton.newInstance();
    }
}
