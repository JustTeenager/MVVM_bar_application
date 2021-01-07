package com.example.mvvm_test_application.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.ViewModel;

public class DrinkTypeViewModel extends BaseObservable {
    private static final int CODE_SCOTCH = 0;
    private static final int CODE_VODKA = 1;
    private static final int CODE_CHAMPAGNE = 2;
    private Callback callback;

    public DrinkTypeViewModel(Callback callback){
        this.callback = callback;
    }


    public void onScotchClick(){
        callback.onDrinkTypeClicked(CODE_SCOTCH);
    }

    public void onVodkaClick(){
        callback.onDrinkTypeClicked(CODE_VODKA);
    }

    public void onChampagneClick(){
        callback.onDrinkTypeClicked(CODE_CHAMPAGNE);
    }

    public interface Callback{
        void onDrinkTypeClicked(int position);
    }
}
