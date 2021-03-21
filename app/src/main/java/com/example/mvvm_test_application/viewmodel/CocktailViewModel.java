package com.example.mvvm_test_application.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.mvvm_test_application.R;
import com.example.mvvm_test_application.model.Cocktail;

import javax.inject.Inject;

import dagger.Provides;

public class CocktailViewModel extends BaseObservable {

    private Cocktail mCocktail;
    @Inject
    Callback callback;

    @Inject
    public CocktailViewModel(){}

    public void setCocktail(Cocktail cocktail){
        this.mCocktail=cocktail;
    }

    public void setCallback(Callback callback){ this.callback = callback;}

    @Bindable
    public Cocktail getCocktail() {
        return mCocktail;
    }


    @Bindable
    public String getCockTailName(){
        return mCocktail.getName();
    }


    public String getCockTailStructure(Context context, String structure){
        return context.getResources().getString(R.string.structure_title)+structure;
    }

    @Bindable
    public String getCocktailAlcoholable() {
        return mCocktail.getAlcoholable()+"%";
    }

    public String isHasIce(Context context,boolean isIce){
        return (isIce ? context.getResources().getString(R.string.with_ice):
                context.getResources().getString(R.string.without_ice));
    }

    public void openWebSite(){
        callback.openWebSite(mCocktail.getUrlSite());
    }

    public interface Callback{
        void openWebSite(String url);
    }

}
