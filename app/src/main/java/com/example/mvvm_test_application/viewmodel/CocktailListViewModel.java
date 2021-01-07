package com.example.mvvm_test_application.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.ViewModel;

public class CocktailListViewModel extends BaseObservable {
    private String title;

    @Bindable
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
