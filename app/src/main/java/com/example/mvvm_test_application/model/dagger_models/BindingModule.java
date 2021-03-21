package com.example.mvvm_test_application.model.dagger_models;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;

import com.example.mvvm_test_application.R;
import com.example.mvvm_test_application.databinding.FragmentCocktailBinding;
import com.example.mvvm_test_application.databinding.FragmentCocktailListBinding;
import com.example.mvvm_test_application.databinding.FragmentCocktailWebViewBinding;
import com.example.mvvm_test_application.databinding.FragmentDrinkTypeBinding;
import com.example.mvvm_test_application.databinding.FragmentDrinkViewPagerBinding;
import com.example.mvvm_test_application.databinding.ItemCocktailBinding;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextAndCallbacksModule.class)
public class BindingModule {

    @Provides
    public FragmentCocktailBinding provideCocktailBinding(FragmentActivity activity, ViewGroup parent){
        return DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.fragment_cocktail,parent,false);
    }

    @Provides
    public FragmentCocktailListBinding provideCocktailListBinding(FragmentActivity activity, ViewGroup parent){
        return DataBindingUtil.inflate(LayoutInflater.from(activity),R.layout.fragment_cocktail_list,parent,false);
    }

    @Provides
    public FragmentDrinkTypeBinding provideDrinkTypeBindingBinding(FragmentActivity activity, ViewGroup parent){
        return DataBindingUtil.inflate(LayoutInflater.from(activity),R.layout.fragment_drink_type,parent,false);
    }

    @Provides
    public FragmentDrinkViewPagerBinding provideDrinkViewPagerBinding(FragmentActivity activity, ViewGroup parent){
        return DataBindingUtil.inflate(LayoutInflater.from(activity),R.layout.fragment_drink_view_pager,parent,false);
    }

    @Provides
    public ItemCocktailBinding provideItemCocktailBinding(FragmentActivity activity, ViewGroup parent){
        return DataBindingUtil.inflate(LayoutInflater.from(activity),R.layout.item_cocktail,parent,false);
    }

    @Provides
    public FragmentCocktailWebViewBinding provideWebViewBinding(FragmentActivity activity, ViewGroup parent){
        return DataBindingUtil.inflate(LayoutInflater.from(activity),R.layout.fragment_cocktail_web_view,parent,false);
    }

}
