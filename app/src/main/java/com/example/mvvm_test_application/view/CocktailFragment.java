package com.example.mvvm_test_application.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.mvvm_test_application.R;
import com.example.mvvm_test_application.databinding.FragmentCocktailBinding;
import com.example.mvvm_test_application.model.Cocktail;
import com.example.mvvm_test_application.model.components.DaggerCocktailFragmentComponent;
import com.example.mvvm_test_application.model.dagger_models.BindingModule;
import com.example.mvvm_test_application.model.dagger_models.ContextAndCallbacksModule;
import com.example.mvvm_test_application.utils.DownloaderService;
import com.example.mvvm_test_application.viewmodel.CocktailViewModel;
import com.example.mvvm_test_application.viewmodel.CocktailDataViewModel;

import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;


public class CocktailFragment extends Fragment {

    @Inject
    FragmentCocktailBinding binding;

    @Inject
    CocktailViewModel cocktailModel;

    @Inject
    DownloaderService.UILoadingCommander downloadCallback;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DaggerCocktailFragmentComponent.builder().bindingModule(new BindingModule(container))
                .contextAndCallbacksModule(new ContextAndCallbacksModule(getActivity())).build()
                .inject(this);
        CocktailDataViewModel controller = ViewModelProviders.of(getActivity()).get(CocktailDataViewModel.class);
        controller.getLiveData().observe(this, new Observer<Cocktail>() {
            @Override
            public void onChanged(final Cocktail cocktail) {
                cocktailModel.setCocktail(cocktail);
                Glide.with(CocktailFragment.this).load(cocktail.getUrlImage()).into(binding.photoCocktail);

            }
        });
        binding.setViewModel(cocktailModel);
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
