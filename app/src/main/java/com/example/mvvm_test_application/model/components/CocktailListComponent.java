package com.example.mvvm_test_application.model.components;


import com.example.mvvm_test_application.model.dagger_models.BindingModule;
import com.example.mvvm_test_application.model.dagger_models.CocktailAdapterModule;
import com.example.mvvm_test_application.view.CocktailListFragment;

import dagger.Component;

@Component(modules = {BindingModule.class, CocktailAdapterModule.class})
public interface CocktailListComponent {
    void inject(CocktailListFragment fragment);
}
