package com.example.mvvm_test_application.model.components;

import com.example.mvvm_test_application.model.CocktailAdapter;
import com.example.mvvm_test_application.model.dagger_models.BindingModule;
import com.example.mvvm_test_application.model.dagger_models.ContextAndCallbacksModule;

import dagger.Component;

@Component(modules = {BindingModule.class, ContextAndCallbacksModule.class})
public interface CocktailAdapterComponent {

    void inject(CocktailAdapter adapter);
}
