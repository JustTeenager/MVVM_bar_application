package com.example.mvvm_test_application.model.dagger_models;

import com.example.mvvm_test_application.utils.DownloaderService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = RetrofitSingletonModule.class)
public class DownloaderServiceModule {
    //TODO МБ поставить провайдер ретрофита

    @Provides
    @Singleton
    public ExecutorService provideDownloaderService(){
        return Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread=new Thread(r);
                thread.setPriority(4);
                return thread;
            }
        });
    }
}
