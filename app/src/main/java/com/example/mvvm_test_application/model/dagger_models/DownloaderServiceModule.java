package com.example.mvvm_test_application.model.dagger_models;

import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module(includes = RetrofitModule.class)
public class DownloaderServiceModule {
    //TODO МБ поставить провайдер ретрофита

    @Singleton
    @Provides
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
