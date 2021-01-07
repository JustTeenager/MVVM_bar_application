package com.example.mvvm_test_application.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.mvvm_test_application.R;
import com.example.mvvm_test_application.databinding.FragmentCocktailBinding;
import com.example.mvvm_test_application.model.Cocktail;
import com.example.mvvm_test_application.viewmodel.CocktailViewModel;
import com.example.mvvm_test_application.viewmodel.CocktailDataViewModel;

public class CocktailFragment extends Fragment {
    private FragmentCocktailBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cocktail, container, false);
        final CocktailViewModel model = new CocktailViewModel();
        CocktailDataViewModel controller = ViewModelProviders.of(getActivity()).get(CocktailDataViewModel.class);
        controller.getLiveData().observe(this, new Observer<Cocktail>() {
            @Override
            public void onChanged(Cocktail cocktail) {
                model.setCocktail(cocktail);
                Glide.with(CocktailFragment.this).load(cocktail.getUrlImage()).into(binding.photoCocktail);
            }
        });
        model.setCallback((CocktailViewModel.Callback) getActivity());
        binding.setViewModel(model);
        return binding.getRoot();
    }



}
