package com.example.mvvm_test_application.model.components;

import com.example.mvvm_test_application.model.dagger_models.DownloaderServiceModule;
import com.example.mvvm_test_application.model.dagger_models.RetrofitSingletonModule;
import com.example.mvvm_test_application.utils.DownloaderService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DownloaderServiceModule.class)
public interface DownloaderServiceComponent {
    void inject(DownloaderService service);
}
