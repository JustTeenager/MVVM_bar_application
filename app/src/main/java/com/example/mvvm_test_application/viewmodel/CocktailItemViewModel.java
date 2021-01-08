package com.example.mvvm_test_application.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.mvvm_test_application.R;
import com.example.mvvm_test_application.model.Cocktail;
import com.example.mvvm_test_application.view.MainActivity;

public class CocktailItemViewModel extends BaseObservable{


    private Cocktail mCocktail;

    public void setCocktail(Cocktail cocktail){
        this.mCocktail=cocktail;
    }


    @Bindable
    public Cocktail getCocktail() {
        return mCocktail;
    }


    @Bindable
    public String getCockTailName(){
        return mCocktail.getName();
    }


    public String getCockTailStructure(Context context,String structure){
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
}
