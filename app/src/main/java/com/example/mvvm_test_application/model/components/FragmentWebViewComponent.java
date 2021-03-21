package com.example.mvvm_test_application.model.components;

import com.example.mvvm_test_application.model.dagger_models.BindingModule;
import com.example.mvvm_test_application.view.CocktailWebViewFragment;

import dagger.Component;

@Component(modules = BindingModule.class)
public interface FragmentWebViewComponent {

    void inject(CocktailWebViewFragment cocktailWebViewFragment);
}
