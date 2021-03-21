package com.example.mvvm_test_application.model.components;


import com.example.mvvm_test_application.databinding.FragmentDrinkTypeBinding;
import com.example.mvvm_test_application.model.dagger_models.BindingModule;
import com.example.mvvm_test_application.model.dagger_models.ViewModelsModule;
import com.example.mvvm_test_application.view.DrinkTypeFragment;
import com.example.mvvm_test_application.viewmodel.DrinkTypeViewModel;

import dagger.Component;

@Component(modules = {BindingModule.class, ViewModelsModule.class})
public interface DrinkTypeComponent {
    void inject(DrinkTypeFragment fragment);
}
