package com.example.mvvm_test_application.model.components;

import com.example.mvvm_test_application.model.CocktailAdapter;
import com.example.mvvm_test_application.model.dagger_models.BindingModule;
import com.example.mvvm_test_application.model.dagger_models.ViewModelsModule;

import dagger.Component;

@Component(modules = { ViewModelsModule.class})
public interface CocktailHolderComponent {

    void inject(CocktailAdapter.CocktailHolder holder);
}
