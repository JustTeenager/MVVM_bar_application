package com.example.mvvm_test_application.model.components;


import com.example.mvvm_test_application.model.dagger_models.MainActivityModule;
import com.example.mvvm_test_application.view.MainActivity;

import dagger.Component;

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
