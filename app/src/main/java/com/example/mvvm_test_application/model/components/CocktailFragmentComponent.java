package com.example.mvvm_test_application.model.components;

import com.example.mvvm_test_application.model.dagger_models.BindingModule;
import com.example.mvvm_test_application.view.CocktailFragment;

import dagger.Component;

@Component(modules = BindingModule.class)
public interface CocktailFragmentComponent {
    void inject(CocktailFragment fragment);
}
