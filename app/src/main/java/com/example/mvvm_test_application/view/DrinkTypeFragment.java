package com.example.mvvm_test_application.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.mvvm_test_application.databinding.FragmentDrinkTypeBinding;
import com.example.mvvm_test_application.model.components.DaggerDrinkTypeComponent;
import com.example.mvvm_test_application.model.dagger_models.BindingModule;
import com.example.mvvm_test_application.model.dagger_models.ContextAndCallbacksModule;
import com.example.mvvm_test_application.model.dagger_models.ViewModelsModule;
import com.example.mvvm_test_application.viewmodel.DrinkTypeViewModel;

import javax.inject.Inject;

public class DrinkTypeFragment extends Fragment {

    public static DrinkTypeFragment newInstance() {

        Bundle args = new Bundle();

        DrinkTypeFragment fragment = new DrinkTypeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    DrinkTypeViewModel model;
    @Inject
    FragmentDrinkTypeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //final FragmentDrinkTypeBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_drink_type,container,false);
        DaggerDrinkTypeComponent.builder().bindingModule(new BindingModule(container)).contextAndCallbacksModule(new ContextAndCallbacksModule(getActivity()))
                .build().inject(this);
        binding.setViewModel(model);
        return binding.getRoot();
    }


}
