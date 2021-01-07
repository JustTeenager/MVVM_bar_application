package com.example.mvvm_test_application.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_test_application.model.Cocktail;

public class CocktailDataViewModel extends ViewModel {
    private final MutableLiveData<Cocktail> liveData = new MutableLiveData<>();

    public LiveData<Cocktail> getLiveData() {
        return liveData;
    }

    public void setLiveData(Cocktail cocktail){
        liveData.setValue(cocktail);
    }

}
