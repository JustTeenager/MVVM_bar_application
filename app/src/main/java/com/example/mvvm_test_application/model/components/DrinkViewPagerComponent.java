package com.example.mvvm_test_application.model.components;

import com.example.mvvm_test_application.model.dagger_models.BindingModule;
import com.example.mvvm_test_application.model.dagger_models.FragmentPagerAdapterModule;
import com.example.mvvm_test_application.view.DrinkViewPagerFragment;

import javax.inject.Inject;

import dagger.Component;

@Component(modules = {FragmentPagerAdapterModule.class, BindingModule.class})
public interface DrinkViewPagerComponent {
    void inject(DrinkViewPagerFragment fragment);
}
